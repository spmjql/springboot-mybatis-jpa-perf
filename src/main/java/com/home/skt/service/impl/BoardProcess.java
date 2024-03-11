package com.home.skt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.home.skt.aspect.LogPerf;
import com.home.skt.domain.dto.PostSave;
import com.home.skt.domain.entity.BoardEntity;
import com.home.skt.domain.entity.BoardRepository;
import com.home.skt.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardProcess implements BoardService {
	
	private final BoardRepository boardRepository;

	@LogPerf
	@Override
	public void save(PostSave dto) {
		boardRepository.save(dto.toEntity());
	}

//	@LogPerf
	@Override
	public void findAll(Model model) {
		pageablebeList(model);
		listAll(model);
	}
	@LogPerf
	private void pageablebeList(Model model) {
		Pageable pageable = PageRequest.of(0, 10);
		model.addAttribute( boardRepository.findAll(pageable).getContent().stream().map(BoardEntity::toDTO).collect(Collectors.toList()) );
	}
	@LogPerf
	private void listAll(Model model) {
		model.addAttribute("listAll", boardRepository.findAll().stream().map(BoardEntity::toDTO).collect(Collectors.toList()) );
	}

}
