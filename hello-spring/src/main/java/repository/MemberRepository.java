package repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

// �����ϴ� �� 
public interface MemberRepository {
	Member save(Member member);
    Member save();
	Optional<Member> findById(Long id); // id�� ������ null�� ó�� 
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
