package com.alexandersaul.apiFinance.repositories;

import com.alexandersaul.apiFinance.models.BudgetTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface BudgetTypeRepository extends CrudRepository<BudgetTypeEntity , Long> {
}
