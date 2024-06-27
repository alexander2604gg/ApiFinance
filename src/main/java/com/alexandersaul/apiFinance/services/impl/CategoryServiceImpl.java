package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import com.alexandersaul.apiFinance.repositories.CategoryRepository;
import com.alexandersaul.apiFinance.services.CategoryService;
import com.alexandersaul.apiFinance.util.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Iterable<CategoryEntity> categoryEntityIterable = categoryRepository.findAll();
        categoryEntityIterable.forEach((i) -> categories.add(categoryMapper.toModel(i)));
        return categories;
    }

    @Override
    public Category create(Category category) {
        final CategoryEntity newCategoryEntity = categoryRepository.save(categoryMapper.toEntity(category));
        return categoryMapper.toModel(newCategoryEntity);
    }

    @Override
    public Category update(long id, Category category) {
        Category newCategory = findById(id);
        if (newCategory != null){
            newCategory.setName(category.getName());
            CategoryEntity categoryEntity = categoryRepository.save(categoryMapper.toEntity(newCategory));
            return categoryMapper.toModel(categoryEntity);
        }
        return null;
    }

    @Override
    public Category findById(long id) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity categoryEntity = optionalCategory.get();
            return categoryMapper.toModel(categoryEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    public Category prueba(long id, Category category) {
        if (category != null){
            category.setName(agregar("Alexander"));
            CategoryEntity categoryEntity = categoryMapper.toEntity(category);
            return categoryMapper.toModel(categoryEntity);
        }
        return null;
    }

    public String agregar (String name) {
        return name + "xyz";
    }

}
