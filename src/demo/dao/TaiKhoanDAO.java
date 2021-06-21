/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.TaiKhoan;

/**
 *
 * @author MY PC
 */
public interface TaiKhoanDAO {
    public TaiKhoan login(String tentk, String matkhau);
}
