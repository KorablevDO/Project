package ProjectServer.DataBases.SpringData.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TestTableEntity")
public class TestTableEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public TestTableEntity() {
    }

    public TestTableEntity(String name) {
        this.name = name;
    }

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
