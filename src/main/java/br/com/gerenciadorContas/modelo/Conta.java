package main.java.br.com.gerenciadorContas.modelo;

import br.com.gerenciaContas.Exception.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta{
    private int agencia;
    private int numeroDaConta;
    private BigDecimal saldo;

    public Conta(int agencia, int numeroDaConta, BigDecimal saldo){
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroDaConta(){
        return numeroDaConta;
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    public void saca(BigDecimal valor){

        if(valor.compareTo(this.saldo) > 0){
            throw new SaldoInsuficienteException();
        }
        this.saldo = this.saldo.subtract(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia && numeroDaConta == conta.numeroDaConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numeroDaConta);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numeroDaConta=" + numeroDaConta +
                ", saldo=" + saldo +
                '}';
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(new BigDecimal("0")) < 0){
            throw new ArithmeticException("Valor deve ser maior que zero");
        }
        this.saldo = this.saldo.add(valor);
    }

    public void transfere(Conta conta1, BigDecimal valor) {
        this.saca(valor);
        conta1.depositar(valor);
    }
}
