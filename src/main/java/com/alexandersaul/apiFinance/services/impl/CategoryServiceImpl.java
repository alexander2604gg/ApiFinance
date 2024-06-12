package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import com.alexandersaul.apiFinance.repositories.CategoryRepository;
import com.alexandersaul.apiFinance.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        categoryEntityIterable.forEach((i) -> categories.add(categoryEntityToCategory(i)));
        return categories;
    }

    @Override
    public Category create(Category category) {
        final CategoryEntity newCategoryEntity = categoryRepository.save(categoryToCategoryEntity(category));
        return categoryEntityToCategory(newCategoryEntity);
    }

    @Override
    public Category findById(long id) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity categoryEntity = optionalCategory.get();
            return categoryEntityToCategory(categoryEntity);
        }
        return null;
    }

    @Override
    public Category update(long id, Category category) {
        Category newCategory = findById(id);
        if (newCategory != null){
            newCategory.setId(category.getId());
            newCategory.setName(category.getName());
            newCategory.setTransactions(category.getTransactions());
            newCategory.setBudgets(category.getBudgets());
            CategoryEntity categoryEntity = categoryRepository.save(categoryToCategoryEntity(category));
            return categoryEntityToCategory(categoryEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryEntity categoryToCategoryEntity (Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .transactions(category.getTransactions())
                .budgets(category.getBudgets())
                .build();
    }

    public Category categoryEntityToCategory (CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .transactions(categoryEntity.getTransactions())
                .budgets(categoryEntity.getBudgets())
                .build();
    }



}
