package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FixDiscountPolicyTest {

    FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("사용자가 VIP일 때, 정액 요금제 테스트하기")
    void testFixDiscountWhenUserVIP() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        int discountPrice = fixDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("사용자가 VIP가 아닐 때, 정액 요금제 테스트하기")
    void testFixDiscountWhenUserNotVIP() {
        // given
        Member member = new Member(2L, "memberB", Grade.BASIC);
        // when
        int discountPrice = fixDiscountPolicy.discount(member, 5000);
        // then
        assertThat(discountPrice).isEqualTo(0);
    }
}
