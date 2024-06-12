package com.alexandersaul.apiFinance.services;

import com.alexandersaul.apiFinance.models.Category;



import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category create(Category category);
    Category update (long id , Category category);
    Category findById(long id);
    void deleteById (long id);

}
