package edu.poly.monhocdemo.SqLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.poly.monhocdemo.model.LopHoc;

public class LopHocDao {
    private SQLiteDatabase db;

    public LopHocDao(Context context) {
        DbHelper helper = new DbHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public long insert(LopHoc emp) {
        ContentValues values = new ContentValues();
        values.put("id", emp.getId());
        values.put("tenlop", emp.getTenlop());
        values.put("phonghoc", emp.getPhonghoc());
        values.put("diachi", emp.getDiachi());

        return db.insert("lophoc", null, values);
    }

    @SuppressLint("Range")
    public List<LopHoc> get(String sql, String... selectArgs) {
        List<LopHoc> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()) {
            LopHoc cls = new LopHoc();

            cls.setId(cursor.getInt(cursor.getColumnIndex("id")));
            cls.setTenlop(cursor.getString(cursor.getColumnIndex("tenlop")));
            cls.setPhonghoc(cursor.getString(cursor.getColumnIndex("phonghoc")));
            cls.setDiachi(cursor.getString(cursor.getColumnIndex("diachi")));

            list.add(cls);
        }
        return list;
    }

    public List<LopHoc> getAll() {
        String sql = "SELECT * FROM lophoc";

        return get(sql);
    }

    public int delete(String id) {
        //xóa thông tin trong bảng class theo thông tin từ id
        return db.delete("lophoc", "id=?", new String[]{id});
    }
}