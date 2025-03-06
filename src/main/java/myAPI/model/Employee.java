package myAPI.model;

import jakarta.persistence.*;

@Entity(name = "tb_funcionarios")
public class Employee {

    @ManyToOne
    @JoinColumn(name = "emporium_id")
    private Emporium emporium;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String funcao;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
