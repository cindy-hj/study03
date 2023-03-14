package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MemoB;

public interface MemoBRepository extends JpaRepository<MemoB, Long> {

	List<MemoB> findByIdOrWriter(Long id, String writer);

	List<MemoB> findByWriterLike(String string);

	List<MemoB> findByWriterStartingWith(String string);

	List<MemoB> findByWriterContaining(String string);

	List<MemoB> findByWriterEndingWith(String string);
	
}
