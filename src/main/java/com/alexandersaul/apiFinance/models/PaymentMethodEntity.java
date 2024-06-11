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
@Table(name = "PaymentMethods")
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paymentMethod")
    private long id;
    @Column(name = "name" , length = 20)
    private String name;
    @OneToMany(mappedBy = "paymentMethod")
    private List<TransactionEntity> transactions;

}
