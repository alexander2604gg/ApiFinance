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
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="secondName")
    private String secondName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy = "user")
    private List<TransactionEntity> transactions;
    @OneToMany(mappedBy = "user")
    private List<BudgetEntity> budgets;


}
