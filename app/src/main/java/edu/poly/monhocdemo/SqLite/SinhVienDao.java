package edu.poly.monhocdemo.SqLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.poly.monhocdemo.helper.DataTimeHelper;
import edu.poly.monhocdemo.model.SinhVien;

public class SinhVienDao {
    private SQLiteDatabase dbs;
    public SinhVienDao(Context context) {
        DbHelper helper = new DbHelper(context);
        this.dbs = helper.getWritableDatabase();
    }

    public long insert(SinhVien emp) {
        ContentValues values = new ContentValues();
        values.put("idsinhvien",emp.getIdsinhvien());
        values.put("hotensv",emp.getHotensv());
        values.put("gioitinhsv",emp.getGioitinhsv());
        values.put("ngaysinhsv", DataTimeHelper.toString(emp.getNgaysinhsv()));
        values.put("diachisv",emp.getDiachisv());
        values.put("gmailsv",emp.getGmailsv());
        values.put("sdtsv",emp.getSdtsv());

        return dbs.insert("sinhvien", null,values);
    }

    public long update(SinhVien emp){
        ContentValues values = new ContentValues();

        values.put("hotensv",emp.getHotensv());
        values.put("gioitinhsv",emp.getGioitinhsv());
        values.put("ngaysinhsv", DataTimeHelper.toString(emp.getNgaysinhsv()));
        values.put("diachisv",emp.getDiachisv());
        values.put("gmailsv",emp.getGmailsv());
        values.put("sdtsv",emp.getSdtsv());

        return dbs.update("sinhvien", values,"idsinhvien = ?", new String[]{emp.getIdsinhvien()});
    }

    public long delete (String idsinhvien){
        return dbs.delete("sinhvien","idsinhvien = ?", new String[]{idsinhvien});
    }


    @SuppressLint("Range")
    public List<SinhVien> get(String sql, String ... selectArgs)  throws ParseException{
        List<SinhVien> list = new ArrayList<SinhVien>();

        Cursor cursor = dbs.rawQuery(sql, selectArgs);

        while(cursor.moveToNext()){
            SinhVien sv = new SinhVien();

            sv.setIdsinhvien(cursor.getString(cursor.getColumnIndex("idsinhvien")));
            sv.setHotensv(cursor.getString(cursor.getColumnIndex("hotensv")));
            sv.setGioitinhsv(cursor.getString(cursor.getColumnIndex("gioitinhsv")));
            sv.setNgaysinhsv(DataTimeHelper.toDate(cursor.getString(cursor.getColumnIndex("ngaysinhsv"))));
            sv.setDiachisv(cursor.getString(cursor.getColumnIndex("diachisv")));
            sv.setGmailsv(cursor.getString(cursor.getColumnIndex("gmailsv")));
            sv.setSdtsv(cursor.getString(cursor.getColumnIndex("sdtsv")));

            list.add(sv);
        }
        return  list;
    }

    public List<SinhVien> getAll() throws ParseException{
        String sql = "SELECT * FROM sinhvien";
        return  get(sql);
    }

    public List<SinhVien> SelectSV(String id)  throws ParseException{
        String sql = "SELECT * FROM sinhvien WHERE idsinhvien LIKE '%"+id+"%'";
        return get(sql);
    }

    public List<SinhVien> getAllBySinhVien(String id)  throws ParseException{
        String sql = "SELECT * FROM sinhvien WHERE id = ?";
        return get(sql,"" + id);
    }

}