package main.java.br.com.gerenciadorContas.DAO;

import java.util.List;

public interface DAO {
    public List listar();
    public void criar(Object classe);
    public void alterar(Object classe);
    public void deletar(int id);
}
