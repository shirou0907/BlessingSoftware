/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.dao.NhapKhoDAO;
import demo.dao.NhapKhoDAOimpl;
import demo.model.HoaDonNhap;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class NhapKhoServiceImpl implements NhapKhoService{

    private NhapKhoDAO nkDAO = null;
    
    public NhapKhoServiceImpl() {
        this.nkDAO = new NhapKhoDAOimpl();
    }
    
    @Override
    public List<HoaDonNhap> getList() {
        return nkDAO.getList();
    }

//    @Override
//    public int createOrUpdate(NhapKhoDAO hdn) {
//        return nkDAO.createOrUpdate(hdn);
//    }
    
}
