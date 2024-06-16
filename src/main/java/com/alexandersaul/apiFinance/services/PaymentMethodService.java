package com.alexandersaul.apiFinance.services;

import com.alexandersaul.apiFinance.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    List<PaymentMethod> getAll();
    PaymentMethod create(PaymentMethod paymentMethod);
    PaymentMethod update(long id , PaymentMethod paymentMethod);
    PaymentMethod findById(long id);
    void deleteById(long id);

}
