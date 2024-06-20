package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.BudgetEntity;
import com.alexandersaul.apiFinance.repositories.BudgetRepository;
import com.alexandersaul.apiFinance.services.BudgetService;
import com.alexandersaul.apiFinance.util.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private BudgetMapper budgetMapper;

    @Override
    public List<Budget> getAll() {
        List<Budget> budgets = new ArrayList<>();
        Iterable<BudgetEntity> budgetEntityIterable = budgetRepository.findAll();
        budgetEntityIterable.forEach((i)-> budgets.add(budgetMapper.toModel(i)));
        return budgets;
    }

    @Override
    public Budget create(Budget budget) {
        final BudgetEntity budgetEntity = budgetRepository.save(budgetMapper.toEntity(budget));
        return budgetMapper.toModel(budgetEntity);
    }

    @Override
    public Budget update(long id, Budget budget) {
        Budget newBudget = findById(id);
        if(newBudget != null){
            newBudget.setId(budget.getId());
            newBudget.setAmount(budget.getAmount());
            newBudget.setDate(budget.getDate());
            newBudget.setUserId(budget.getUserId());
            newBudget.setCategoryId(budget.getCategoryId());
            newBudget.setBudgetTypeId(budget.getBudgetTypeId());
            BudgetEntity budgetEntity = budgetRepository.save(budgetMapper.toEntity(newBudget));
            return budgetMapper.toModel(budgetEntity);
        }
        return null;
    }

    @Override
    public Budget findById(long id) {
        Optional<BudgetEntity> budgetEntityOptional = budgetRepository.findById(id);
        if(budgetEntityOptional.isPresent()){
            BudgetEntity budgetEntity = budgetEntityOptional.get();
            return budgetMapper.toModel(budgetEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        budgetRepository.deleteById(id);
    }

}
