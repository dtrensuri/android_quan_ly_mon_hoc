package edu.poly.monhocdemo.SqLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //private static  String DB_NAME = "MonHoc";
//private static  String DB_NAME = "SinhViendb";
private static  String DB_NAME = "KetQuadb";

    private static int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String monhocSQL = "CREATE TABLE monhoc(idmonhoc TEXT PRIMARY KEY, tenmh TEXT, sotin INTEGER, muctieudaura TEXT, hinhthucdanhgia TEXT, nganh TEXT)";
        String sinhvienSQL = "CREATE TABLE sinhvien (idsinhvien TEXT PRIMARY KEY, hotensv TEXT, gioitinhsv TEXT, ngaysinhsv TEXT, diachisv TEXT, gmailsv TEXT, sdtsv TEXT)";
        String chuongTrinhDaoTaoSQL = "CREATE TABLE chuongtrinhdt(idchuongtrinhdt TEXT PRIMARY KEY, tenchuongtrinhdt TEXT, sotinchidt INTEGER, nambatdaudt TEXT)";
        String lophocSQL = "CREATE TABLE lophoc(id INTEGER PRIMARY KEY AUTOINCREMENT, tenlop text , phonghoc TEXT, diachi TEXT )";

        sqLiteDatabase.execSQL(monhocSQL);
        sqLiteDatabase.execSQL(sinhvienSQL);
        sqLiteDatabase.execSQL(lophocSQL);
        sqLiteDatabase.execSQL(chuongTrinhDaoTaoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String monhocSQL = "DROP TABLE IF EXISTS monhoc";
        String sinhvienSQL = "DROP TABLE IF EXISTS sinhvien";
        String chuongTrinhDaoTaoSQL = "DROP TABLE IF EXISTS chuongtrinhdt";
        String lophocSQL = "DROP TABLE IF EXISTS lophoc";

        sqLiteDatabase.execSQL(monhocSQL);
        sqLiteDatabase.execSQL(sinhvienSQL);
        sqLiteDatabase.execSQL(lophocSQL);
        sqLiteDatabase.execSQL(chuongTrinhDaoTaoSQL);

        onCreate(sqLiteDatabase);
    }
}
