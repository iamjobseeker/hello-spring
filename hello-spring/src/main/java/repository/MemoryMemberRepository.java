package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Member;

// interface 구현체 
public class MemoryMemberRepository implements MemberRepository {

	// save시 임시저장소
	// key:회원아이디
	private static Map<Long,Member> store = new HashMap<>();
	
	// key값 생성해줌
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence); //ID+1
		store.put(member.getId(), member); //store(map)에 저장
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// null일 가능성 있으므로 optional.ofnullable (not null 처리와 같은 효과)
		return Optional.ofNullable(store.get(id)); 
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	// Test시 store 저장소 clear
	// 공용데이터를 지워주어야 test 문제가 발생하지 않음
	public void clearStore() {
		store.clear();
	}

}
