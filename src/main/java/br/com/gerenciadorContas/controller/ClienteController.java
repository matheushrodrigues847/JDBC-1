package main.java.br.com.gerenciadorContas.controller;

import br.com.gerenciaContas.DAO.ClienteDAO;
import br.com.gerenciaContas.modelo.Cliente;
import br.com.gerenciaContas.DAO.DAO;
import br.com.gerenciaContas.factory.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class ClienteController implements DAO {
    private ClienteDAO clienteDAO;

    public ClienteController(){
        Connection connection = new ConnectionFactory().recuperaConexao();
        this.clienteDAO = new ClienteDAO(connection);
    }

    @Override
    public List<Cliente> listar() {
        return clienteDAO.listar();
    }

    @Override
    public void criar(Object cliente) {
        clienteDAO.criar(cliente);
    }

    @Override
    public void alterar(Object classe) {

    }

    @Override
    public void deletar(int id) {

    }
}
