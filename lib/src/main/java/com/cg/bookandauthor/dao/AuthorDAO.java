package com.cg.bookandauthor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cg.baakandauthor.config.HibernateConfig;
import com.cg.bookandauthor.entity.Author;



public class AuthorDAO {
	public void insertAuthor(Author auth) {
		
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//save the instructor object
			dbSession.save(auth);
			//commit the transaction
			hibTrans.commit();
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public void getAllInstructors() {
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//get all the instructors object
			List<Author> authorlist = dbSession.createQuery("from Author").list();
			System.out.println("Author ID \t Author Name \t Author mailid");
			authorlist.forEach(aut ->System.out.println(aut.getAuthor_id() + "\t" + aut.getAuthor_name()+"\t"+aut.getEmailid()));
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
	}
}
