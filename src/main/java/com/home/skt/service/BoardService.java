package com.home.skt.service;

import org.springframework.ui.Model;

import com.home.skt.domain.dto.PostSave;

public interface BoardService {

	void save(PostSave dto);

	void findAll(Model model, int page);

}
