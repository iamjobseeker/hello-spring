package repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.Member;

class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	//test���������� member��ü�� clear���ֱ� ����
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		System.out.println("result: " + (result == member));
		
		Assertions.assertEquals(member, result); // result�� member�� ������ ��  
	
	}
	
	@Test
	// ����� ���Խ�Ű��(save) ã�ƺ��� 
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result1 = repository.findByName("spring1").get();
		
		System.out.println("result1: " + (result1 == member1));
		
	}
	
	@Test
	// ����� ���Խ�Ű��(save) ��� ����� ���� �������� 
	public void findAll() {
		/*1��° �����*/
		Member Savemember = new Member();
		Savemember.setName("myName");
		
		repository.save(Savemember);
		
		/*2��° �����*/
		Member Savemember2 = new Member();
		Savemember2.setName("yourName");
		
		repository.save(Savemember2);

		
		List<Member> list = new ArrayList<>();
		list = repository.findAll();
		
		for(Member lst : list) {
			System.out.println("member: " + lst.getName() + ", " + lst.getId());
		}
	}
}



