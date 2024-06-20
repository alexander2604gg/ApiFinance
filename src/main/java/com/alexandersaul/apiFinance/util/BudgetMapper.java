package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.BudgetEntity;
import com.alexandersaul.apiFinance.services.BudgetService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper (componentModel = "spring")
public interface BudgetMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "budgetType.id", target = "budgetTypeId")
    Budget toModel (BudgetEntity budgetEntity);
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "budgetTypeId", target = "budgetType.id")
    BudgetEntity toEntity (Budget budget);




}

