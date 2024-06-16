package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private BudgetMapper budgetMapper;


    public Category toModel(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .transactions(categoryEntity.getTransactions() != null
                        ? categoryEntity.getTransactions().stream()
                        .map(transactionMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .budgets(categoryEntity.getBudgets() != null
                        ? categoryEntity.getBudgets().stream()
                        .map(budgetMapper::toModel)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }


    public CategoryEntity toEntity(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .transactions(category.getTransactions() != null
                        ? category.getTransactions().stream()
                        .map(transactionMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .budgets(category.getBudgets() != null
                        ? category.getBudgets().stream()
                        .map(budgetMapper::toEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }



}
