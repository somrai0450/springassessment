package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.request.body.TransactionRequestBody;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionsImpl;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TransactionsTest {

    @Mock
    private TransactionsImpl transactionsImpl;

    @InjectMocks
    private Transactions transactionsController;

    @Test
    void testCalculateAndInsertRewards_success() {
        
        TransactionRequestBody request = new TransactionRequestBody();

        doNothing().when(transactionsImpl).insertRewards(request);

        ResponseEntity<String> response = transactionsController.calculateAndInsertRewards(request);

        //Assertions
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("OK");

        verify(transactionsImpl, times(1)).insertRewards(request);
    }

    @Test
    void testCalculateAndInsertRewards_exception() {
        
        TransactionRequestBody request = new TransactionRequestBody();
        doThrow(new RuntimeException("DB error")).when(transactionsImpl).insertRewards(request);

        try {
            transactionsController.calculateAndInsertRewards(request);
        } catch (RuntimeException ex) {
            assertThat(ex.getMessage()).isEqualTo("DB error");
        }

        verify(transactionsImpl, times(1)).insertRewards(request);
    }

    @Test
    void testGetAllTransactions() {
        
        Transaction t1 = new Transaction();
        t1.setCustomerId(101);
        
        Transaction t2 = new Transaction();
        t2.setCustomerId(102);

        List<Transaction> mockList = Arrays.asList(t1, t2);

        when(transactionsImpl.getAllTransactions())
                .thenReturn(ResponseEntity.ok(mockList));

        ResponseEntity<List<Transaction>> response = transactionsController.getAllTransactions();

        //Assertions
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getCustomerId()).isEqualTo(101);

        verify(transactionsImpl, times(1)).getAllTransactions();
    }
}
