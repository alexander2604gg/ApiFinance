package com.alexandersaul.apiFinance.util;


import com.alexandersaul.apiFinance.models.PaymentMethod;
import com.alexandersaul.apiFinance.models.PaymentMethodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PaymentMethodMapper {

    PaymentMethod toModel(PaymentMethodEntity paymentMethodEntity);
    PaymentMethodEntity toEntity (PaymentMethod paymentMethod);

}
