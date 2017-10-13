/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.BouquetDao;
import com.dianellaflowers.model.Bouquet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("bouquetService")
public class BouquetServiceImpl implements BouquetService {

    @Autowired
    BouquetDao bouquetDao;

    @Override
    public List<Bouquet> findByCategoryName(String category, String orderBy, boolean desc) {
        return bouquetDao.findByCategoryName(category, orderBy, desc);
    }

    @Override
    public List<Bouquet> findAll(String orderBy, boolean desc) {
        return bouquetDao.findAll(orderBy, desc);
    }

    @Override
    public Bouquet findById(int id) {
        return bouquetDao.findById(id);
    }

    @Override
    public List<Bouquet> findHomePageProduct() {
        return bouquetDao.findHomePageProduct();
    }

}
