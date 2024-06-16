package com.alexandersaul.apiFinance.controllers;
import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/resource")
    public ResponseEntity<List<Transaction>> getAllTransactions () {
        List<Transaction> listTransactions = transactionService.getAll();
        return ResponseEntity.ok(listTransactions);
    }

    @PostMapping ("/resource")
    public ResponseEntity<Transaction> createTransaction (@RequestBody Transaction newTransaction) {

        if (newTransaction == null){
            return ResponseEntity.badRequest().build();
        }

        Transaction createdTransaction = transactionService.create(newTransaction);

        if (createdTransaction != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<Transaction> updateTransaction (@PathVariable long id,@RequestBody Transaction transaction){

        Transaction updatedTransaction = transactionService.update(id,transaction);

        if (updatedTransaction != null){
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("/resource/{id}")
    public ResponseEntity<Void> deleteTransaction (@PathVariable long id) {
        try {
            transactionService.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 Not Found
        }

    }

}


