package edu.poly.monhocdemo.SqLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.poly.monhocdemo.model.MonHoc;

public class MonHocDao {
    private SQLiteDatabase db;
    public MonHocDao(Context context) {
        DbHelper helper = new DbHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public long insert(MonHoc emp) {
        ContentValues values = new ContentValues();
        values.put("idmonhoc",emp.getIdmonhoc());
        values.put("tenmh",emp.getTenmh());
        values.put("sotin",emp.getSotin());
        values.put("muctieudaura",emp.getMuctieudaura());
        values.put("hinhthucdanhgia",emp.getHinhthucdanhgia());
        values.put("nganh",emp.getNganh());

        return db.insert("monhoc", null,values);
    }

    public long update(MonHoc emp){
        ContentValues values = new ContentValues();

        values.put("tenmh",emp.getTenmh());
        values.put("sotin",emp.getSotin());
        values.put("muctieudaura",emp.getMuctieudaura());
        values.put("hinhthucdanhgia",emp.getHinhthucdanhgia());
        values.put("nganh",emp.getNganh());

        return db.update("monhoc", values,"idmonhoc = ?", new String[]{emp.getIdmonhoc()});
    }

    public long delete (String idmonhoc){
        return db.delete("monhoc","idmonhoc = ?", new String[]{idmonhoc});
    }


    @SuppressLint("Range")
    public List<MonHoc> get(String sql, String ... selectArgs){
        List<MonHoc> list = new ArrayList<MonHoc>();

        Cursor cursor = db.rawQuery(sql, selectArgs);

        while(cursor.moveToNext()){
            MonHoc mh = new MonHoc();

            mh.setIdmonhoc(cursor.getString(cursor.getColumnIndex("idmonhoc")));
            mh.setTenmh(cursor.getString(cursor.getColumnIndex("tenmh")));
            mh.setSotin(cursor.getInt(cursor.getColumnIndex("sotin")));
            mh.setMuctieudaura(cursor.getString(cursor.getColumnIndex("muctieudaura")));
            mh.setHinhthucdanhgia(cursor.getString(cursor.getColumnIndex("hinhthucdanhgia")));
            mh.setNganh(cursor.getString(cursor.getColumnIndex("nganh")));

            list.add(mh);
        }
        return  list;
    }

    public List<MonHoc> getAll(){
        String sql = "SELECT * FROM monhoc";
        return  get(sql);
    }

    public List<MonHoc> SelectMH(String id){
        String sql = "SELECT * FROM monhoc WHERE idmonhoc LIKE '%"+id+"%'";
        return get(sql);
    }

    public List<MonHoc> getAllByMonHoc(String idmonhoc){
        String sql = "SELECT * FROM monhoc WHERE idmonhoc = ?";
        return get(sql,"" + idmonhoc);
    }

    public List<MonHoc> duaDuLieuVao(){
        String sql = "INSERT INTO monhoc VALUES('mh1','Hóa Học',3,'','Viết','Y đa khoa')";
        return get(sql);
    }
}
