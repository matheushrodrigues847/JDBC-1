package main.java.br.com.gerenciadorContas.DAO;

import br.com.gerenciaContas.modelo.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO implements DAO{
    private Connection connection;

    public ContaDAO(Connection connection){
        this.connection = connection;
    }

    public List<Conta> listar(){
        try{
            String sql = "select co.agencia, co.conta, co.saldo,cl.nome from CONTA co INNER JOIN CLIENTE cl" +
                    "ON co.id_cliente = cl.id";
            List<Conta> contas = new ArrayList<>();

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.execute();

                try(ResultSet resultSet = preparedStatement.getResultSet()){
                    while(resultSet.next()){
                        Conta conta =
                                new Conta(resultSet.getInt(1),
                                        resultSet.getInt(2),
                                        resultSet.getBigDecimal(3));
                        contas.add(conta);
                    }
                }
            }
            return contas;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void criar(Object conta) {

    }

    @Override
    public void alterar(Object id) {

    }

    @Override
    public void deletar(int id) {

    }
}
