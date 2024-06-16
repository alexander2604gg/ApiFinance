package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.PaymentMethod;
import com.alexandersaul.apiFinance.models.PaymentMethodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class PaymentMethodMapper {

    @Autowired
    private TransactionMapper transactionMapper;

    public PaymentMethod toModel(PaymentMethodEntity paymentMethodEntity) {
        return PaymentMethod.builder()
                .id(paymentMethodEntity.getId())
                .name(paymentMethodEntity.getName())
                .transactions(paymentMethodEntity.getTransactions() != null
                        ? paymentMethodEntity.getTransactions().stream()
                        .map(transactionMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }

    public PaymentMethodEntity toEntity(PaymentMethod paymentMethod) {
        return PaymentMethodEntity.builder()
                .id(paymentMethod.getId())
                .name(paymentMethod.getName())
                .transactions(paymentMethod.getTransactions() != null
                        ? paymentMethod.getTransactions().stream()
                        .map(transactionMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }



}
