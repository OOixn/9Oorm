package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
        public class Member extends BaseEntity{
        @Id @GeneratedValue
        @Column(name = "MEMBER_ID")
        private Long id;
        @Column(name = "USERNAME")
        private String username;

        @ManyToOne
        @JoinColumn(insertable = false, updatable = false)
        private Team team;

        @OneToOne
        @JoinColumn(name = "LOCkER_ID")
        private Locker locker;

        @OneToMany(mappedBy = "member")
        private List<MemberProduct> memberProducts = new ArrayList<>();



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public Team getTeam() {
                return team;
        }

        public void setTeam(Team team) {
                this.team = team;
        }

        public Locker getLocker() {
                return locker;
        }

        public void setLocker(Locker locker) {
                this.locker = locker;
        }

        public List<MemberProduct> getMemberProducts() {
                return memberProducts;
        }

        public void setMemberProducts(List<MemberProduct> memberProducts) {
                this.memberProducts = memberProducts;
        }
}

