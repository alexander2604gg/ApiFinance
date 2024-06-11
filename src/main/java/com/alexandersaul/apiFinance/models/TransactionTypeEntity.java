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
@Table(name = "TransactionsTypes")
public class TransactionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transactionType")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "transactionType")
    private List<TransactionEntity> transactions;

}
