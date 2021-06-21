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
public class SanPham {
    private String mahh;
    private String tenhh;
    private String donvitinh;
    private String solo;
    private int soluong;

    public SanPham() {
    }

    public SanPham(String mahh, String tenhh, String donvitinh, String solo, int soluong) {
        this.mahh = mahh;
        this.tenhh = tenhh;
        this.donvitinh = donvitinh;
        this.solo = solo;
        this.soluong = soluong;
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

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
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
        return "SanPham{" + "mahh=" + mahh + ", tenhh=" + tenhh + ", donvitinh=" + donvitinh + ", solo=" + solo + ", soluong=" + soluong + '}';
    }
    
    
}
