package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Category;

/**
 * Created by JOEL on 30/04/2017.
 */
public interface CategoryService {
    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
