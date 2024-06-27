package com.alexandersaul.apiFinance.service;


import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import com.alexandersaul.apiFinance.repositories.CategoryRepository;
import com.alexandersaul.apiFinance.services.impl.CategoryServiceImpl;
import com.alexandersaul.apiFinance.util.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    CategoryMapper categoryMapper;
    @Spy
    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;

    CategoryEntity categoryEntity;
    Category category;

    @BeforeEach
    void setUp () {
        categoryEntity = new CategoryEntity();
        category = new Category();
        categoryEntity.setId(1);
        categoryEntity.setName("food");
        category.setId(1);
        category.setName("food");
    }

    @Test
    void getAll () {

        when(categoryRepository.findAll()).thenReturn(List.of(categoryEntity));
        when(categoryMapper.toModel(categoryEntity)).thenReturn(category);
        List<Category> result = categoryServiceImpl.getAll();
        assertNotNull(result);
        assertEquals(1,result.size());
        assertEquals("food" , result.get(0).getName());
    }

    @Test
    void create (){
        when(categoryMapper.toEntity(category)).thenReturn(categoryEntity);
        when(categoryRepository.save(categoryEntity)).thenReturn(categoryEntity);
        when(categoryMapper.toModel(categoryEntity)).thenReturn(category);
        Category createdCategory = categoryServiceImpl.create(category);
        assertEquals("food",createdCategory.getName());

    }

    @Test
    void findById () {
        long id = 1;
        when(categoryRepository.findById(id)).thenReturn(Optional.of(categoryEntity));
        when(categoryMapper.toModel(categoryEntity)).thenReturn(category);
        Category category1 = categoryServiceImpl.findById(id);
        assertNotNull(category1);
        assertEquals("food",category1.getName());
    }

    @Test
    void findByIdNull () {
        long id = 2;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        Category category1 = categoryServiceImpl.findById(id);
        assertNull(category1);

    }

    @Test
    void update () {

        Category newCategory = Category.builder().id(1).name("services").build();
        CategoryEntity newCategoryEntity = CategoryEntity.builder().id(1).name("services").build();
        doReturn(category).when(categoryServiceImpl).findById(1);
        when(categoryMapper.toEntity(newCategory)).thenReturn(newCategoryEntity);
        when(categoryRepository.save(newCategoryEntity)).thenReturn(newCategoryEntity);
        when(categoryMapper.toModel(newCategoryEntity)).thenReturn(newCategory);


        Category category1 = categoryServiceImpl.update(1, Category.builder().id(1).name("services").build());
        assertEquals("services",category1.getName());

    }


}
