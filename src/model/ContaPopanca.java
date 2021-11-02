package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class ContaPopanca extends ContaBancaria{

    public ContaPopanca(String agencia, String conta, Integer digito, Double saldoInicial) {
        super(agencia, conta, digito, saldoInicial);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void imprimirExtrato() {
        
        System.out.println("*******************************************************");
        System.out.println("******************* Extrato Poupança ******************");
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
