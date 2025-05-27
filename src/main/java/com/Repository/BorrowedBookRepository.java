package com.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.BorrowedBook;

import jakarta.transaction.Transactional;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {

	@Modifying
	@Transactional
	@Query(value="insert into  borrowed_book (borrowId,borrowDate,returnDate) values(:borrowId,:borrowDate,:returnDate)",nativeQuery=true)
	public void saveborrowdate(@Param("borrowedId")Long borrowId,@Param("borrowDate")LocalDate borrowDate,@Param("returnDate")LocalDate returnDate);
}
