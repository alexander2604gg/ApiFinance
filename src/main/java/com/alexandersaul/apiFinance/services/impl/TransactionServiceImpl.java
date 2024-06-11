package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.models.TransactionEntity;
import com.alexandersaul.apiFinance.repositories.TransactionRepository;
import com.alexandersaul.apiFinance.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl (final TransactionRepository transactionRepository ) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAll() {
        List<Transaction> listTransactions = new ArrayList<>();
        Iterable<TransactionEntity> iterableTransactions = transactionRepository.findAll();
        iterableTransactions.forEach(i -> listTransactions.add(transactionEntityToTransaction(i)));
        return listTransactions;
    }

    @Override
    public Transaction create(Transaction transaction) {
        final TransactionEntity transactionEntity = transactionToTransactionEntity(transaction);
        final TransactionEntity savedTransactionEntity = transactionRepository.save(transactionEntity);
        return transactionEntityToTransaction(savedTransactionEntity);

    }

    @Override
    public Transaction findById(long id) {

        Optional<TransactionEntity> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()) {
            TransactionEntity transactionEntity = optionalTransaction.get();
            return transactionEntityToTransaction(transactionEntity);
        }
        return null;
    }

    @Override
    public Transaction update(long id, Transaction transaction) {
        Transaction newTransaction = findById(id);
        if ( newTransaction != null) {
            newTransaction.setAmount(transaction.getAmount());
            newTransaction.setDate(transaction.getDate());
            newTransaction.setUser(transaction.getUser());
            newTransaction.setPaymentMethod(transaction.getPaymentMethod());
            newTransaction.setCategory(transaction.getCategory());
            newTransaction.setTransactionType(transaction.getTransactionType());
            TransactionEntity transactionEntity  = transactionRepository.save(transactionToTransactionEntity(newTransaction));
            return transactionEntityToTransaction(transactionEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }




    private TransactionEntity transactionToTransactionEntity(Transaction transaction){
        return TransactionEntity.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .user(transaction.getUser())
                .paymentMethod(transaction.getPaymentMethod())
                .category(transaction.getCategory())
                .transactionType(transaction.getTransactionType())
                .build();
    }

    private Transaction transactionEntityToTransaction (TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.getId())
                .amount(transactionEntity.getAmount())
                .date(transactionEntity.getDate())
                .user(transactionEntity.getUser())
                .paymentMethod(transactionEntity.getPaymentMethod())
                .category(transactionEntity.getCategory())
                .transactionType(transactionEntity.getTransactionType())
                .build();

    }

}
