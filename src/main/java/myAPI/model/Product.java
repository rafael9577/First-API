package myAPI.model;

import jakarta.persistence.*;

@Entity(name = "tb_produtos")
public class Product {

	@ManyToOne
	@JoinColumn(name = "emporium_id")
	private Emporium emporium;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private Integer Price;
    private String descript;

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return Price;
    }

    public void setValue(Integer value) {
        Price = value;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

}
