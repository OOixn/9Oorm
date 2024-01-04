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
    @OneToMany(mappedBy = "team") // 외래 키가 있는 곳을 주인으로 정하자. 주인이 아니라면 적어줘야한다, 주인이 아니면 읽기만 가능하다, 주인만이 외래 키를 관리(등록, 수정), 주인이 업데이트 되면 db도 업데이트
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

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
양방향 매핑시 가장 많이 하는 실수 - 연관관계의 주인에 값을 입력하지 않음

순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자

연관관계 편의 메소드를 생성할 수 있지만, 양쪽에 만들어주면 문제가 될 수 있으므로 한쪽에만 만ㅁ들어준다. 일에 만들어도 되고 다에 만들어도 된다.

무한루프를 조심해야 한다. toString을 양쪽에서 만들경우 계속해서 실행이 된다,

단방향 매핑만으로도 이미 연관관계 매핑은 완료 된 것이다!

양방향 매핑은 반대바향으로 조회 기능이 추가된 것 뿐이다.

단방향 매핑을 잘하고 양방향은 ㅍㄹ요할 때 추가해도 된다.
 */