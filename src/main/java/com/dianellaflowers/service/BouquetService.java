package com.dianellaflowers.service;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Role;
import java.util.List;

public interface BouquetService {

    List<Bouquet> findAll();

    Bouquet findById(int id);

    List<Bouquet> findByCategoryName(String category);

}
