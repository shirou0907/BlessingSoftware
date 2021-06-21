/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.service;

import demo.dao.XuatKhoDAO;
import demo.dao.XuatKhoDAOimpl;
import demo.model.HoaDonXuat;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class XuatKhoServiceImpl implements XuatKhoService{

    private XuatKhoDAO xkDAO = null;
    
    public XuatKhoServiceImpl() {
        this.xkDAO = new XuatKhoDAOimpl();
    }
    
    @Override
    public List<HoaDonXuat> getList() {
        return xkDAO.getList();
    }

//    @Override
//    public int createOrUpdate(NhapKhoDAO hdn) {
//        return nkDAO.createOrUpdate(hdn);
//    }
    
}
