package com.alexandersaul.apiFinance.controllers;

import com.alexandersaul.apiFinance.models.Budget;
import com.alexandersaul.apiFinance.models.PaymentMethod;
import com.alexandersaul.apiFinance.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/paymentMethod")

public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/resource")
    public ResponseEntity<List<PaymentMethod>> getAllPaymentsMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAll();
        return ResponseEntity.ok(paymentMethods);
    }

    @PostMapping("/resource")
    public ResponseEntity<PaymentMethod> createPaymentMethod (@RequestBody PaymentMethod paymentMethod){

        if (paymentMethod == null){
            return ResponseEntity.badRequest().build();
        }
        PaymentMethod createdPaymentMethod = paymentMethodService.create(paymentMethod);

        if (createdPaymentMethod!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPaymentMethod);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod (@PathVariable long id , @RequestBody PaymentMethod paymentMethod){

        PaymentMethod updatedPaymentMethod = paymentMethodService.update(id,paymentMethod);

        if (updatedPaymentMethod != null) {
            return ResponseEntity.ok(updatedPaymentMethod);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("resource/{id}")
    public ResponseEntity<Void> deletePaymentMethod (@PathVariable long id) {
        try{
            paymentMethodService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
