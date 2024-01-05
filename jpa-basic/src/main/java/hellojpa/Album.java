package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "Album")

public class Album extends Item {

    private String artist;

}
