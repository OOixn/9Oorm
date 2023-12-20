package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private  MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;

//    생성자 주입 - 생성자를 통해서 의존관계를 주입 받는 방법
//    생성자 호출 시점에 딱 1번만 호출되는 것이 보장된다.
//    불편, 필수 의존 관계에 사용
//    생성자가 하나만 있으면 @autowired 생략가능 * 스프링 빈에만 해당됨

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
