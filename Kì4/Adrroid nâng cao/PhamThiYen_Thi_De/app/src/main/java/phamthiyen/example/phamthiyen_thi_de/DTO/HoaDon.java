package phamthiyen.example.phamthiyen_thi_de.DTO;

public class HoaDon {
    private  int maHD;
    private  String ngayXuat;

    public HoaDon() {
    }

    public HoaDon(int maHD, String ngayXuat) {
        this.maHD = maHD;
        this.ngayXuat = ngayXuat;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
}
