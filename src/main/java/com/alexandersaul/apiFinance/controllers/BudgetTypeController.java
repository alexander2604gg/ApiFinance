package com.alexandersaul.apiFinance.controllers;

import com.alexandersaul.apiFinance.models.BudgetType;
import com.alexandersaul.apiFinance.services.BudgetService;
import com.alexandersaul.apiFinance.services.BudgetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/budgetType")
public class BudgetTypeController {

    @Autowired
    private BudgetTypeService budgetTypeService;

    @GetMapping("/resource")
    public ResponseEntity<List<BudgetType>> getAllBudgetsTypes (){
        List<BudgetType> budgetTypes = budgetTypeService.getAll();
        return ResponseEntity.ok(budgetTypes);
    }


}
