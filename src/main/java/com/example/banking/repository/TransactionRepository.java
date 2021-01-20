package com.example.banking.repository;

import com.example.banking.model.Transaction;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

  @Query(value = "select * from transaction where account_id =:account_id and date(time) between :startDate and :endDate and type in :type",nativeQuery = true)
  List<Transaction> getTransactionByAccountId(@Param("account_id")String id,
      @Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("type") List<String> type);
}
