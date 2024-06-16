package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.models.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    @Autowired
    @Lazy
    UserMapper userMapper;
    @Autowired
    @Lazy
    PaymentMethodMapper paymentMethodMapper;
    @Autowired
    @Lazy
    CategoryMapper categoryMapper;
    @Autowired
    @Lazy
    TransactionTypeMapper transactionTypeMapper;

    public TransactionEntity toEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .user(transaction.getUser() != null ? userMapper.toEntity(transaction.getUser()) : null)
                .paymentMethod(transaction.getPaymentMethod() != null ? paymentMethodMapper.toEntity(transaction.getPaymentMethod()) : null)
                .category(transaction.getCategory() != null ? categoryMapper.toEntity(transaction.getCategory()) : null)
                .transactionType(transaction.getTransactionType() != null ? transactionTypeMapper.toEntity(transaction.getTransactionType()) : null)
                .build();
    }


    public Transaction toModel(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.getId())
                .amount(transactionEntity.getAmount())
                .date(transactionEntity.getDate())
                .user(transactionEntity.getUser() != null ? userMapper.toModel(transactionEntity.getUser()) : null)
                .paymentMethod(transactionEntity.getPaymentMethod() != null ? paymentMethodMapper.toModel(transactionEntity.getPaymentMethod()) : null)
                .category(transactionEntity.getCategory() != null ? categoryMapper.toModel(transactionEntity.getCategory()) : null)
                .transactionType(transactionEntity.getTransactionType() != null ? transactionTypeMapper.toModel(transactionEntity.getTransactionType()) : null)
                .build();
    }

}
