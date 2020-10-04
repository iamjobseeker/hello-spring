package repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

// 저장하는 곳 
public interface MemberRepository {
	Member save(Member member);
    Member save();
	Optional<Member> findById(Long id); // id가 없으면 null로 처리 
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
