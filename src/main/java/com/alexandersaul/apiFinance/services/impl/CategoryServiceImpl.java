package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.repositories.CategoryRepository;
import com.alexandersaul.apiFinance.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl (final CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category update(long id, Category category) {
        return null;
    }

    @Override
    public Transaction findById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
