package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
연관관게 매핑시 고려사항 3가지

다중성.
다대일 @ManyToOne, 일대다 @OneToMany, 일대일 @OneToOne, 다대다 @ManyToMany <- 실무에서 사용하면 안된다.

단방향, 양방향
테이블
- 외래 키  하나로 양쪽 조인 가능
- 사실 방향이라는 개념이 없다.
객체
- 참조용 필드가 있는 쪽으로만 참조 가능
- 한쪽만 참조하면 단방향
- 양쪽이 서로 참조하면 양방향

연관관계의 주인
- 테이블은 외래 키 하나로 두 테이블이 연관관계를 맺음
- 객체 양방향 관계는 A->B, B->A 처럼 참조가 2군데
- 객체 양방향 관계는 참조가 2군데 있음. 둘중 테이블의 외래 키를 관리할 곳을 지정해야함
- 연관관계의 주인: 외래 키를 관리하는 참조
- 주인의 반대편: 외래 키에 영향을 주지 않음, 단순 조회만 가능

다대일 [N:1] 가장 많이 사용한다.

외래 키가 있는 쪽이 연관관의 주인이다.

양쪽을 서로 참조하도록 개발해야한다.


 */