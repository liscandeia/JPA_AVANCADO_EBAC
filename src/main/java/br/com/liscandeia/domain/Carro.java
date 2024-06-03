package main.java.br.com.liscandeia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
    public Carro() {
        this.acessorios = new ArrayList<Acessorio>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="carro_seq")
    @SequenceGenerator(name="carro_seq", sequenceName="seq_carro", initialValue = 1, allocationSize = 1)
    private Long Id;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    @Column(name = "ANO", nullable = false)
    private int ano;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;



    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = { @JoinColumn(name = "id_carro_fk") },
            inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
    )
    private List<Acessorio> acessorios;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id", nullable = false
    )
    private Marca marca;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getAno() {
        return ano;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void add(Acessorio acessorio) {
            this.acessorios.add(acessorio);
    }
}
