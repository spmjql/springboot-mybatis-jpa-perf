package com.home.skt;

import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.home.skt.domain.dto.PostSave;
import com.home.skt.domain.entity.BoardRepository;
import com.home.skt.service.BoardService;

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
	
	@Autowired
	private BoardService boardService;
	@Test
	void getListTest() {
		Model model = new Model() {
			
			@Override
			public Model mergeAttributes(Map<String, ?> attributes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getAttribute(String attributeName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAttribute(String attributeName) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Map<String, Object> asMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAttribute(String attributeName, Object attributeValue) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAttribute(Object attributeValue) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAllAttributes(Map<String, ?> attributes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAllAttributes(Collection<?> attributeValues) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		boardService.findAll(model);
	}

}
