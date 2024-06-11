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
@Table(name = "Categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<TransactionEntity> transactions;
    @OneToMany(mappedBy = "category")
    private List<BudgetEntity> budgets;
}
