package main.java.br.com.gerenciadorContas.view;

import br.com.gerenciaContas.DAO.DAO;
import br.com.gerenciaContas.controller.ClienteController;
import br.com.gerenciaContas.controller.ContaController;
import br.com.gerenciaContas.modelo.Cliente;
import br.com.gerenciaContas.modelo.Conta;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class PainelGerenciadorDeContasView {
    private Scanner scanner = new Scanner(System.in);

    private ContaController contaController;
    private ClienteController clienteController;

    public PainelGerenciadorDeContasView(){
        contaController = new ContaController();
        clienteController = new ClienteController();

        int opcaoMenuPrincipal = 0;
        do {
            opcaoMenuPrincipal = menuPrincipal();

            int opcaoCrud = opcaoCrud();

            if (opcaoMenuPrincipal == 1) executaOpcaoCrud(opcaoCrud, clienteController, opcaoMenuPrincipal);
            else executaOpcaoCrud(opcaoCrud, (DAO) contaController, opcaoMenuPrincipal);

        }while(opcaoMenuPrincipal!=0);

    }

    private void executaOpcaoCrud(int opcao, DAO controller, int opcaoMenuPrincipal){

        switch (opcao){

            case 1: {
                System.out.println("criar");
                if(opcaoMenuPrincipal == 1){
                    controller.criar(criaCliente());
                }else{
                    controller.criar(criaConta());
                }
                break;
            }
            case 2:{
                List lista = controller.listar();

                lista.stream().forEach(l -> System.out.println(l));
                break;
            }
            case 3:{

                if(listaVazia(controller)) {
                    System.out.println("Lista vazia");
                    break;
                }
                listar(controller);

                System.out.println("Informe o id: ");
                controller.alterar(Integer.parseInt(scanner.next()));
                break;
            }
            case 4:{
                if(listaVazia(controller)) {
                    System.out.println("Lista vazia");
                    break;
                }
                listar(controller);

                System.out.println("Informe o id: ");
                controller.deletar(Integer.parseInt(scanner.next()));
                break;
            }
            default:{
                System.out.println("Opcao inválida");
                break;
            }
        }
    }

    private String coletaString(String pergunta){
        System.out.println(pergunta);
        return scanner.next();
    }

    private int coletaInt(){
        return Integer.parseInt(scanner.next());
    }

    private void listar(DAO controller){
        controller.listar();
    }

    private Conta criaConta(){
        coletaString("Informe a agencia: ");
        int agencia = coletaInt();

        coletaString("Informe a conta: ");
        int conta = coletaInt();

        return new Conta(agencia, conta, new BigDecimal("0"));
    }

    private Cliente criaCliente(){
        String nome = coletaString("Informe o nome: ");

        coletaString("Informe a idade");
        int idade = coletaInt();

        return new Cliente(nome, idade);
    }

    private boolean listaVazia(DAO controller){
        return controller.listar().isEmpty();
    }

    private int opcaoCrud(){
        StringBuilder frase = new StringBuilder();
        frase.append("\nMenu Crud\n");
        frase.append("Informe o numero da sua opção:\n");
        frase.append("1-Criar\n");
        frase.append("2-Listar\n");
        frase.append("3-Atualizar\n");
        frase.append("4-Deletar\n");

        System.out.println(frase.toString());

        return Integer.parseInt(scanner.next());
    }

    private int menuPrincipal(){
        StringBuilder frase = new StringBuilder();
        frase.append("Menu principal\n\n");
        frase.append("Informe o número da sua opção:\n");
        frase.append("0-Sair\n");
        frase.append("1-Clientes\n");
        frase.append("2-Contas\n");

        System.out.println(frase.toString());

        return Integer.parseInt(scanner.next());
    }

}
