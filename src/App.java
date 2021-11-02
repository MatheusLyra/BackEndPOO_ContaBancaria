package src;

import src.model.ContaCorrente;
import src.model.ContaPopanca;
import src.utils.DataUtil;

public class App {

    public static void main(String[] args) {
        System.out.println("Criando nosso banco digital");
        System.out.println();

        ContaCorrente conta = new ContaCorrente("0001", "1345", 3, 100.00);
        System.out.println("Saldo atual de R$"+conta.getSaldo());
        System.out.println();

        conta.depositar(250.0);
        System.out.println("Saldo atual de R$"+conta.getSaldo());
        System.out.println();

        var saque = conta.sacar(150.0);
        System.out.println("Saldo atual de R$"+conta.getSaldo());
        System.out.println();  
        
        ContaPopanca conta2 = new ContaPopanca("0001", "4444", 5, 200.00);
        conta2.transferir(100.0, conta);

        System.out.println("Saldo conta de destino R$"+conta.getSaldo());
        System.out.println();     
        
        System.out.println("Saldo conta origem R$"+conta2.getSaldo());
        System.out.println(); 
        
        //Conversão de datas - Static e abstract
        //System.out.println(conta2.getDataAbertura());
        var f1 =  DataUtil.converterDateParaDataHora(conta2.getDataAbertura());
        var f2 =  DataUtil.converterDateParaData(conta2.getDataAbertura());
        var f3 =  DataUtil.converterDateParaHora(conta2.getDataAbertura());
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        //Extrato - override, polimorfismo e encapsulamento
        // Movimentacao movimentacao = new Movimentacao("Saque", 100.0);
        // System.out.println("------------------------");
        // System.out.println("Extrato");
        // System.out.println(movimentacao.toString());
        // System.out.println(movimentacao); //movimentacao é o mesmo que movimentacao.toString
        
        //Extrato - Collections
        conta.imprimirExtrato();
        conta2.imprimirExtrato();

    }
    

 /**
  * atalho ctrl + '.' = para inserir os imports automaticamente, ou resolver um problema   

  comando escrito no terminal: cls - limpa os resultados
  */   
}
