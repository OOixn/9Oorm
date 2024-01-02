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

            /*
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZ");
            // 엔티티 변경 감지 기능이 제공된다. 다시 persist를 해주지 않아도 된다.
            // 1차 캐시 안에 Entity와 스냅샷이 존재하는데 flush 할 때 둘을 비교해서 변경이 있을 경우 UPDATE 쿼리를 쓰기 지젼 저장소에 만들어두고 커밋할때 반영이 된다고 한다.
            */

            /*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println( " ---------------------- ");
            // 선이 나온 후 쿼리문이 나가는 것을 볼 수 있다
            // 영속 컨텍스트에는 1차 캐시도 있지만 쓰기 지연 SQL 저장소도 있다.
            // persist를 하게 되면 1차 캐시에 저장되는 동시에 INSERT SQL을 쓰기 지연 SQL 저장소에 쌓아둔다.
            // transction.commit();을 하는 시점에 저장소에 있던 쿼리문이 flush가 되며 commit이 된다.
             */

            /*
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember1 == findMember2));

            // 쿼리가 한번 나가는 것을 확인할 수 있다, 처음 조회시 1차 캐시에 없다면, DB에서 조회해서 1차 캐시에 저장하고 반환하여 1차 캐시에 저장이 되어 있는 것이다.
            // JPA가 영속 엔티티의 동일성을 보장해준다. 1차 캐시가 있기 때문에 가능하다.
            */


            /* 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("Hello101");

            // 영속
            em.persist(member);

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            // 1차 캐시에 저장되어 셀렉트 쿼리가 나가지 않는 것을 확인 할 수 있다.
            */


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
