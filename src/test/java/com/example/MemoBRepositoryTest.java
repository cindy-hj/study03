package com.example;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.example.model.MemoB;
import com.example.repository.MemoBRepository;
import com.example.service.MemoBService;

@SpringBootTest
public class MemoBRepositoryTest {
	
	@Autowired
	MemoBRepository memoBRepository;
	
	@Autowired
	MemoBService memoBService;
	
	@Test
	public void InsertMemoB() {
		MemoB memo = MemoB.builder()
						  .memoText("sample1")
						  .writer("관리자")
						  .build();
		memoBRepository.save(memo);
	}
	
	@Test
	public void InserMemoB2() {
		for(int i=1; i<=10; i++) {
			MemoB memoB = MemoB.builder()
							   .memoText("sample"+i)
							   .writer("관리자2")
							   .hit(0)
							   .build();

			memoBRepository.save(memoB);
		}
	}
	
	@Test
	public void SelectMemoB() {
		Long id = 1L;
		Optional<MemoB> result = memoBRepository.findById(id);
		System.out.println("============");
		if(result.isPresent()) {
			MemoB memoB = result.get();
			System.out.println(memoB);
		}
	}
	
	@Test
	public void UpdateMemoB() {
		MemoB memoB = MemoB.builder()
						   .id(1L)
						   .memoText("메모 수정")
						   .writer("작가")
						   .build();
		memoBRepository.save(memoB);
	}
	
	@Test
	public void DeleteMemoB() {
		Long id = 1L;
		memoBRepository.deleteById(id);
	}
	
	@Test
	public void incHits() {
		memoBService.incHits(2L);
	}
}
