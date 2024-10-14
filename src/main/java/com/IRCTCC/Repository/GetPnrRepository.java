package com.IRCTCC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IRCTCC.Pojo.Book;

@Repository
public interface GetPnrRepository extends JpaRepository<Book,Long> {
	 Book findByBookingId(String bookingId);
}
