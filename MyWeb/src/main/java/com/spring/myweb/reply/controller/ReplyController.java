package com.spring.myweb.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myweb.reply.dto.ReplyListResponseDTO;
import com.spring.myweb.reply.dto.ReplyRequestDTO;
import com.spring.myweb.reply.dto.ReplyUpdateRequestDTO;
import com.spring.myweb.reply.service.IReplyService;
import com.spring.myweb.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController  // 객체마다 RESPONSEBODY를 붙이지 않아도 되게 한다.
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
	
	
	//jsp파일 html js와 소통 데이터를 주고 받는다.
	//sql과 소통

	private final IReplyService service; // 타입의 객체를 받는다
	
	// 댓글 등록
	@PostMapping()
	public String replyRegist(@RequestBody ReplyRequestDTO dto) {
		System.out.println("댓글 등록 요청 들어옴!" + dto);
		service.replyRegist(dto); //IReplyService의 replyRegist이다 
		return "regSuccess";
	}
	
	// 목록요청  detail.jsp 자바스크립트에서 넘어옴
	@GetMapping("/list/{bno}/{pageNum}")
	public Map<String, Object> getList(@PathVariable int bno, @PathVariable int pageNum) {
		
		/*
		 1. 화면단에서 getList 메서드가 글 번호, 페이지 번호를 url을 통해 전달합니다.
		 2. Mapper 인터페이스에게 복수의 값을 전달하기 위해 Map을 쓸지, @Param을 쓸지 결정.
		 3. ReplyMapper.xml에 sql문을 페이징 쿼리로 작성.
		 4. 클라이언트 측으로 DB에서 조회한 댓글 목록을 보낼 때
		 	페이징을 위한 댓글의 총 개수도 함께 보내줘야 합니다.
		 	근데 우리는 return을 한 개만 쓸수 있으니까, 복수개의 값을 리턴하기 위해
		 	리턴 타입을 Map으로 줄 지, 객체를 디자인해서 줄 지를 결정합니다.
		 	(댓글 목록 리스트와 전체 댓글 수를 함께 전달할 예정.) -> 일회성으로 쓸 거니까 Map으로 클라이언트에게 전달.
		 
		 */
		
		System.out.println("/list/" + bno + "/" + pageNum);
		List<ReplyListResponseDTO> list = service.getList(bno, pageNum); // 댓글 목록        IReplyService의 getList에 bno, pageNum을 넣고 list에 집어넣음
		int total = service.getTotal(bno); // 게시글에 달려있는 댓글의 총 개수 위의 것과 함께 전달해야 한다.  IReplyService의 gettotal
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", total);
		
		return map;
	}
	
	//댓글 수정 요청
	@PutMapping("/{rno}")
	public String update(@PathVariable int rno, @RequestBody ReplyUpdateRequestDTO dto) {
		dto.setReplyNo(rno);
		return service.update(dto);
	}
	
	
	// 댓글 삭제 요청
	@DeleteMapping("/{rno}")
	public String delete(@PathVariable int rno, @RequestBody String replyPw) { //@RequestBody 비밀번호가 숨겨져 있다
		System.out.println("replyPw: " + replyPw);
		return service.delete(rno, replyPw);
		
	}
	
	
	
	
	//IReplyService 의 생성자를 가져온다 생성자에 매개변수를 넣어준다
	
	
	
	
	
	
	
	
}
