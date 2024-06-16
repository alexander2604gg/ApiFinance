package com.alexandersaul.apiFinance.repositories;

import com.alexandersaul.apiFinance.models.PaymentMethodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethodEntity, Long> {

}
