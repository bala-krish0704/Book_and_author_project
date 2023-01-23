package com.cg.bookandauthor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.baakandauthor.config.HibernateConfig;
import com.cg.bookandauthor.entity.Author;
import com.cg.bookandauthor.entity.Book;


public class BookDAO {
	public void insertBook(Book book) {
		
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//save the instructor object
			dbSession.save(book);
			//commit the transaction
			hibTrans.commit();
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public void getAllBook() {
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//get all the instructors object
			List<Book> booklist = dbSession.createQuery("from Book").list();
			System.out.println("Book Id \t Book Title \t Book Description \t Book publish date \t Author ID");
			booklist.forEach(aut ->System.out.println(aut.getBook_id() + "\t" + aut.getTitle()+"\t"+aut.getDescription()+"\t"+aut.getDate()+"\t"+aut.getAuthor_id()));
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
	}

}
