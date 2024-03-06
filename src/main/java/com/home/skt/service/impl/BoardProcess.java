package com.home.skt.service.impl;

import org.springframework.stereotype.Service;

import com.home.skt.domain.dto.PostSave;
import com.home.skt.domain.entity.BoardRepository;
import com.home.skt.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardProcess implements BoardService {
	
	private final BoardRepository boardRepository;

	@Override
	public void save(PostSave dto) {
		boardRepository.save(dto.toEntity());
	}

}
