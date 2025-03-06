package myAPI.model;

import jakarta.persistence.*;

@Entity(name = "tb_account")
public class Account {

    @ManyToOne
    @JoinColumn(name = "emporium_id")
    private Emporium emporium;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;
    private String endress;
    private String fone;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndress() {
        return endress;
    }

    public void setEndress(String endress) {
        this.endress = endress;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }


}
