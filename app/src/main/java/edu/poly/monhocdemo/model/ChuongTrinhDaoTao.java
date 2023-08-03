package edu.poly.monhocdemo.model;

public class ChuongTrinhDaoTao {
    private String idchuongtrinhdt;
    private String tenchuongtrinhdt;
    private int sotinchidt;
    private String nambatdaudt;

    public ChuongTrinhDaoTao() {
    }

    public ChuongTrinhDaoTao(String idchuongtrinhdt, String tenchuongtrinhdt, int sotinchidt, String nambatdaudt) {
        this.idchuongtrinhdt = idchuongtrinhdt;
        this.tenchuongtrinhdt = tenchuongtrinhdt;
        this.sotinchidt = sotinchidt;
        this.nambatdaudt = nambatdaudt;
    }

    public String getIdchuongtrinhdt() {
        return idchuongtrinhdt;
    }

    public void setIdchuongtrinhdt(String idchuongtrinhdt) {
        this.idchuongtrinhdt = idchuongtrinhdt;
    }

    public String getTenchuongtrinhdt() {
        return tenchuongtrinhdt;
    }

    public void setTenchuongtrinhdt(String tenchuongtrinhdt) {
        this.tenchuongtrinhdt = tenchuongtrinhdt;
    }

    public int getSotinchidt() {
        return sotinchidt;
    }

    public void setSotinchidt(int sotinchidt) {
        this.sotinchidt = sotinchidt;
    }

    public String getNambatdaudt() {
        return nambatdaudt;
    }

    public void setNambatdaudt(String nambatdaudt) {
        this.nambatdaudt = nambatdaudt;
    }
}
