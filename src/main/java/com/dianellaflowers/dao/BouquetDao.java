package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import java.util.List;

public interface BouquetDao {

    List<Bouquet> findAll(String orderBy, boolean desc);

    Bouquet findById(int id);

    List<Bouquet> findByCategoryName(String category, String orderBy, boolean desc);

    List<Bouquet> findHomePageProduct();

}
