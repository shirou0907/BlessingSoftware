/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.dao.NhanVienDAO;
import demo.dao.NhanVienDAOimpl;
import demo.model.NhanVien;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class NhanVienServiceImpl implements NhanVienService{

    private NhanVienDAO nvDAO = null;
    
    public NhanVienServiceImpl() {
        this.nvDAO = new NhanVienDAOimpl();
    }
    
    @Override
    public List<NhanVien> getList() {
        return nvDAO.getList();
    }

    @Override
    public int createOrUpdate(NhanVien nv) {
        return nvDAO.createOrUpdate(nv);
    }
    
}
