package com.alexandersaul.apiFinance.repositories;

import com.alexandersaul.apiFinance.models.BudgetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, Long> {

}
