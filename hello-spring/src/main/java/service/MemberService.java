package service;

import java.util.Optional;

import domain.Member;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

public class MemberService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/**
	 * ȸ������
	 * @param member
	 * @return
	 */
	public long join(Member member) {
		// name �ߺ� ����
		Optional<Member> result =  memberRepository.findByName(member.getName());
		result.ifPresent(m -> {
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
		});
		
		memberRepository.save(member);
		return member.getId();
	}
	
	
}
