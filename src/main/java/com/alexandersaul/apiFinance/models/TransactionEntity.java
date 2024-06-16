package com.alexandersaul.apiFinance.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private long id;
    @Column(name="amount")
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_paymentMethod")
    private PaymentMethodEntity paymentMethod;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name ="id_transactionType")
    private TransactionTypeEntity transactionType;
    @ManyToOne
    @JoinColumn(name="id_category")
    private CategoryEntity category;

}
