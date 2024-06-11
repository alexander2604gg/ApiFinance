package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.repositories.CategoryRepository;
import com.alexandersaul.apiFinance.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl (final CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Iterable<CategoryEntity> categoryEntityIterable = categoryRepository.findAll();
        //categoryEntityIterable.forEach((i) -> categories.add(t));
        return null;
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
