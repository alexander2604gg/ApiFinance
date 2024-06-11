package com.alexandersaul.apiFinance.services;

import com.alexandersaul.apiFinance.models.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAll();
    Transaction create(Transaction transaction);
    Transaction update (long id , Transaction transaction);
    Transaction findById(long id);
    void deleteById (long id);

}

