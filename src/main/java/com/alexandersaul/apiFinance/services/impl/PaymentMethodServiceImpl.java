package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.PaymentMethod;
import com.alexandersaul.apiFinance.models.PaymentMethodEntity;
import com.alexandersaul.apiFinance.repositories.PaymentMethodRepository;
import com.alexandersaul.apiFinance.services.PaymentMethodService;
import com.alexandersaul.apiFinance.util.PaymentMethodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethod> getAll() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        Iterable<PaymentMethodEntity> iterablePaymentMethods = paymentMethodRepository.findAll();
        iterablePaymentMethods.forEach((i)->paymentMethods.add(paymentMethodMapper.toModel(i)));
        return paymentMethods;
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        PaymentMethodEntity newPaymentMethod = paymentMethodRepository.save(paymentMethodMapper.toEntity(paymentMethod));
        return paymentMethodMapper.toModel(newPaymentMethod);
    }

    @Override
    public PaymentMethod update(long id, PaymentMethod paymentMethod) {
        PaymentMethod newPaymentMethod = findById(id);
        if(newPaymentMethod!=null){
            newPaymentMethod.setName(paymentMethod.getName());
            PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.save(paymentMethodMapper.toEntity(newPaymentMethod));
            return paymentMethodMapper.toModel(paymentMethodEntity);
        }
        return null;
    }

    @Override
    public PaymentMethod findById(long id) {
        Optional<PaymentMethodEntity> optionalPaymentMethod = paymentMethodRepository.findById(id);
        if(optionalPaymentMethod.isPresent()){
            PaymentMethodEntity paymentMethodEntity = optionalPaymentMethod.get();
            return paymentMethodMapper.toModel(paymentMethodEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        paymentMethodRepository.deleteById(id);
    }
}
