package com.alexandersaul.apiFinance.services.impl;


import com.alexandersaul.apiFinance.models.BudgetType;
import com.alexandersaul.apiFinance.models.BudgetTypeEntity;
import com.alexandersaul.apiFinance.repositories.BudgetTypeRepository;
import com.alexandersaul.apiFinance.services.BudgetTypeService;
import com.alexandersaul.apiFinance.util.BudgetTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BudgetTypeServiceImpl implements BudgetTypeService {

    @Autowired
    private BudgetTypeRepository budgetTypeRepository;
    @Autowired
    private BudgetTypeMapper budgetTypeMapper;

    @Override
    public List<BudgetType> getAll() {
        List<BudgetType> budgetTypes = new ArrayList<>();
        Iterable<BudgetTypeEntity> budgetEntityIterable = budgetTypeRepository.findAll();
        budgetEntityIterable.forEach((i)-> budgetTypes.add(budgetTypeMapper.toModel(i)));
        return budgetTypes;
    }

}
