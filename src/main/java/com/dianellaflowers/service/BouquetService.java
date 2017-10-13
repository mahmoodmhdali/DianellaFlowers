package com.dianellaflowers.service;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Role;
import java.util.List;

public interface BouquetService {

    List<Bouquet> findAll(String orderBy, boolean desc);

    Bouquet findById(int id);

    List<Bouquet> findByCategoryName(String category, String orderBy, boolean desc);

    List<Bouquet> findHomePageProduct();

}
