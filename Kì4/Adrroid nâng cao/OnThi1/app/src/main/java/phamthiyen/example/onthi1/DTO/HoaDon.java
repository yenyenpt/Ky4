package phamthiyen.example.onthi1.DTO;

public class HoaDon {
    private String maHD;
    private String ngayXuat;
    private int maSanPham;

    public HoaDon() {
    }

    public HoaDon(String maHD, String ngayXuat, int maSanPham) {
        this.maHD = maHD;
        this.ngayXuat = ngayXuat;
        this.maSanPham = maSanPham;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
}
