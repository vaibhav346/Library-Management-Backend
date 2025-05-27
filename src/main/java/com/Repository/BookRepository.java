package com.Repository;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	
	public List<Book> findByTitle(String name);

}
