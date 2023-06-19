package phamthiyen.example.onthi1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DbName ="SanPham";
    public static final int DbVersion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DbName, null, DbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTheLoai = "create table TheLoai(maLoai text primary key," +
                "tenLoai text not null)";
        db.execSQL(createTheLoai);


        String createSanPham = "create table SanPham(maSP text primary key," +
                "tenSP text not null," +
                "soLuongNhap integer not null," +
                "donGiaNhap text not null," +
                "ngayNhap text not null," +
                "maLoai  integer references TheLoai (maLoai))";
        db.execSQL(createSanPham);

        String createHoaDon = "Create table HoaDon(maHD integer primary key autoincrement," +
                "ngayXuat text not null," +
                "maSP integer references SanPham(maSP))";
        db.execSQL(createHoaDon);


        String createHoaDonChiTiet = "Create table HoaDonChiTiet(maHDCT integer primary key autoincrement," +
                "maHD integer references HoaDon(maDH)," +
                "maSP integer references SanPham(maSP),"+
                "soLuongXuat integer not null," +
                "donGiaXuat text not null)";
        db.execSQL(createHoaDonChiTiet);

        String insertTheLoai = "insert into TheLoai values('1','Sach')";
        db.execSQL(insertTheLoai);

        String insertTheLoai2 = "insert into TheLoai values('2','Banh')";
        db.execSQL(insertTheLoai2);

        String insertSP = "insert into SanPham values('1','Sach',25,'50000','23-01-2020','1')";
        db.execSQL(insertSP);

        String insertSP2 = "insert into SanPham values('2','Vo',29,'12000','10-09-2019','3')";
        db.execSQL(insertSP2);

        String insertHoaDon = "insert into HoaDon values('1','2023-01-03',2)";
        db.execSQL(insertHoaDon);

        String insertHoaDon2 = "insert into HoaDon values('2','2019-09-12',3)";
        db.execSQL(insertHoaDon2);

        String insertHoaDonChiTiet = "insert into HoaDonChiTiet values(1,2,1,2,'30000')";
        db.execSQL(insertHoaDonChiTiet);

        String insertHoaDonChiTiet2 = "insert into HoaDonChiTiet values(2,1,2,1,'90000')";
        db.execSQL(insertHoaDonChiTiet2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
