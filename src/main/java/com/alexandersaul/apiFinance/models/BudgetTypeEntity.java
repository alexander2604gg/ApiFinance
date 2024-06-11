package com.alexandersaul.apiFinance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BudgetsTypesEntity")

public class BudgetTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_budgetType")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "budgetType")
    private List<BudgetEntity> budgets;

}
