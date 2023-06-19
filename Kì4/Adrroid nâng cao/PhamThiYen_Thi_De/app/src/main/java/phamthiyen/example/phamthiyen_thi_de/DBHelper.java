package phamthiyen.example.phamthiyen_thi_de;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "onThi";
    public static final int DBVersion = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTheLoai = "create table TheLoai(maLoai integer primary key autoincrement," +
                "tenLoai text not null)";
        sqLiteDatabase.execSQL(createTheLoai);

        String createSanPham = "create table SanPham(maSanPham integer primary key autoincrement," +
                "tenSanPham text not null," +
                "soLuongNhap integer not null," +
                "ngayNhap text not null," +
                "donGiaNhap integer not null)";
        sqLiteDatabase.execSQL(createSanPham);

        String createHoaDon = "create table HoaDon(maHoaDon integer primary key autoincrement," +
                "ngayXuat text not null)";
        sqLiteDatabase.execSQL(createHoaDon);

        String createHDCT = "create table HoaDonChiTiet(maHDCT integer primary key autoincrement," +
                "maHD integer references HoaDon(maHD)," +
                "maLoai integer references TheLoai(maLoai)," +
                "tenSanPham  text references SanPham(tenSanPham)," +
                "soLuongXuat  integer not null," +
                "donGiaXuat integer not null," +
                "ngayXuat text not null)";
        sqLiteDatabase.execSQL(createHDCT);

        String insertTheLoai = "insert into TheLoai values(1,'loai1'),(2,'loai1')";
        sqLiteDatabase.execSQL(insertTheLoai);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
