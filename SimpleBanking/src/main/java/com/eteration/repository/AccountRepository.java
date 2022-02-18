package com.eteration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eteration.model.Account;
import java.util.Optional;
public interface AccountRepository extends JpaRepository<Account,Integer> {

		Account findByAccountNumber(String accountNumber);
}
