package phamthiyen.example.phamthiyen_thi_de;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edMaLoaiSP,edMaSP,edSoLuongNhap,edSoLuongXuat,edDonGiaNhap,edDonGiaXuat,edNgayNhap,edNgayXuat;
    Button btnTao4Bang,btnNhapDuLieu,btnHienThiDuLieu,btnTinhTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMaLoaiSP = findViewById(R.id.edMaLoaiSP);
        edMaSP = findViewById(R.id.edMaSP);
        edSoLuongNhap = findViewById(R.id.edSoLuongNhap);
        edSoLuongXuat = findViewById(R.id.edSoLuongXuat);
        edDonGiaNhap = findViewById(R.id.edDonGiaNhap);
        edDonGiaXuat = findViewById(R.id.edDonGiaXuat);
        edNgayNhap = findViewById(R.id.edNgayNhap);
        edNgayXuat = findViewById(R.id.edNgayXuat);

        btnTao4Bang = findViewById(R.id.btnTao4Bang);
        btnNhapDuLieu = findViewById(R.id.btnNhapDuLieu);
        btnHienThiDuLieu = findViewById(R.id.btnHienThiDuLieu);
        btnTinhTong = findViewById(R.id.btnTinhTong);

        DAO dao = new DAO(this);
    }
}