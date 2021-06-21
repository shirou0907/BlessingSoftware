/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dao;

import demo.model.SanPham;
import java.util.List;
/**
 *
 * @author MY PC
 */
public interface SanPhamDAO {
    public List<SanPham> getList();
    public int createOrUpdate(SanPham sp);
}
