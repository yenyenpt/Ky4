package phamthiyen.example.demo_duan.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DbName = "QLTV";
    public static final int  DBversion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DbName,null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableThuThu = "create table ThuThu( maTT text primary key, " +
                " hoTen text not null," +
                " matKhau text not null)";
        sqLiteDatabase.execSQL(tableThuThu);

        String tableThanhVien = "create table ThanhVien( maTV integer primary key autoincrement, " +
                " hoTen text not null," +
                " namSinh text not null)";
        sqLiteDatabase.execSQL(tableThanhVien);

        String tableLoaiSach = "create table LoaiSach( maLoai integer primary key autoincrement, " +
                " tenLoai text not null)";
        sqLiteDatabase.execSQL(tableLoaiSach);

        String tableSach = "create table Sach( maSach integer primary key autoincrement, " +
                " tenSach text not null," +
                " giaThue integer not null," +
                " maLoai integer references LoaiSach(maLoai) )";
        sqLiteDatabase.execSQL(tableSach);

        String tablePhieuMuon = "create table PhieuMuon( maPM integer primary key autoincrement," +
                " maTT text references ThuThu(maTT)," +
                " maTV integer references ThanhVien(maTV)," +
                " maSach integer references Sach(maSach)," +
                " tienThue integer not null," +
                " ngay date not null," +
                " traSach integer not null)";
        sqLiteDatabase.execSQL(tablePhieuMuon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
