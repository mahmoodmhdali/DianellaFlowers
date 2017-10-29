package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Category;
import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findByCategoryPath(String path);

}
