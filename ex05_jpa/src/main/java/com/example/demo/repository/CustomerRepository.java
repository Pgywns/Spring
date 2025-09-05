package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByNameLike(String name);
	
	// class명이라 대소문자 구분 해야 함
	// ?1, ?2... 처럼 파라미터 위치를 지정해줘야 함
	@Query("select u from Customer u where u.phone like %?1% order by name desc")
	List<Customer> findByPhone(String phone);
}
