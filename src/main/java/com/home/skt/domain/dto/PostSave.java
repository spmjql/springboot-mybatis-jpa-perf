package com.home.skt.domain.dto;

import com.home.skt.domain.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class PostSave {
	private String title;
	private String writer;
	private String content;
	
	public BoardEntity toEntity() {
		return BoardEntity.builder()
				.title(title)
				.writer(writer)
				.content(content)
				.build();
	}
}
