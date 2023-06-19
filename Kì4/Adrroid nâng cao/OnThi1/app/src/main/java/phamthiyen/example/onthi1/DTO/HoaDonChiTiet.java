package phamthiyen.example.onthi1.DTO;

public class HoaDonChiTiet {
    private int maHDCT;
    private int maHD;
    private int maSP;
    private int soLuongXuat;
    private String donGiaXuat;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int maHD, int maSP, int soLuongXuat, String donGiaXuat) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuongXuat = soLuongXuat;
        this.donGiaXuat = donGiaXuat;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public String getDonGiaXuat() {
        return donGiaXuat;
    }

    public void setDonGiaXuat(String donGiaXuat) {
        this.donGiaXuat = donGiaXuat;
    }
}
