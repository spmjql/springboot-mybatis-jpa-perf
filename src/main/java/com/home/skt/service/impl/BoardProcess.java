package com.home.skt.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.home.skt.aspect.LogPerf;
import com.home.skt.domain.dto.PostSave;
import com.home.skt.domain.entity.BoardEntity;
import com.home.skt.domain.entity.BoardRepository;
import com.home.skt.service.BoardService;
import com.home.skt.utils.PageData;

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

	@LogPerf
	@Override
	public void findAll(Model model, int page) {
		System.out.println(page);
		pageablebeList(model, page);
//		listAll(model);
	}
	private void pageablebeList(Model model, int page) {
		int pageLimit = 10;
		Pageable pageable = PageRequest.of(page-1, pageLimit);
		Page<BoardEntity> pageBoard = boardRepository.findAll(pageable);
		
		//페이지 리스트
		model.addAttribute( "pageList",pageBoard.getContent().stream().map(BoardEntity::toDTO).collect(Collectors.toList()) );
		//페이지번호 리스트
		model.addAttribute( "pu", PageData.create(page, pageLimit, (int)pageBoard.getTotalElements()) );
	}
	private void listAll(Model model) {
		model.addAttribute("listAll", boardRepository.findAll().stream().map(BoardEntity::toDTO).collect(Collectors.toList()) );
	}

}
