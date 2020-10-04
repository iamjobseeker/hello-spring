package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Member;

// interface 구현체 
public class MemoryMemberRepository implements MemberRepository {

	// key:회원아이디
	// save시 임시저장소
	private static Map<Long,Member> store = new HashMap<>();
	// key값 생성해줌
	private static long sequence = 0L;
	
	// member 파라미터 없어도 되는지 궁금
	@Override
	public Member save() {
		Member member = new Member(); //어차피 선언해줘야 하니까 파라미터로 넘기는 듯 
		member.setId(sequence);
		return member;
	}
	
	@Override
	public Member save(Member member) {
		
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
