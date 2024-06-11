package com.alexandersaul.apiFinance.repositories;

import com.alexandersaul.apiFinance.models.CategoryEntity;
import com.alexandersaul.apiFinance.models.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {



}
