package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //id 자동생성: 아이덴티디 전략
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "username")
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
