package main.java.br.com.gerenciadorContas.DAO;

import br.com.gerenciaContas.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO {
    private Connection connection;

    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Cliente> listar() {
        try{
            String sql = "select nome, idade from CLIENTE";
            List<Cliente> clientes = new ArrayList<>();

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();

                try(ResultSet r = preparedStatement.getResultSet()){
                    while(r.next()){
                        Cliente cliente = new Cliente(r.getString(1),r.getInt(2));
                        clientes.add(cliente);
                    }
                }
            }
            return clientes;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criar(Object cliente) {
        try{
            Cliente novoCLiente = (Cliente) cliente;
            String sql = "insert into cliente (nome, idade) values(?,?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, novoCLiente.getNome());
                preparedStatement.setInt(2, novoCLiente.getIdade());
                preparedStatement.execute();

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Object classe) {

        try{
            Cliente cliente = (Cliente) classe;
            String sql = "update cliente set nome=?, idade=? where id=?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setInt(2, cliente.getIdade());
                preparedStatement.setInt(3, cliente.getId());
                preparedStatement.execute();
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id) {
        try{
            String sql = "delete from cliente where id = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
