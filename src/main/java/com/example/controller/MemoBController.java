package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MemoB;
import com.example.service.MemoBService;

@RestController
@RequestMapping("/api")
public class MemoBController {
	@Autowired
	private MemoBService memoBService;
	
	@GetMapping("/find/{id}")
	public MemoB findById(@PathVariable Long id) {
		return memoBService.findById(id);
	}
	
	@GetMapping("/findall")
	public List<MemoB> findAll() {
		return memoBService.findAll();
	}
	
	@PostMapping("/update")
	public MemoB update(@RequestBody MemoB memoB) {
		return memoBService.update(memoB);
	}
	
	@GetMapping("/findbyidor")
	public List<MemoB> findByIdOrWriter(@RequestParam("id") Long id, @RequestParam("writer") String writer) {
		return memoBService.findByIdOrWriter(id, writer);
	}
	
	@GetMapping("/findbywriterlike")
	public List<MemoB> findByWriterLike() {
		return memoBService.findByWriterLike("%"+"자");
	}
	
	@GetMapping("/startingwith")
	public List<MemoB> findByWriterStartingWith() { // 키워드+"%"
		return memoBService.findByWriterStartingWith("홍");
	}
	
	@GetMapping("/containing")
	public List<MemoB> findByWriterContaining() { // "%"+키워드+"%"
		return memoBService.findByWriterContaining("길");
	}
	
	@GetMapping("/endingwith")
	public List<MemoB> findByWriterEndingWith() { // "%"+키워드
		return memoBService.findByWriterEndingWith("동");
	}
}
