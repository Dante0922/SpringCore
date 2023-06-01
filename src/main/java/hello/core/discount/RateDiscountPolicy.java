package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("rateDiscountPolicy") // 빈 이름을 지정해주는 방법
//@Primary // @Primary를 사용하면 @Autowired 시에 여러 빈이 매칭되면 @Primary가 우선권을 가진다.
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {


    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }


}
