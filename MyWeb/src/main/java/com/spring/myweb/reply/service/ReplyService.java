package com.spring.myweb.reply.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.reply.dto.ReplyListResponseDTO;
import com.spring.myweb.reply.dto.ReplyRequestDTO;
import com.spring.myweb.reply.dto.ReplyUpdateRequestDTO;
import com.spring.myweb.reply.entity.Reply;
import com.spring.myweb.reply.mapper.IReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService implements IReplyService {
	// 다형성 
	
	private final IReplyMapper mapper;
	// 에러 났음 빈등록 안되어 있어서 매퍼등록안함 
	private final BCryptPasswordEncoder encoder;

	@Override
	public void replyRegist(ReplyRequestDTO dto) {
		dto.setReplyPw(encoder.encode(dto.getReplyPw())); //비밀번호 암호화
		mapper.replyRegist(dto.toEntity(dto));
	}

	@Override
	public List<ReplyListResponseDTO> getList(int bno, int pageNum) {
		
		Page page = Page.builder()
				.pageNo(pageNum) //화면에서 전달된 페이지 번호
				.amount(5) // 댓글은 한 화면에 5개씩
				.build();
//		page.setPageNo(pageNum);
//		page.setAmount(5); // 댓글은 한 화면에 5개씩
		
		Map<String, Object> map = new HashMap<>();
		map.put("paging", page);
		map.put("boardNo", bno);
		
//	 1.	List<Reply> list = mapper.getList(bno, page);
//		List<Reply> list = mapper.getList(map); // 2.
		
		List<ReplyListResponseDTO> dtoList = new ArrayList<>();
		for(Reply reply : mapper.getList(map)) {  // IReplyMapper의 getList를 reply에 넣음 
			dtoList.add(new ReplyListResponseDTO(reply));
		}
		
//		System.out.println("데이터베이스에서 불러온 댓글 목록: " + list);
		return dtoList;
	}

	@Override
	public int getTotal(int bno) {
		return mapper.getTotal(bno);  //IReplyMapper의 getTotal
	}

	@Override
	public String pwCheck(int rno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(ReplyUpdateRequestDTO dto) {
		if(encoder.matches(dto.getReplyPw(), mapper.pwCheck(dto.getReplyNo()))) {
			mapper.update(dto.toEntity(dto));
			return "updateSuccess";
		}else {
			return "pwFail";
		}
		
		

	}

	@Override
	public String delete(int rno, String replyPw) {
		if(encoder.matches(replyPw, mapper.pwCheck(rno))) {
			mapper.delete(rno);
			return "delSuccess";
		} else {
			return "pwFail";
		}

	}

	@Override
	public String delete(ReplyUpdateRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
//IReplyService 인터페이스 가져옴 
//IReplyMapper 생성자에 매개변수를 넣고
// dto에 넣어서 여기 service생성자에 넣거나
// mapper에 넣는다
	
// implements IReplyService 의 인터페이스를 가져온다
}
