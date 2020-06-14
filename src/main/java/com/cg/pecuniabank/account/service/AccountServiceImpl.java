package com.cg.pecuniabank.account.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pecuniabank.account.dao.AccountRepository;
import com.cg.pecuniabank.account.dto.AccountEntity;
import com.cg.pecuniabank.account.exception.AccountExistException;
import com.cg.pecuniabank.account.exception.AccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repository;

	@Override
	public AccountEntity getAccountByAccNo(long accountno) throws AccountNotFoundException{
		
		Optional<AccountEntity> entity = repository.findById(accountno);
		AccountEntity account = entity.get();
		if(account.getAccountNo()==accountno) {
			return account;
		}
		else {
			throw new AccountNotFoundException("Account not found for given Account no.");
		}
	}

	@Override
	public String updateAccount(long accountNo, AccountEntity account) throws AccountNotFoundException {
		Optional<AccountEntity> entity = repository.findById(accountNo);
		
		if (!entity.isPresent()) {
			throw new AccountNotFoundException("Account not found for given Account no.");
		} else {
			account.setAccountNo(accountNo);
			repository.save(account);

			return "Account status updated successfully!";
		}
	}
	
	@Override
	public String addAccount(AccountEntity account) throws AccountExistException{
		
		Optional<AccountEntity> entity = repository.findById(account.getAccountNo());
		if (!entity.isPresent()) {
			repository.save(account);
			return "Account Added Successfully";
		}
		else {
			throw new AccountExistException("Account already exist");
		}
		
	}

	@Override
	public String deleteAccount(long accountno) throws AccountNotFoundException {
		
		Optional<AccountEntity> entity = repository.findById(accountno);
		
		if(entity.isPresent()) {
			repository.deleteById(accountno);
			return "Account deleted successfully!";
		}
		else {
			throw new AccountNotFoundException("Account not found for given Account no.");
		}
	}
}
