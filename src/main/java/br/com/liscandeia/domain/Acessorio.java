package main.java.br.com.liscandeia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="acessorio_seq")
    @SequenceGenerator(name="acessorio_seq", sequenceName="seq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    @Column(name = "DESCRICAO", length = 200, nullable = false)
    private String descricao;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public Acessorio() {
        this.carros = new ArrayList<>();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
