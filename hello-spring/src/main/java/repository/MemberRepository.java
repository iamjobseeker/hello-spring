package repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

// 저장하는 곳 
public interface MemberRepository {

	/**
	 * 회원저장
	 */
	Member save(Member member);
	
	/**
	 * ID로 회원 찾기
	 * ID가 존재하지 않으면 null 처리한다
	 * */ 
	Optional<Member> findById(Long id);  
	
	/**
	 * 이름으로 회원 찾기
	 */
	Optional<Member> findByName(String name);
	
	List<Member> findAll();
}
