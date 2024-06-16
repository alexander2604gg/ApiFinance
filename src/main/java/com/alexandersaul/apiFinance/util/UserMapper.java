package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.User;
import com.alexandersaul.apiFinance.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    BudgetMapper budgetMapper;
    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .transactions(user.getTransactions() != null
                        ? user.getTransactions().stream()
                        .map(transactionMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .budgets(user.getBudgets() != null
                        ? user.getBudgets().stream()
                        .map(budgetMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }

    public User toModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .transactions(userEntity.getTransactions() != null
                        ? userEntity.getTransactions().stream()
                        .map(transactionMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .budgets(userEntity.getBudgets() != null
                        ? userEntity.getBudgets().stream()
                        .map(budgetMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }


}
