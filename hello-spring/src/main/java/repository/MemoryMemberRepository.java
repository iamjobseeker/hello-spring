package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Member;

// interface ����ü 
public class MemoryMemberRepository implements MemberRepository {

	// key:ȸ�����̵�
	// save�� �ӽ������
	private static Map<Long,Member> store = new HashMap<>();
	// key�� ��������
	private static long sequence = 0L;
	
	// member �Ķ���� ��� �Ǵ��� �ñ�
	@Override
	public Member save() {
		Member member = new Member(); //������ ��������� �ϴϱ� �Ķ���ͷ� �ѱ�� �� 
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
