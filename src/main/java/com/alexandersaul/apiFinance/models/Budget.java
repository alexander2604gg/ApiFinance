package com.alexandersaul.apiFinance.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Budget {

    private long id;
    private double amount;
    private Date date;
    private long userId;
    private long categoryId;
    private long budgetTypeId;

}
