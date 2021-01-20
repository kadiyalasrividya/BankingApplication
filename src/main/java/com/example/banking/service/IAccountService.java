package com.example.banking.service;

import com.example.banking.model.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {

 Optional<Account> findById(String id);
  List<Account> getBalanceByAccountNumber(@Param("account_number")String id);

}
