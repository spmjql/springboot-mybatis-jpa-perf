package com.home.skt;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.home.skt.domain.dto.PostSave;
import com.home.skt.domain.entity.BoardRepository;

@SpringBootTest
class SpringbootMybatisJpaPerfApplicationTests {

	/*
	@Test
	void contextLoads() {
	}
	*/
	
	@Autowired
	private BoardRepository boardRepository;
	//@Test
	void savePostTest() {
		IntStream.rangeClosed(0, 100000).forEach(i->{
			boardRepository.save(PostSave.builder()
					.title("게시글 제목"+i)
					.content("게시글 내용"+i)
					.writer("작성자"+i)
					.build().toEntity());
		});
	}

}
