package main.java.br.com.gerenciadorContas.Exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(){
        super("Essa conta não tem saldo suficiente para essa operação");
    }
}
