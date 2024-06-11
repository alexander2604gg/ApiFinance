package com.alexandersaul.apiFinance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Budgets")
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_budget")
    private long id;
    @Column(name = "amount")
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name ="id_user")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name ="id_category")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name="id_budgetType")
    private BudgetTypeEntity budgetType;


}
