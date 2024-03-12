package com.home.skt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.skt.domain.dto.PostSave;
import com.home.skt.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
	
	private final BoardService service;

	@GetMapping
	public String board(Model model) {
		service.findAll(model);
		return "views/board/board";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		return "views/board/board";
	}
	
	@PostMapping
	public String save(PostSave dto) {
		service.save(dto);
		return "views/board/board";
	}
}
