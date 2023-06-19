package phamthiyen.example.onthi1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import phamthiyen.example.onthi1.DTO.HoaDon;
import phamthiyen.example.onthi1.DTO.HoaDonChiTiet;
import phamthiyen.example.onthi1.DTO.SanPham;
import phamthiyen.example.onthi1.DTO.TheLoai;

public class Dao {
    SQLiteDatabase db;

    public Dao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();

    }
    public long insertTheLoai(TheLoai obj){
        ContentValues values = new ContentValues();
        values.put("tenLoai",obj.getTenLoai());

        return  db.insert("TheLoai",null,values);

    }
    public long insertSanPham(SanPham obj){
        ContentValues values = new ContentValues();
        values.put("tenSP",obj.getMaSP());
        values.put("soLuongNhap",obj.getSoLuongNhap());
        values.put("donGiaNhap",obj.getDonGiaNhap());
        values.put("ngayNhap",obj.getNgayNhap());

        return  db.insert("SanPham",null,values);
    }

    public long insertHoaDon(HoaDon obj){
        ContentValues values = new ContentValues();
        values.put("ngayXuat",obj.getNgayXuat());
        return  db.insert("HoaDon",null,values);

    }
    public long insertHoaDonChiTiet(HoaDonChiTiet obj){
        ContentValues values = new ContentValues();
        values.put("maHD",obj.getMaHD());
        values.put("maSP",obj.getMaSP());
        values.put("soLuongXuat",obj.getSoLuongXuat());
        values.put("donGiaXuat",obj.getDonGiaXuat());
        return  db.insert("HoaDonChiTiet",null,values);
    }

    @SuppressLint("Range")
    public List<SanPham> getData(String sql, String...args){
        List<SanPham> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,args);
        while (c.moveToNext()){
            SanPham obj = new SanPham();
            obj.setMaSP((c.getColumnIndex("maSP")));
//            obj.setMaLoai(c.getString(c.getColumnIndex("maLoai")));
//            obj.setTenLoai(c.getString(c.getColumnIndex("tenLoai")));
//            obj.setMaSP(c.getString(c.getColumnIndex("maSP")));
//            obj.setTenSP(c.getString(c.getColumnIndex("tenSP")));
//            obj.setSoLuongNhap(Integer.parseInt(c.getString(c.getColumnIndex("soLuongNhap"))));
//            obj.setDonGiaNhap(c.getString(c.getColumnIndex("donGiaNhap")));
//            obj.setNgayNhap(c.getString(c.getColumnIndex("ngayNhap")));
//            obj.setMaHD(Integer.parseInt(c.getString(c.getColumnIndex("maHD"))));
//            obj.setNgayNhap(c.getString(c.getColumnIndex("ngayXuat")));
//            obj.setMaHDCT(Integer.parseInt(c.getString(c.getColumnIndex("maHDCT"))));
//            obj.setSoLuongXuat(Integer.parseInt(c.getString(c.getColumnIndex("soLuongXuat"))));
//            obj.setDonGiaXuat(c.getString(c.getColumnIndex("donGiaXuat")));
            TheLoai theLoai = new TheLoai();
            theLoai.setMaLoai((c.getColumnIndex("maLoai")));

            HoaDonChiTiet chiTiet = new HoaDonChiTiet();
            chiTiet.setSoLuongXuat(Integer.parseInt(c.getString(c.getColumnIndex("soLuongXuat"))));
            list.add(obj);
//            list.add(theLoai);
//            list.add(chiTiet);




        }
        return list;

    }
    @SuppressLint("Range")
    public int getMaLoai(){
        int id = 0;
        Cursor c = db.rawQuery("Select maLoai from TheLoai",null);
        while ((c.moveToNext())){
            id = c.getInt(c.getColumnIndex("maLoai"));
        }
        return id;
    }

    @SuppressLint("Range")
    public int getLuongXuat(){
        int sl = 0;
        Cursor c = db.rawQuery("select soLuongXuat from HoaDonChiTiet", null);
        while (c.moveToNext()){
            sl = c.getInt(c.getColumnIndex("soLuongXuat"));

        }
        return sl;
    }
    @SuppressLint("Range")
    public int getMaSP(){
        int id = 0;
        Cursor c = db.rawQuery("select maSP from SanPham", null);
        while (c.moveToNext()){
            id = c.getInt(c.getColumnIndex("maSP"));

        }
        return id;
    }
    @SuppressLint("Range")
    public int getMaHD(){
        int id = 0;
        Cursor c = db.rawQuery("select maHD from HoaDon", null);
        while (c.moveToNext()){
            id = c.getInt(c.getColumnIndex("maHD"));

        }
        return id;
    }


}
