package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.BudgetType;
import com.alexandersaul.apiFinance.models.BudgetTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface BudgetTypeMapper {

    BudgetType toModel (BudgetTypeEntity budgetTypeEntity);
    BudgetTypeEntity toEntity (BudgetType budgetType);

}
