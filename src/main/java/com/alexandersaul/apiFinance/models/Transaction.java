package com.alexandersaul.apiFinance.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    private long id;
    private double amount;
    private Date date;
    private PaymentMethod paymentMethod;
    private User user;
    private TransactionType transactionType;
    private Category category;

}
