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
public class User {

    private long id;
    private String name;
    private String secondName;
    private String email;
    private String password;
    private List<Transaction> transactions;
    private List<Budget> budgets;

}
