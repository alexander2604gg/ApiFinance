package com.alexandersaul.apiFinance.services;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.Transaction;


import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category create(Category category);
    Category update (long id , Category category);
    Transaction findById(long id);
    void deleteById (long id);

}
