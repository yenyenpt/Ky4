package phamthiyen.example.phamthiyen_thi_de.DTO;

public class TheLoai {
    int id;
    String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(int id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
}
