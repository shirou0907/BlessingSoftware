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
public class HoaDonNhap {
    private String manhap;
    private String manv;
    private Date ngaynhap;
    private String bengui;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String manhap, String manv, Date ngaynhap, String bengui) {
        this.manhap = manhap;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.bengui = bengui;
    }

    public String getManhap() {
        return manhap;
    }

    public void setManhap(String manhap) {
        this.manhap = manhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getBengui() {
        return bengui;
    }

    public void setBengui(String bengui) {
        this.bengui = bengui;
    }

    @Override
    public String toString() {
        return "HoaDonNhap{" + "manhap=" + manhap + ", manv=" + manv + ", ngaynhap=" + ngaynhap + ", bengui=" + bengui + '}';
    }    
}
