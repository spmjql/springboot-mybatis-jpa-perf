package com.home.skt.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BoardList {
	private long no;
	private String title;
	private String writer;
	private int readCount;
}
