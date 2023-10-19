package com.spring.myweb.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.myweb.user.dto.UserInfoResponseDTO;
import com.spring.myweb.user.dto.UserJoinRequestDTO;
import com.spring.myweb.user.entity.User;
import com.spring.myweb.user.mapper.IUserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final IUserMapper mapper;
	private final BCryptPasswordEncoder encoder;

	public int idCheck(String account) {
		return mapper.idCheck(account); //IUserMapper 에서 가져옴
	}

	public void join(UserJoinRequestDTO dto) {
		//회원 비밀번호 암호화 인코딩
		System.out.println("암호화 하기 전 비번: " + dto.getUserPw());
		
		//비밀번호를 암호화 해서 dto에 저장하기
		String securePw = encoder.encode(dto.getUserPw());
		System.out.println("암호화 후 비번: " + securePw);
		dto.setUserPw(securePw);
		
	
		//dto를 entity로 변환
		User user = User.builder()
				.userId(dto.getUserId())
				.userPw(dto.getUserPw())
				.userName(dto.getUserName())
				.userPhone1(dto.getUserPhone1())
				.userPhone2(dto.getUserPhone2())
				.userEmail1(dto.getUserEmail1())
				.userEmail2(dto.getUserEmail2())
				.addrBasic(dto.getAddrBasic())
				.addrDetail(dto.getAddrDetail())
				.addrZipNum(dto.getAddrZipNum())
				.build();
		mapper.join(user);
	}

	public String login(String userId, String userPw) {
		String dbPw = mapper.login(userId); // IUserMapper 에서 가져옴
		if(dbPw != null) {
			// 전에는 처음만든 비밀번호로는 로그인이 안되고 암호화된 비밀번호를 입력해야 로그인이 된다
			// 날것의 비밀번호와 암호화된 비밀번호의 일치 여부를 알려주는 matches()
			if(encoder.matches(userPw, dbPw)) {
				return userId;
			}
			//이제는 처음만든 비밀번호를 입력해도 로그인이 된다.
			//이제는 암호화된 비밀번호를 사용자 입력과 비교 matches가 일치한지 true or false로 알려준다
		}
		return null;
	}

	public UserInfoResponseDTO getInfo(String id) {
		User user = mapper.getInfo(id); // IUserMapper 에서 가져옴
		return UserInfoResponseDTO.toDTO(user);	 //UserInfoResponseDTO 의 toDTO 에  user를 보낸다
	}

	

}
