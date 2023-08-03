package edu.poly.monhocdemo.model;

public class MonHoc {
    private String idmonhoc;
    private String tenmh;
    private Integer sotin;
    private String muctieudaura;
    private String hinhthucdanhgia;
    private String nganh;

    public MonHoc() {
    }

    public MonHoc(String idmonhoc, String tenmh, Integer sotin, String muctieudaura, String hinhthucdanhgia, String nganh) {
        this.idmonhoc = idmonhoc;
        this.tenmh = tenmh;
        this.sotin = sotin;
        this.muctieudaura = muctieudaura;
        this.hinhthucdanhgia = hinhthucdanhgia;
        this.nganh = nganh;
    }

    public String getIdmonhoc() {
        return idmonhoc;
    }

    public void setIdmonhoc(String idmonhoc) {
        this.idmonhoc = idmonhoc;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public Integer getSotin() {
        return sotin;
    }

    public void setSotin(Integer sotin) {
        this.sotin = sotin;
    }

    public String getMuctieudaura() {
        return muctieudaura;
    }

    public void setMuctieudaura(String muctieudaura) {
        this.muctieudaura = muctieudaura;
    }

    public String getHinhthucdanhgia() {
        return hinhthucdanhgia;
    }

    public void setHinhthucdanhgia(String hinhthucdanhgia) {
        this.hinhthucdanhgia = hinhthucdanhgia;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
}

