package main.java.br.com.gerenciadorContas.modelo;

public class Cliente {
    private int id;
    private String nome;
    private int idade;

    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente(int id, String nome, int idade){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
