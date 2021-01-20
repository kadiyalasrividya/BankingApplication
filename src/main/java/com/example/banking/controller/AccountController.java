package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.IAccountService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private IAccountService accountService;

  @GetMapping(value = "/accounts/{id}", produces = "application/json")
  public ResponseEntity<?> getBalanceById(final @PathVariable("id") String id) {
    Optional<Account> balance = null;
    try {
      balance = accountService.findById(id);
      if (balance.isPresent()) {
        return new ResponseEntity<>(balance, HttpStatus.OK);
      } else {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>("", HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @GetMapping(value = "/accounts/{id}/balance", produces = "application/json")
  public List<Account> getBalance(@PathVariable String id){
    return (List<Account>) accountService.getBalanceByAccountNumber(id);
  }

}
