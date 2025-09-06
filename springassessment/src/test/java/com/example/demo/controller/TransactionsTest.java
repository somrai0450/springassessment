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
class TransactionsControllerTest {

    @Mock
    private TransactionsImpl transactions;

    @InjectMocks
    private Transactions controller;

    @Test
    void testCalculateAndInsertRewards() {
        
        TransactionRequestBody req = new TransactionRequestBody();
        
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Inserted");

        when(transactions.insertRewards(req)).thenReturn(mockResponse);

        ResponseEntity<String> response = controller.calculateAndInsertRewards(req);

        //Assertions
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Inserted");

        verify(transactions, times(1)).insertRewards(req);
    }

    @Test
    void testGetAllTransactions() {
        // Arrange
        Transaction trans1 = new Transaction();
        trans1.setCustomerId(101);
        Transaction trans2 = new Transaction();
        trans2.setCustomerId(101);
        
        List<Transaction> mockList = Arrays.asList(trans1, trans2);
        ResponseEntity<List<Transaction>> mockResponse = ResponseEntity.ok(mockList);

        when(transactions.getAllTransactions()).thenReturn(mockResponse);

        ResponseEntity<List<Transaction>> response = controller.getAllTransactions();

        //Assertions
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getCustomerId()).isEqualTo(101);

        verify(transactions, times(1)).getAllTransactions();
    }
}