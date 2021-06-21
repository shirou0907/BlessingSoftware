/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

import java.util.Date;

/**
 *
 * @author MY PC
 */
public class ChiTietXuat extends HoaDonXuat{
    private String mahh;
    private String solo;
    private int soluong;

    public ChiTietXuat() {
    }

    public ChiTietXuat(String mahh, String solo, int soluong, String maxuat, String manv, Date ngayxuat, String bennhan) {
        super(maxuat, manv, ngayxuat, bennhan);
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
    public void setBennhan(String bennhan) {
        super.setBennhan(bennhan); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBennhan() {
        return super.getBennhan(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNgayxuat(Date ngayxuat) {
        super.setNgayxuat(ngayxuat); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getNgayxuat() {
        return super.getNgayxuat(); //To change body of generated methods, choose Tools | Templates.
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
    public void setMaxuat(String maxuat) {
        super.setMaxuat(maxuat); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMaxuat() {
        return super.getMaxuat(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
