package phamthiyen.example.phamthiyen_thi_de;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import phamthiyen.example.phamthiyen_thi_de.DTO.HoaDon;
import phamthiyen.example.phamthiyen_thi_de.DTO.HoaDonChiTiet;
import phamthiyen.example.phamthiyen_thi_de.DTO.SanPham;

public class DAO {
    SQLiteDatabase db;
    Context context;

    public void DA0(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insertTheLoai(TheLoai obj){
        ContentValues values = new ContentValues();
        values.put("tenLoai",obj.getTenTheLoai);
        return db.insert("TheLoai",null,values);

    }
    public long insertSanPham(SanPham obj){
        ContentValues values = new ContentValues();
        values.put("tenSP",obj.getTenSP());
        values.put("soLuongNhap",obj.getSoLuongNhap());
        values.put("ngayNhap",obj.getNgayNhap());
        values.put("donGiaNhap",obj.getDonGiaNhap());
        return db.insert("SanPham",null,values);

    }
    public long insertHoaDon(HoaDon obj){
        ContentValues values = new ContentValues();
        values.put("ngayXuat",obj.getNgayXuat());
        return db.insert("HoaDon",null,values);

    }
    public long insertHDCT(HoaDonChiTiet obj){
        ContentValues values = new ContentValues();
        values.put("maLoai",obj.getMaLoai());
        values.put("tenSP",obj.getTenSP());
        values.put("maHD",obj.getMaHD());
        values.put("soLuongXuat",obj.getSoLuongXuat());
        values.put("donGiaXuat",obj.getDonGiaXuat());
        values.put("ngayXuat",obj.getNgayXuat());
        return db.insert("HoaDonChiTiet",null,values);

    }
    @SuppressLint("Range")
    public List<SanPham> getListSP (String sql, String...args){
        List<SanPham> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,args);
        while (c.moveToNext()){
            SanPham obj = new SanPham();
            obj.setMaSP(c.getInt(c.getColumnIndex("maSP")));
            obj.setTenSP(c.getString(c.getColumnIndex("tenSP")));
            obj.setDonGiaNhap(c.getInt(c.getColumnIndex("donGiaNhap")));
            obj.setSoLuongNhap(c.getInt(c.getColumnIndex("soLuongNhap")));
            obj.setNgayNhap(c.getString(c.getColumnIndex("ngayNhap")));
            list.add(obj);
        }
        return list;

    }
    @SuppressLint("Range")
    public List<HoaDon> getListHD(String sql, String... args) {
        List<HoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, args);
        while (c.moveToNext()) {
            HoaDon obj = new HoaDon();
            obj.setNgayXuat(c.getString(c.getColumnIndex("ngayXuat")));
            list.add(obj);
        }
        return list;
    }

    @SuppressLint("Range")
    public List<TheLoai> getListTL(String sql, String... args) {
        List<TheLoai> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, args);
        while (c.moveToNext()) {
            TheLoai obj = new TheLoai();
            obj.setTenTheLoai(c.getString(c.getColumnIndex("tenTheLoai")));
            list.add(obj);
        }
        return list;
    }

    @SuppressLint("Range")
    public List<HoaDonChiTiet> getListHDCT(String sql, String... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, args);
        while (c.moveToNext()) {
            HoaDonChiTiet obj = new HoaDonChiTiet();
            obj.setMaLoai(c.getInt(c.getColumnIndex("maLoai")));
            obj.setMaHDCT(c.getInt(c.getColumnIndex("maHDCT")));
            obj.setDonGiaXuat(c.getInt(c.getColumnIndex("donGiaXuat")));
            obj.setMaHD(c.getInt(c.getColumnIndex("maHD")));
            obj.setTenSP(c.getString(c.getColumnIndex("tenSP")));
            obj.setNgayXuat(c.getString(c.getColumnIndex("ngayXuat")));
            list.add(obj);
        }
        return list;

    }
    public List<SanPham> getSanPham() {
        String sql = "select * from SanPham";
        return getListSP(sql);
    }

    public List<HoaDonChiTiet> getHDCT() {
        String sql = "select * from HoaDonChiTiet";
        return getListHDCT(sql);
    }

}
