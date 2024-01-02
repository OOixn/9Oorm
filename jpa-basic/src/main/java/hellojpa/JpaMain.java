package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member(200L, "member200");
            em.persist(member);


            // 플러시 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영하는 것.
            // 영속성 컨텍스트를 비우지 않음.
            // 영속성 컨텍스트의 변경 내용을 데이터 베이스에 동기화한다.
            // 플러시가 발생하면 변경감지, 수정된 엔티티 쓰기 지연 SQL 저장소에 등록, 쓰기 지연 SQL 저장소의 쿼리(등록, 수정, 삭제 쿼라)를 데이터 베이스에 전송한다.
            // 플러시하는 세가지 방법, em.flush() - 직접호출 (사용하는 경우는 거의 없지만 테스트시 필요함으로 알아둬야함), 트랜잭션커밋, JPQL 쿼리 실행 - 두가지는 플러시가 자동으로 호출된다.

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
