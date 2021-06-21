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
public class NhanVien {
    private String mavn;
    private String hoten;
    private boolean gioitinh;
    private Date ngaysinh;
    private String sdt;
    private String cmnd;
    private String chucvu;

    public NhanVien() {
    }

    public NhanVien(String mavn, String hoten, boolean gioitinh, Date ngaysinh, String sdt, String cmnd, String chucvu) {
        this.mavn = mavn;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.chucvu = chucvu;
    }

    public String getMavn() {
        return mavn;
    }

    public void setMavn(String mavn) {
        this.mavn = mavn;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public String toString() {
        return  mavn + "," + hoten + "," + gioitinh + ", " + ngaysinh + "," + sdt + "," + cmnd + "," + chucvu + ","+ "\n";
    }
    
    
}
