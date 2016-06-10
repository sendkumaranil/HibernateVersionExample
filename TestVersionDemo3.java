package com.hibernate.version.example.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.version.example.model.Account;
import com.hibernate.version.example.util.HibernateUtil;

public class TestVersionDemo3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			Account account=(Account)session.get(Account.class, 7);
			System.out.println("Set break point here.and run TestVersionDemo3");			
			account.setName("suresh");
			
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
