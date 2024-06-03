package test.java.br.com.liscandeia;

import main.java.br.com.liscandeia.dao.*;
import main.java.br.com.liscandeia.domain.Acessorio;
import main.java.br.com.liscandeia.domain.Carro;
import main.java.br.com.liscandeia.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;
    private ICarroDao carroDao;

    public CarroTest() {
        this.marcaDao = new MarcaDao();
        this.acessorioDao = new AcessorioDao();
        this.carroDao = new CarroDao();
    }
    @Test
    public void cadastroCarroTest(){
        Marca marca = cadastraMarca();
        Acessorio acessorio = cadastraAcessorio("A");
        Acessorio acessorio2 = cadastraAcessorio("B");
        Carro carro = new Carro ();
        carro.setNome("Uno");
        carro.setAno(1999);
        carro.setCodigo("A");
        carro.add(acessorio);
        carro.add(acessorio2);
        carro.setMarca(marca);
        carroDao.cadastrar(carro);
        assertNotNull(carro);
        assertNotNull(carro.getId());

    }




    private Marca cadastraMarca(){
        Marca marca = new Marca();
        marca.setNome("FIAT");
        marca.setCodigo("A");
        return marcaDao.cadastrar(marca);
    }
    private Acessorio cadastraAcessorio(String codigo){
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Ar - Condicionado");
        acessorio.setDescricao("Ar quente e frio");
        acessorio.setCodigo(codigo);
        return acessorio;
    }
}
