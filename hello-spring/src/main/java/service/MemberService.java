package service;

import java.util.Optional;

import domain.Member;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

public class MemberService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public long join(Member member) {
		// name 중복 방지
		Optional<Member> result =  memberRepository.findByName(member.getName());
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
		
		memberRepository.save(member);
		return member.getId();
	}
	
	
}
