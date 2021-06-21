package demo.model;

import java.util.Date;

/**
 *
 * @author MY PC
 */
public class ChiTietNhap extends HoaDonNhap{
    private String mahh;
    private String solo;
    private int soluong;

    public ChiTietNhap() {
    }

    public ChiTietNhap(String mahh, String solo, int soluong, String manhap, String manv, Date ngaynhap, String bengui) {
        super(manhap, manv, ngaynhap, bengui);
        this.mahh = mahh;
        this.solo = solo;
        this.soluong = soluong;
    }

    public String getMahh() {
        return mahh;
    }

    public void setMahh(String mahh) {
        this.mahh = mahh;
    }

    public String getSolo() {
        return solo;
    }

    public void setSolo(String solo) {
        this.solo = solo;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBengui(String bengui) {
        super.setBengui(bengui); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBengui() {
        return super.getBengui(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNgaynhap(Date ngaynhap) {
        super.setNgaynhap(ngaynhap); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getNgaynhap() {
        return super.getNgaynhap(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setManv(String manv) {
        super.setManv(manv); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getManv() {
        return super.getManv(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setManhap(String manhap) {
        super.setManhap(manhap); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getManhap() {
        return super.getManhap(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    

    
    
}
