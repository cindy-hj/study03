package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tbl_memob")
public class MemoB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idx")
	private Long id;
	
	@Column(length=200, nullable=false)
	private String memoText;
	
	@Column(length=20, nullable=true)
	private String writer;
	
	@Column(name="hits")
	private int hit;
	
	public void incHits() {
		this.hit++;
	}
}
