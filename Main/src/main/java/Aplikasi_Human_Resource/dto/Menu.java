package Aplikasi_Human_Resource.dto;

public class Menu {

    private int id;
    private String nama_menu;
    private String jabatan;

//    public Menu(String nama_menu, String jabatan) {
//        this.id = id;
//        this.nama_menu = nama_menu;
//        this.jabatan = jabatan;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
