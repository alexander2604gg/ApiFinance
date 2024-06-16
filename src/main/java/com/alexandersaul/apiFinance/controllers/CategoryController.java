package com.alexandersaul.apiFinance.controllers;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/resource")
    public ResponseEntity<List<Category>> getAllCategories () {
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/resource/{id}")
    public ResponseEntity<Category> findById (@PathVariable long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/resource")
    public ResponseEntity<Category> createCategory (@RequestBody Category newCategory) {

        if(newCategory == null){
            return ResponseEntity.badRequest().build();
        }

        Category category = categoryService.create(newCategory);

        if (category != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<Category> updateCategory (@PathVariable long id , @RequestBody Category category) {

        Category updatedTransaction = categoryService.update(id, category);

        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/resource/{id}")
    public ResponseEntity<Transaction> deleteTransaction (@PathVariable long id) {
        try {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }






}
