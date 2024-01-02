package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// Entity가 붙은 클래스는 JPA가 관리하게 된다. JPA를 사용해서 테이블과 맾핑할 클래스는 @Entity가 필수다.
// 기본 생성자가 필수로 작성되어야 한다. (파라미터가 없는 public 또는 protected 생성자)
// final 클래스, enum, interface, inner 클래스는 사용할 수 없다.
// 저장할 필드에 final을 사용하면 안된다.
// @Table(name = "매핑할 테이블 이름") 다른 테이블과 매핑할 수 있다.
@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    public Member(){

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
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
