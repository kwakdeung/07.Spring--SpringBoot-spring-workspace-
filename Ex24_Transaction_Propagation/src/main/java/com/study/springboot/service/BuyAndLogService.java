package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;
import com.study.springboot.dao.ITransaction3Dao;

@Service
public class BuyAndLogService implements IBuyTicketService {
	
	@Autowired
	BuyTicketService buyTicket;
	@Autowired
	TransactionTemplate transactionTemplate;
	@Autowired
	ITransaction3Dao transaction3;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
		
//		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					// TODO Auto-generated method stub
					int nResult = buyTicket.buy(consumerId, amount, error);
					
					// 의도적 에러 발생
					if (error.equals("2")) {int n = 10 / 0;}
					
					transaction3.pay(consumerId, amount);
				}
			});
				
			
//			transactionManager.commit(status);
			return 1;
		} catch(Exception e) {
			System.out.println("[Transaction Propagation #1] Rollback");
//			transactionManager.rollback(status);
			return 0;
		}
	}

}
