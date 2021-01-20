package com.example.banking.repository;

import com.example.banking.model.Account;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{

  List<Account> getBalanceByAccountNumber(@Param("account_number")String id);

}
