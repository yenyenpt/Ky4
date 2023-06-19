package phamthiyen.example.phamthiyen_thi_de.DTO;

public class HoaDonChiTiet {
    private  int maHDCT;
    private int maLoai;
    private String tenSP;
    private int maHD;
    private int soLuongXuat;
    private int donGiaXuat;
    private String NgayXuat;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int maLoai, String tenSP, int maHD, int soLuongXuat, int donGiaXuat, String ngayXuat) {
        this.maHDCT = maHDCT;
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.maHD = maHD;
        this.soLuongXuat = soLuongXuat;
        this.donGiaXuat = donGiaXuat;
        NgayXuat = ngayXuat;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
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

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public int getDonGiaXuat() {
        return donGiaXuat;
    }

    public void setDonGiaXuat(int donGiaXuat) {
        this.donGiaXuat = donGiaXuat;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        NgayXuat = ngayXuat;
    }
}
