package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        String memberName = "memberA";
        Member member = new Member(memberId, memberName, Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        int discountedPrice = order.calculatePrice();

        System.out.println("order = " + order);
        System.out.println("price = " + discountedPrice);
    }
}
