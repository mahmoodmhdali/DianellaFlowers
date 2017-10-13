package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import java.util.List;

public interface BouquetDao {

    List<Bouquet> findAll();

    Bouquet findById(int id);

    List<Bouquet> findByCategoryName(String category);

    List<Bouquet> findHomePageProduct();

}
