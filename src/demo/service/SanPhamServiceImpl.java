/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.dao.SanPhamDAO;
import demo.dao.SanPhamDAOimpl;
import demo.model.SanPham;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamDAO spDAO = null;
    
    public SanPhamServiceImpl() {
        this.spDAO = new SanPhamDAOimpl();
    }
    
    @Override
    public List<SanPham> getList() {
        return spDAO.getList();
    }

    @Override
    public int createOrUpdate(SanPham sp) {
        return spDAO.createOrUpdate(sp);
    }
    
}
