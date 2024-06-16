package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.TransactionEntity;
import com.alexandersaul.apiFinance.models.TransactionType;
import com.alexandersaul.apiFinance.models.TransactionTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class TransactionTypeMapper {

    @Autowired
    private TransactionMapper transactionMapper;

    public TransactionType toModel(TransactionTypeEntity transactionType) {
        return TransactionType.builder()
                .id(transactionType.getId())
                .name(transactionType.getName())
                .transactions(transactionType.getTransactions() != null
                        ? transactionType.getTransactions().stream()
                        .map(transactionMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }

    public TransactionTypeEntity toEntity(TransactionType transactionType) {
        return TransactionTypeEntity.builder()
                .id(transactionType.getId())
                .name(transactionType.getName())
                .transactions(transactionType.getTransactions() != null
                        ? transactionType.getTransactions().stream()
                        .map(transactionMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }



}
