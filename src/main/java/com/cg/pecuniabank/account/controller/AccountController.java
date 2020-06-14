package com.cg.pecuniabank.account.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecuniabank.account.dto.AccountEntity;
import com.cg.pecuniabank.account.exception.AccountExistException;
import com.cg.pecuniabank.account.exception.AccountNotFoundException;
import com.cg.pecuniabank.account.service.AccountService;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService service;

	// http://localhost:9090/accounts/accountno/123412341234

	@RequestMapping(value = "/accountno/{accno}", headers = "Accept=application/json", method = RequestMethod.GET)
	public ResponseEntity<AccountEntity> getAccountByAccNo(@Min(100000000000L) @PathVariable ("accno") long accNo) throws AccountNotFoundException {
		AccountEntity account = service.getAccountByAccNo(accNo);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}

	// http://localhost:9090/accounts/addaccount/
	@RequestMapping(value = "/addaccount/", consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addAccount( @Valid @RequestBody AccountEntity account) throws AccountExistException {
		String msg= service.addAccount(account);
		ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);//
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);

	}

	//http://localhost:9090/accounts/updateaccount/123412341234/
	@RequestMapping(value ="/updateaccount/{accountno}/",
			headers="Accept=application/json",	method = RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAccountByAccNo(@Valid @Min(100000000000L) @PathVariable("accountno") long accountno,
			@RequestBody AccountEntity account) throws AccountNotFoundException {
		return ResponseEntity.ok(service.updateAccount(accountno, account));

	}
	// http://localhost:9090/accounts/deleteaccount/123412341234/
	@RequestMapping(value = "/deleteaccount/{accountno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccountByAccNo(@Min(100000000000L) @PathVariable("accountno") long accountno) throws AccountNotFoundException {
		String msg= service.deleteAccount(accountno);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);

	}

}
