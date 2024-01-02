package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    // 객체는 username이라고 쓰고 싶은데 DB에는 name이라고 써야 할 때
    /*
    속성 //  설명                      //기본값
    name // 필드와 매핑할 테이블의 컬럼 이름 //객체의 필드 이름
    insertable, updatable // 등록, 변경 가능 여부 // TRUE
    nullable(DDL) // null 값의 허용 여부를 설정한다. false로 설정하면 DDL 생성 시에 not null 제약조건이 붙는다. //
    unique(DDL) // @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제 약조건을 걸 때 사용한다. //
    columnDefinition (DDL) // 데이터베이스 컬럼 정보를 직접 줄 수 있다. ex) varchar(100) default ‘EMPTY' // 필드의 자바 타입과 방언 정보를 사용해서 적절한 컬럼 타입
    length(DDL) // 문자 길이 제약조건, String 타입에만 사용한다. // 255
    precision, scale(DDL) // BigDecimal 타입에서 사용한다(BigInteger도 사용할 수 있다). precision은 소수점을 포함한 전체 자 릿수를, scale은 소수의 자릿수 다. 참고로 double, float 타입에는 적용되지 않는다. 아주 큰 숫자나 정 밀한 소수를 다루어야 할 때만 사용한다. // precision=19, scale=2
     */
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    // DB에는 enum타입이 없어서 Enumerated 써주면 된다.
    // 기본값 = EnumType.ORDINAL 그치만 사용하지 않는다.
    // EnumType.ORDINAL: enum 순서를 데이터베이스에 저장
    // EnumType.STRING: enum 이름을 데이터베이스에 저장
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    // 날짜 타입(java.util.Date, java.util.Calendar)을 매핑할 때 사용
    // 지금은 사용하지 않는다.
    // LocalDate, LocalDateTime을 사용할 때는 생략 가능(최신 하이버네이트 지원)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;
// 데이터베이스 BLOB, CLOB 타입과 매핑
// @Lob에는 지정할 수 있는 속성이 없다.
// 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
// CLOB: String, char[], java.sql.CLOB BLOB: byte[], java.sql. BLOB


    /*
    @Transient // 특정 필드를 컬럼에 매핑하지 않음(매핑 무시)
    private int temp;
     */

    public Member(){}
}
