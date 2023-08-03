package edu.poly.monhocdemo.SqLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.poly.monhocdemo.model.ChuongTrinhDaoTao;
import edu.poly.monhocdemo.model.SinhVien;

public class ChuongTrinhDaoTao_DB {
    private SQLiteDatabase db;
    public ChuongTrinhDaoTao_DB(Context context) {
        DbHelper helper = new DbHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public long insert(ChuongTrinhDaoTao emp) {
        ContentValues values = new ContentValues();
        values.put("idchuongtrinhdt",emp.getIdchuongtrinhdt());
        values.put("tenchuongtrinhdt",emp.getTenchuongtrinhdt());
        values.put("sotinchidt",emp.getSotinchidt());
        values.put("nambatdaudt",emp.getNambatdaudt());

        return db.insert("chuongtrinhdt", null,values);
    }

    public long delete (String id){
        return db.delete("chuongtrinhdt","idchuongtrinhdt = ?", new String[]{id});
    }

    public long update(ChuongTrinhDaoTao emp){
        ContentValues values = new ContentValues();
        values.put("tenchuongtrinhdt",emp.getTenchuongtrinhdt());
        values.put("sotinchidt",emp.getSotinchidt());
        values.put("nambatdaudt",emp.getNambatdaudt());

        return db.update("chuongtrinhdt", values,"idschuongtrinhdt = ?", new String[]{emp.getIdchuongtrinhdt()});
    }


    @SuppressLint("Range")
    public List<ChuongTrinhDaoTao> get(String sql, String ... selectArgs)  throws ParseException {
        List<ChuongTrinhDaoTao> list = new ArrayList<ChuongTrinhDaoTao>();

        Cursor cursor = db.rawQuery(sql, selectArgs);

        while(cursor.moveToNext()){
            ChuongTrinhDaoTao ctdt = new ChuongTrinhDaoTao();

            ctdt.setIdchuongtrinhdt(cursor.getString(cursor.getColumnIndex("idchuongtrinhdt")));
            ctdt.setTenchuongtrinhdt(cursor.getString(cursor.getColumnIndex("tenchuongtrinhdt")));
            ctdt.setSotinchidt(cursor.getColumnIndex("sotinchidt"));
            ctdt.setNambatdaudt(cursor.getString(cursor.getColumnIndex("nambatdaudt")));

            list.add(ctdt);
        }
        return  list;
    }

    public List<ChuongTrinhDaoTao> getAll() throws ParseException{
        String sql = "SELECT * FROM chuongtrinhdt";
        return  get(sql);
    }
    public List<ChuongTrinhDaoTao> SelectCT(String id)  throws ParseException{
        String sql = "SELECT * FROM chuongtrinhdt WHERE idchuongtrinhdt = '"+id+"'";
        return get(sql);
    }
    public List<ChuongTrinhDaoTao> TimKiem(String id)  throws ParseException{
        String sql = "SELECT * FROM chuongtrinhdt WHERE idchuongtrinhdt LIKE '%"+id+"%'";
        return get(sql);
    }

    public List<ChuongTrinhDaoTao> getAllDieuKien(String id)  throws ParseException{
        String sql = "SELECT * FROM chuongtrinhdt WHERE idchuongtrinhdt = ?";
        return get(sql,"" + id);
    }
}
