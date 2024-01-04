package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
        public class Member {
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

}

