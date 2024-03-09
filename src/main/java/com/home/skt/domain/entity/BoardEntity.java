package com.home.skt.domain.entity;

import com.home.skt.domain.dto.BoardList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Board")
@Entity
public class BoardEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	
	public BoardList toDTO() {
		return BoardList.builder()
				.no(no)
				.title(title)
				.writer(writer)
				.readCount(readCount)
				.build();
	}
}
