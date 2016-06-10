package com.hibernate.version.example.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.version.example.model.Account;
import com.hibernate.version.example.util.HibernateUtil;

public class TestVersionDemo1 {

	public static void main(String[] args) {
		Account account=new Account();
		account.setName("HDFC Bank");
		account.setBalance(12500);
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(account);
			
			System.out.println("Success!!");
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)session.close();
		}
	}

}
