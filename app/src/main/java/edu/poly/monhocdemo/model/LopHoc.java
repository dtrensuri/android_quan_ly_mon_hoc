package edu.poly.monhocdemo.model;

public class LopHoc {
    private Integer id;
    private String tenlop;
    private String phonghoc;
    private String diachi;

    public LopHoc() {
    }

    public LopHoc(Integer id, String tenlop, String phonghoc, String diachi) {
        this.id = id;
        this.tenlop = tenlop;
        this.phonghoc = phonghoc;
        this.diachi = diachi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
