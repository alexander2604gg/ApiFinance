package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.models.TransactionEntity;
import com.alexandersaul.apiFinance.repositories.TransactionRepository;
import com.alexandersaul.apiFinance.services.TransactionService;
import com.alexandersaul.apiFinance.util.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> getAll() {
        List<Transaction> listTransactions = new ArrayList<>();
        Iterable<TransactionEntity> iterableTransactions =  transactionRepository.findAll();
        iterableTransactions.forEach(i -> listTransactions.add(transactionMapper.toModel(i)));
        return listTransactions;
    }

    @Override
    public Transaction create(Transaction transaction) {
        final TransactionEntity transactionEntity = transactionMapper.toEntity(transaction);
        final TransactionEntity savedTransactionEntity = transactionRepository.save(transactionEntity);
        return transactionMapper.toModel(savedTransactionEntity);
    }

    @Override
    public Transaction update(long id, Transaction transaction) {
        Transaction newTransaction = findById(id);
        if ( newTransaction != null) {
            newTransaction.setAmount(transaction.getAmount());
            newTransaction.setDate(transaction.getDate());
            newTransaction.setPaymentMethodId(transaction.getPaymentMethodId());
            newTransaction.setUserId(transaction.getUserId());
            newTransaction.setTransactionTypeId(transaction.getTransactionTypeId());
            newTransaction.setCategoryId(transaction.getCategoryId());
            TransactionEntity transactionEntity  = transactionRepository.save(transactionMapper.toEntity(newTransaction));
            return transactionMapper.toModel(transactionEntity);
        }
        return null;
    }

    @Override
    public Transaction findById(long id) {
        Optional<TransactionEntity> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()) {
            TransactionEntity transactionEntity = optionalTransaction.get();
            return transactionMapper.toModel(transactionEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }

}
