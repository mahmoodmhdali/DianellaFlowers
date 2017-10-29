package com.dianellaflowers.service;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Category;
import com.dianellaflowers.model.Role;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findByCategoryPath(String path);

}
