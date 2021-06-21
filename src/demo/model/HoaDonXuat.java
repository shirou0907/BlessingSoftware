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
public class HoaDonXuat {
    private String maxuat;
    private String manv;
    private Date ngayxuat;
    private String bennhan;

    public HoaDonXuat() {
    }

    public HoaDonXuat(String maxuat, String manv, Date ngayxuat, String bennhan) {
        this.maxuat = maxuat;
        this.manv = manv;
        this.ngayxuat = ngayxuat;
        this.bennhan = bennhan;
    }

    public String getMaxuat() {
        return maxuat;
    }

    public void setMaxuat(String maxuat) {
        this.maxuat = maxuat;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public String getBennhan() {
        return bennhan;
    }

    public void setBennhan(String bennhan) {
        this.bennhan = bennhan;
    }

    
    
    
}
