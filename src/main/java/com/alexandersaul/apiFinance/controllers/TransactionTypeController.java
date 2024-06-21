package com.alexandersaul.apiFinance.controllers;

import com.alexandersaul.apiFinance.models.TransactionType;
import com.alexandersaul.apiFinance.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/transactionType")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/resource")
    public ResponseEntity<List<TransactionType>> getAllTransactionTypes () {

        List<TransactionType> transactionTypes = transactionTypeService.getAll();
        return ResponseEntity.ok(transactionTypes);
    }


}
