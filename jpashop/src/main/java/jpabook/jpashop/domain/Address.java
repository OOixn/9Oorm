package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

// 값 타입은 변경 불가능하게 설계해야 한다.
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 기본 생성자를 protected로 설정하는 것이 그나마 더 안전하다.
    // JPA 구현 라이브러리가 객체를 생성할때 리플렉션 같은 기술을 사용할 수 있도록 지원해야 하기 때문,
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
