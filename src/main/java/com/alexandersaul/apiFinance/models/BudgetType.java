package com.alexandersaul.apiFinance.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetType {

    private long id;
    private String name;
    private List<BudgetEntity> budgets;

}
