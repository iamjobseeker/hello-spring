package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Member;

// interface ����ü 
public class MemoryMemberRepository implements MemberRepository {

	// save�� �ӽ������
	// key:ȸ�����̵�
	private static Map<Long,Member> store = new HashMap<>();
	
	// key�� ��������
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence); //ID+1
		store.put(member.getId(), member); //store(map)�� ����
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// null�� ���ɼ� �����Ƿ� optional.ofnullable (not null ó���� ���� ȿ��)
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
	
	// Test�� store ����� clear
	// ���뵥���͸� �����־�� test ������ �߻����� ����
	public void clearStore() {
		store.clear();
	}

}
