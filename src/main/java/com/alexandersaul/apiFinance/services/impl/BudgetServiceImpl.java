package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.BudgetEntity;
import com.alexandersaul.apiFinance.repositories.BudgetRepository;
import com.alexandersaul.apiFinance.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(final BudgetRepository budgetRepository ) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<Budget> getAll() {
        List<Budget> budgets = new ArrayList<>();
        Iterable<BudgetEntity> budgetEntityIterable = budgetRepository.findAll();
        budgetEntityIterable.forEach((i)-> budgets.add(budgetEntityToBudget(i)));
        return budgets;
    }

    @Override
    public Budget create(Budget budget) {
        final BudgetEntity budgetEntity = budgetRepository.save(budgetToBudgetEntity(budget));
        return budgetEntityToBudget(budgetEntity);
    }

    @Override
    public Budget update(long id, Budget budget) {
        Budget newBudget = findById(id);
        if(newBudget != null){
            newBudget.setId(budget.getId());
            newBudget.setAmount(budget.getAmount());
            newBudget.setUser(budget.getUser());
            newBudget.setCategory(budget.getCategory());
            newBudget.setBudgetType(budget.getBudgetType());
            BudgetEntity budgetEntity = budgetRepository.save(budgetToBudgetEntity(newBudget));
            return budgetEntityToBudget(budgetEntity);
        }
        return null;
    }

    @Override
    public Budget findById(long id) {
        Optional<BudgetEntity> budgetEntityOptional = budgetRepository.findById(id);
        if(budgetEntityOptional.isPresent()){
            BudgetEntity budgetEntity = budgetEntityOptional.get();
            return budgetEntityToBudget(budgetEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        budgetRepository.deleteById(id);
    }

    public BudgetEntity budgetToBudgetEntity(Budget budget) {
        return BudgetEntity.builder()
                .id(budget.getId())
                .amount(budget.getAmount())
                .user(budget.getUser())
                .category(budget.getCategory())
                .budgetType(budget.getBudgetType())
                .build();
    }

    public Budget budgetEntityToBudget (BudgetEntity budgetEntity) {
        return Budget.builder()
                .id(budgetEntity.getId())
                .amount(budgetEntity.getAmount())
                .user(budgetEntity.getUser())
                .category(budgetEntity.getCategory())
                .budgetType(budgetEntity.getBudgetType())
                .build();
    }



}
