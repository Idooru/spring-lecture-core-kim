package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        String memberName = "memberA";
        Member member = new Member(memberId, memberName, Grade.VIP);

        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
