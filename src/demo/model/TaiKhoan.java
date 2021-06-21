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
public class TaiKhoan {
    private String tentk;
    private String matkhau;
    private String manv;
    private String tennv;
    private String chucvu;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentk, String matkhau, String manv, String tennv, String chucvu) {
        this.tentk = tentk;
        this.matkhau = matkhau;
        this.manv = manv;
        this.tennv = tennv;
        this.chucvu = chucvu;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
}
