package main.java.br.com.gerenciadorContas.controller;

import main.java.br.com.gerenciadorContas.DAO.ContaDAO;
import br.com.gerenciaContas.DAO.ContaDAO;
import br.com.gerenciaContas.DAO.DAO;
import br.com.gerenciaContas.factory.ConnectionFactory;
import br.com.gerenciaContas.modelo.Conta;
import main.java.br.com.gerenciadorContas.factory.ConnectionFactory;
import main.java.br.com.gerenciadorContas.modelo.Conta;

import java.sql.Connection;
import java.util.List;

public class ContaController implements DAO {
    private ContaDAO contaDAO;

    public ContaController(){
        Connection conexao = new ConnectionFactory().recuperaConexao();
        this.contaDAO = new ContaDAO(conexao);
    }

    @Override
    public List<Conta> listar(){
        return contaDAO.listar();
    }

    @Override
    public void criar(Object conta) {
        contaDAO.criar(conta);
    }

    @Override
    public void alterar(Object classe) {
        contaDAO.alterar(classe);
    }

    @Override
    public void deletar(int id) {
        contaDAO.deletar(id);
    }
}
