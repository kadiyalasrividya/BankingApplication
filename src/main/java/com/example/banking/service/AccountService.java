package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

  @Autowired
  private AccountRepository balanceRepository;

  @Override
  public Optional<Account> findById(String id) {
    return balanceRepository.findById(id);
  }

  @Override
  public List<Account> getBalanceByAccountNumber(String id) {
    return balanceRepository.getBalanceByAccountNumber(id);
  }
}
