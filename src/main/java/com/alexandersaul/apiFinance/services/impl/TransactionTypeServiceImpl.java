package com.alexandersaul.apiFinance.services.impl;

import com.alexandersaul.apiFinance.models.TransactionType;
import com.alexandersaul.apiFinance.models.TransactionTypeEntity;
import com.alexandersaul.apiFinance.repositories.TransactionTypeRepository;
import com.alexandersaul.apiFinance.services.TransactionTypeService;
import com.alexandersaul.apiFinance.util.TransactionTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;
    @Autowired
    private TransactionTypeMapper transactionTypeMapper;

    @Override
    public List<TransactionType> getAll() {
        List<TransactionType> transactionTypes = new ArrayList<>();
        Iterable<TransactionTypeEntity> transactionsTypeIterable = transactionTypeRepository.findAll();
        transactionsTypeIterable.forEach((i)-> transactionTypes.add(transactionTypeMapper.toModel(i)));
        return transactionTypes;
    }

}
