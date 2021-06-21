/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

/**
 *
 * @author MY PC
 */
public class ThongKe {
    private String mahh;
    private String tenhh;
    private String dvt;
    private int tongsln;
    private int tongslx;
    private int tonkho;

    public ThongKe() {
    }

    public ThongKe(String mahh, String tenhh, String dvt, int tongsln, int tongslx, int tonkho) {
        this.mahh = mahh;
        this.tenhh = tenhh;
        this.dvt = dvt;
        this.tongsln = tongsln;
        this.tongslx = tongslx;
        this.tonkho = tonkho;
    }

    public String getMahh() {
        return mahh;
    }

    public void setMahh(String mahh) {
        this.mahh = mahh;
    }

    public String getTenhh() {
        return tenhh;
    }

    public void setTenhh(String tenhh) {
        this.tenhh = tenhh;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getTongsln() {
        return tongsln;
    }

    public void setTongsln(int tongsln) {
        this.tongsln = tongsln;
    }

    public int getTongslx() {
        return tongslx;
    }

    public void setTongslx(int tongslx) {
        this.tongslx = tongslx;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }
  
    
    
    
    
}
