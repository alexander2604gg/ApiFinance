package com.alexandersaul.apiFinance.util;
import com.alexandersaul.apiFinance.models.BudgetEntity;
import com.alexandersaul.apiFinance.models.Category;
import com.alexandersaul.apiFinance.models.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toModel(CategoryEntity category);

    CategoryEntity toEntity(Category categoryDto);

}
