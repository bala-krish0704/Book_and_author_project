package com.cg.bookandauthor;


import com.cg.bookandauthor.dao.AuthorDAO;
import com.cg.bookandauthor.dao.BookDAO;
import com.cg.bookandauthor.entity.Author;
import com.cg.bookandauthor.entity.Book;

public class OneToOneBookAuthor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book bk = new Book();
		bk.setBook_id(1234);
		bk.setTitle("Java");
		bk.setDescription("Core java");
		bk.setDate("10-10-1999");
		
		BookDAO bkd = new BookDAO();
		bkd.insertBook(bk);
		

		
		
		
		
		//create instructor details object
		Author aut = new Author();
		aut.setAuthor_id(999);
		aut.setAuthor_name("Balaguruswamy");
		aut.setEmailid("balaguruswamy143@gmail.com");
		
		
		
		AuthorDAO auth = new AuthorDAO();
		auth.insertAuthor(aut);
		
		auth.getAllInstructors();
		bkd.getAllBook();
		
		
	

	}

}
