package com.cg.pecuniabank.account.service;

import com.cg.pecuniabank.account.dto.AccountEntity;
import com.cg.pecuniabank.account.exception.AccountExistException;
import com.cg.pecuniabank.account.exception.AccountNotFoundException;

public interface AccountService {

	public AccountEntity getAccountByAccNo(long accountno) throws AccountNotFoundException;	
	public String updateAccount(long accountno, AccountEntity account) throws AccountNotFoundException;
	public String addAccount(AccountEntity account) throws AccountExistException;
	public String deleteAccount(long accountno) throws AccountNotFoundException;

}
