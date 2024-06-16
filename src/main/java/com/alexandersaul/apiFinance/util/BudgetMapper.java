package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.BudgetEntity;
import com.alexandersaul.apiFinance.models.BudgetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper {

    @Autowired
    @Lazy
    private UserMapper userMapper;
    @Autowired
    @Lazy
    private CategoryMapper categoryMapper;
    @Autowired
    @Lazy
    private BudgetTypeMapper budgetTypeMapper;

    public Budget toModel(BudgetEntity budgetEntity) {
        return Budget.builder()
                .id(budgetEntity.getId())
                .date(budgetEntity.getDate())
                .user(budgetEntity.getUser() != null ? userMapper.toModel(budgetEntity.getUser()) : null)
                .category(budgetEntity.getCategory() != null ? categoryMapper.toModel(budgetEntity.getCategory()) : null)
                .budgetType(budgetEntity.getBudgetType() != null ? budgetTypeMapper.toModel(budgetEntity.getBudgetType()) : null)
                .build();
    }

    public BudgetEntity toEntity(Budget budget) {
        return BudgetEntity.builder()
                .id(budget.getId())
                .date(budget.getDate())
                .user(budget.getUser() != null ? userMapper.toEntity(budget.getUser()) : null)
                .category(budget.getCategory() != null ? categoryMapper.toEntity(budget.getCategory()) : null)
                .budgetType(budget.getBudgetType() != null ? budgetTypeMapper.toEntity(budget.getBudgetType()) : null)
                .build();
    }





}
