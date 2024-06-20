package com.alexandersaul.apiFinance.services;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.BudgetEntity;

import java.util.List;

public interface BudgetService {

    List<Budget> getAll();
    Budget create(Budget budget);
    Budget update (long id , Budget budget);
    Budget findById (long id);
    void deleteById (long id);
}
