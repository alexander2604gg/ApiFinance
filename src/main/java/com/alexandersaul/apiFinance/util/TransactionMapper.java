package com.alexandersaul.apiFinance.util;

import com.alexandersaul.apiFinance.models.Transaction;
import com.alexandersaul.apiFinance.models.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "paymentMethod.id", target = "paymentMethodId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "transactionType.id", target = "transactionTypeId")
    @Mapping(source = "category.id", target = "categoryId")
    Transaction toModel (TransactionEntity transactionEntity);
    @Mapping(source = "paymentMethodId", target = "paymentMethod.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "transactionTypeId", target = "transactionType.id")
    @Mapping(source = "categoryId", target = "category.id")
    TransactionEntity toEntity (Transaction transaction);

}
