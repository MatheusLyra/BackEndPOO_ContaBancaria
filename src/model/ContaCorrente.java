package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String agencia, String conta, Integer digito, Double saldoInicial) {
        //cria um construtor pq o pai tem construtor e passa os dados necessários.
        super(agencia, conta, digito, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("*******************************************************");
        System.out.println("******************* Extrato Bancário ******************");
        System.out.println("*******************************************************");
        System.out.println();
        System.out.println("Gerado em: "+ DataUtil.converterDateParaDataHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes) {
            System.out.println(movimentacao);
        }
 
        System.out.println();
  
    }
    
}
