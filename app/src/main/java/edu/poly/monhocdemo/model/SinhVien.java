package edu.poly.monhocdemo.model;

import java.util.Date;

public class SinhVien {
    private String idsinhvien;
    private String hotensv;
    private String gioitinhsv;
    private Date ngaysinhsv;
    private String diachisv;
    private String gmailsv;
    private String sdtsv;

    public SinhVien() {
    }

    public SinhVien(String idsinhvien, String hotensv, String gioitinhsv, Date ngaysinhsv, String diachisv, String gmailsv, String sdtsv) {
        this.idsinhvien = idsinhvien;
        this.hotensv = hotensv;
        this.gioitinhsv = gioitinhsv;
        this.ngaysinhsv = ngaysinhsv;
        this.diachisv = diachisv;
        this.gmailsv = gmailsv;
        this.sdtsv = sdtsv;
    }

    public String getIdsinhvien() {
        return idsinhvien;
    }

    public void setIdsinhvien(String idsinhvien) {
        this.idsinhvien = idsinhvien;
    }

    public String getHotensv() {
        return hotensv;
    }

    public void setHotensv(String hotensv) {
        this.hotensv = hotensv;
    }

    public String getGioitinhsv() {
        return gioitinhsv;
    }

    public void setGioitinhsv(String gioitinhsv) {
        this.gioitinhsv = gioitinhsv;
    }

    public Date getNgaysinhsv() {
        return ngaysinhsv;
    }

    public void setNgaysinhsv(Date ngaysinhsv) {
        this.ngaysinhsv = ngaysinhsv;
    }

    public String getDiachisv() {
        return diachisv;
    }

    public void setDiachisv(String diachisv) {
        this.diachisv = diachisv;
    }

    public String getGmailsv() {
        return gmailsv;
    }

    public void setGmailsv(String gmailsv) {
        this.gmailsv = gmailsv;
    }

    public String getSdtsv() {
        return sdtsv;
    }

    public void setSdtsv(String sdtsv) {
        this.sdtsv = sdtsv;
    }
}



