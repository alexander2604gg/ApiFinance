package com.alexandersaul.apiFinance.controllers;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/resource")
    public ResponseEntity<List<Budget>> getAllBudgets () {
        List<Budget> budgets = budgetService.getAll();
        return ResponseEntity.ok(budgets);
    }

    @PostMapping("/resource")
    public ResponseEntity<Budget> createBudget(@RequestBody Budget newBudget) {

        if (newBudget == null) {
            return ResponseEntity.badRequest().build();
        }
        Budget createdBudget = budgetService.create(newBudget);
        if (createdBudget != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBudget);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<Budget> updateBudget (@PathVariable long id , @RequestBody Budget budget) {

        Budget updatedBudget = budgetService.update(id,budget);

        if (updatedBudget != null){
            return ResponseEntity.ok(updatedBudget);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

    @DeleteMapping("/resource/{id}")
    public ResponseEntity<Void> deleteTransaction (@PathVariable long id) {
        try {
            budgetService.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 Not Found
        }

    }
}
