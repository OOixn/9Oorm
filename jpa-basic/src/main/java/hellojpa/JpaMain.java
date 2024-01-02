package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

// 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유해야 한다.
// 엔티티 매니저는 쓰레드간에 공유X (사용하고 버려야 한다).
// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }


//            Member findMember = em.find(Member.class, 1L);
            //수정
//            findMember.setName("HelloJPA");

            //삭제
            // em.remove();

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
