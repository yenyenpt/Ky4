package phamthiyen.example.onthi1.DTO;

public class SanPham {
    private int maLoai;
    private String tenSP;
    private int maSP;
    private int soLuongNhap;
    private String donGiaNhap;
    private String ngayNhap;

    public SanPham() {
    }

    public SanPham(int maLoai, String tenSP, int maSP, int soLuongNhap, String donGiaNhap, String ngayNhap) {
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
        this.ngayNhap = ngayNhap;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public String getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(String donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
