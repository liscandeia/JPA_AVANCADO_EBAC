package main.java.br.com.liscandeia.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="marca_seq")
    @SequenceGenerator(name="marca_seq", sequenceName="seq_marca", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    @OneToMany(mappedBy = "marca")
    private List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
}
