package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.TransactionType;
import com.alexandersaul.apiFinance.models.TransactionTypeEntity;

public interface TransactionTypeMapper {

    TransactionType toModel (TransactionTypeEntity transactionTypeEntity);
    TransactionTypeEntity toEntity (TransactionType transactionType);

}
