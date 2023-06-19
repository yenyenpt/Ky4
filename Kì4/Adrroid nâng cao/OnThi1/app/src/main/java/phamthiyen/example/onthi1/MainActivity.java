package phamthiyen.example.onthi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import phamthiyen.example.onthi1.DTO.HoaDon;
import phamthiyen.example.onthi1.DTO.HoaDonChiTiet;
import phamthiyen.example.onthi1.DTO.SanPham;
import phamthiyen.example.onthi1.DTO.TheLoai;

public class MainActivity extends AppCompatActivity {
    EditText edMaLoai,edSanPham,edSoLuongNhap,edSoLuongXuat,edDonGiaNhap,edDonGiaXuat,edNhayNhap,edNgayXuat;
    Button btntaoBang,btnnhapDuLieu,btntinhTong,btnlietKe;
    Dao dao;

    SanPham sanPham_obj;
    TheLoai theLoai_obj;
    HoaDon hoaDon_obj;
    HoaDonChiTiet hoaDonChiTiet_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMaLoai = findViewById(R.id.edMaLoai);
        edSanPham = findViewById(R.id.edSanPham);
        edSoLuongXuat = findViewById(R.id.edSoLuongXuat);
        edSoLuongNhap = findViewById(R.id.edSoLuongNhap);
        edDonGiaNhap = findViewById(R.id.edDonGiaNhap);
        edDonGiaXuat = findViewById(R.id.edSoLuongXuat);
        edNhayNhap = findViewById(R.id.edNhayNhap);
        edNgayXuat = findViewById(R.id.edNgayXuat);

        btntaoBang = findViewById(R.id.btntaoBang);
        btnnhapDuLieu = findViewById(R.id.btnnhapDuLieu);
        btntinhTong = findViewById(R.id.btntinhTong);
        btnlietKe = findViewById(R.id.btnlietKe);

        dao = new Dao(getApplication());

        sanPham_obj = new SanPham();
        theLoai_obj = new TheLoai();
        hoaDon_obj = new HoaDon();
        hoaDonChiTiet_obj = new HoaDonChiTiet();

        btnnhapDuLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() > 0){
                    theLoai_obj.setTenLoai(edMaLoai.getText().toString());
                    if(dao.insertTheLoai(theLoai_obj)>0){
                        Log.d("zzz","onClick: Them the loai thanh cong");
                    }
                    sanPham_obj.setTenSP(edSanPham.getText().toString());
                    sanPham_obj.setSoLuongNhap(Integer.parseInt(edSoLuongNhap.getText().toString()));
                    sanPham_obj.setDonGiaNhap(edDonGiaNhap.getText().toString());
                    sanPham_obj.setNgayNhap(edNhayNhap.getText().toString());
                    sanPham_obj.setMaLoai(dao.getMaLoai());
                    if(dao.insertSanPham(sanPham_obj)>0){
                        Log.d("zzz","onClick: Them hoa don thanh cong");
                    }
                    hoaDon_obj.setNgayXuat(edNgayXuat.getText().toString());
                    hoaDon_obj.setMaSanPham(dao.getMaSP());
                    if(dao.insertHoaDon(hoaDon_obj) > 0){
                        Log.d("zzzzz" , "onClick  Thêm hóa đơn thành công ");
                    }
                    hoaDonChiTiet_obj.setMaHD(dao.getMaHD());
                    hoaDonChiTiet_obj.setMaSP(dao.getMaSP());
                    hoaDonChiTiet_obj.setSoLuongXuat(Integer.parseInt(edSoLuongXuat.getText().toString()));
                    hoaDonChiTiet_obj.setDonGiaXuat(edDonGiaXuat.getText().toString());
                    if(dao.insertSanPham(sanPham_obj) > 0){
                        Log.d("zzzzz" , "onClick  Thêm hóa đơn chi tiết thành công ");
                    }
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btnlietKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ManHinhDanhSach.class);
                startActivity(intent);
            }
        });
    }
    public int validate() {
        int check = 1;
//
        if (edMaLoai.getText().toString().isEmpty() || edSanPham.getText().toString().isEmpty() || edSoLuongNhap.getText().toString().isEmpty() || edSoLuongXuat.getText().toString().isEmpty() || edDonGiaNhap.getText().toString().isEmpty() || edDonGiaXuat.getText().toString().isEmpty() || edNhayNhap.getText().toString().isEmpty() || edNgayXuat.getText().toString().isEmpty()) {
            Toast.makeText(this, "Phai nhap day du thong tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else if (!edNhayNhap.getText().toString().matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
            Toast.makeText(this, "Phai nhap dung dinh dang dd-MM-yyyy", Toast.LENGTH_SHORT).show();
            check = -1;
        } else if (!edNgayXuat.getText().toString().matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
            Toast.makeText(this, "Phai nhap dung dinh dang dd-MM-yyyy", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            try {
                Integer.parseInt(edSoLuongNhap.getText().toString());
                Integer.parseInt(edSoLuongXuat.getText().toString());
                Integer.parseInt(edDonGiaNhap.getText().toString());
                Integer.parseInt(edDonGiaXuat.getText().toString());

            } catch (Exception e) {
                Toast.makeText(this, "So luong va don gia phai la so", Toast.LENGTH_SHORT).show();
                check = -1;
            }


        }
        return check;
    }
}