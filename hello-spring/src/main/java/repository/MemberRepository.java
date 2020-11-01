package repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

// �����ϴ� �� 
public interface MemberRepository {

	/**
	 * ȸ������
	 */
	Member save(Member member);
	
	/**
	 * ID�� ȸ�� ã��
	 * ID�� �������� ������ null ó���Ѵ�
	 * */ 
	Optional<Member> findById(Long id);  
	
	/**
	 * �̸����� ȸ�� ã��
	 */
	Optional<Member> findByName(String name);
	
	List<Member> findAll();
}
