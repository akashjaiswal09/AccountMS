package com.cg.pecuniabank.account.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pecuniabank.account.dto.AccountEntity;



public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

	List<AccountEntity> findByAccountType(String accountType);
}
