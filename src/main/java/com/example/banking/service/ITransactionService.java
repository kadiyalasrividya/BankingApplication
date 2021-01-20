package com.example.banking.service;

import com.example.banking.model.Transaction;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {

  List<Transaction> findAll();
  List<Transaction> getTransactionByAccountId(String id,
      Date startDate, Date endDate, String timeRange, List<String> type);
}


