package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService2")// 빈의 기본 이름은 클래스의 맨 앞 글자를 소문자로 변경하여 사용하지만, 직접 빈 이름을 지정 가능하다
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 생성자에 지정해주면 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다 기본은 타입이 같은 빈을 찾아서 주입한다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
