package com.example.demo.repo;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BookingHistory;


@Repository
public interface BookingHistoryRepo extends CrudRepository<BookingHistory, Integer> {
	
	public List<BookingHistory> findByMobile(String mobile);

}
