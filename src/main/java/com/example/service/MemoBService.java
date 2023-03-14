package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.MemoB;
import com.example.repository.MemoBRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoBService {
	@Autowired
	private MemoBRepository memoBRepository;
	//**************************//

	public MemoB findById(Long id) {
		Optional<MemoB> memoB = memoBRepository.findById(id);
		if(memoB.isPresent()) {
			return memoB.get();
		}
		return null;
	}

	public List<MemoB> findAll() {
		List<MemoB> list = memoBRepository.findAll();
		return list;
	}

	public MemoB update(MemoB memoB) {
		MemoB memo = memoBRepository.save(memoB);
		return memo;
	}
	
	@Transactional
	public void incHits(Long id) {
		MemoB memoB = memoBRepository.findById(id).orElse(null);
				memoB.incHits();
	}

	public List<MemoB> findByIdOrWriter(Long id, String writer) {
		List<MemoB> list = memoBRepository.findByIdOrWriter(id, writer);
		return list;
	}

	public List<MemoB> findByWriterLike(String string) {
		List<MemoB> list = memoBRepository.findByWriterLike(string);
		return list;
	}

	public List<MemoB> findByWriterStartingWith(String string) {
		List<MemoB> list = memoBRepository.findByWriterStartingWith(string);
		return list;
	}

	public List<MemoB> findByWriterContaining(String string) {
		List<MemoB> list = memoBRepository.findByWriterContaining(string);
		return list;
	}

	public List<MemoB> findByWriterEndingWith(String string) {
		List<MemoB> list = memoBRepository.findByWriterEndingWith(string);
		return list;
	}
	
}
