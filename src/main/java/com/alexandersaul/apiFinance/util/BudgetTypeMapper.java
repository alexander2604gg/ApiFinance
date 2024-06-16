package com.alexandersaul.apiFinance.util;


import com.alexandersaul.apiFinance.models.BudgetType;
import com.alexandersaul.apiFinance.models.BudgetTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class BudgetTypeMapper {

    @Autowired
    private BudgetMapper budgetMapper;

    public BudgetType toModel(BudgetTypeEntity budgetTypeEntity) {
        return BudgetType.builder()
                .id(budgetTypeEntity.getId())
                .name(budgetTypeEntity.getName())
                .budgets(budgetTypeEntity.getBudgets() != null
                        ? budgetTypeEntity.getBudgets().stream()
                        .map(budgetMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }

    public BudgetTypeEntity toEntity(BudgetType budgetType) {
        return BudgetTypeEntity.builder()
                .id(budgetType.getId())
                .name(budgetType.getName())
                .budgets(budgetType.getBudgets() != null
                        ? budgetType.getBudgets().stream()
                        .map(budgetMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }



}
