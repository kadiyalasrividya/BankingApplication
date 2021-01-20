package com.example.banking.controller;

import com.example.banking.model.Transaction;
import com.example.banking.service.ITransactionService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

  @Autowired
  private ITransactionService transactionService;

  @GetMapping(value = "/transactionDetails", produces = "application/json")
  public List<Transaction> getAllTransactions() {
    return (List<Transaction>) transactionService.findAll();
  }

  @GetMapping(value = "/accounts/{id}/transactions", produces = "application/json")
  public List<Transaction> getTransactionsByAccountId(final @PathVariable("id") String id,
      @RequestParam (value = "startDate", required = false) @DateTimeFormat(iso = ISO.DATE) Date startDate,
      @RequestParam (value = "endDate", required = false) @DateTimeFormat(iso = ISO.DATE) Date endDate,
      @RequestParam (value = "timeRange", required = false, defaultValue = "today")String timeRange,
      @RequestParam (value = "type", required = false)String type) {
    List<String> transactionType = new ArrayList<>();
    if (type == null) {
      transactionType.add("withdraw");
      transactionType.add("deposit");
    } else if (type.equalsIgnoreCase("deposit")) {
      transactionType.add("deposit");
    } else if (type.equalsIgnoreCase("withdraw")) {
      transactionType.add("withdraw");
    }

    return transactionService.getTransactionByAccountId(id, startDate, endDate, timeRange, transactionType);
  }

}
