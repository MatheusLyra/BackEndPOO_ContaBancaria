package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {
   
    //#region Atributos
    protected String agencia;
    protected String conta;
    protected Integer digito;
    protected Double saldo;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes;

    //Constante
    protected Double VALOR_MINIMO_DEPOSITO = 10.0;
    //#endregion

    //#region Construtor
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        //se não instanciar vai dar uma exception de "nullPointerException"
        this.movimentacoes = new ArrayList<Movimentacao>();

        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

        //Iniciando o extrato bancário
        this.movimentacoes.add(movimentacao);
    }
    //#endregion

    //#region Getters e Setters

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }
    //#endregion

    //#region Métodos
    public void depositar(Double valor){

      //this.saldo = this.saldo + valor;

      if (valor < VALOR_MINIMO_DEPOSITO) {
        throw new InputMismatchException("O valor minímo de depósito é R$ " + VALOR_MINIMO_DEPOSITO);
      }

      this.saldo += valor;

      Movimentacao movimentacao = new Movimentacao("Depósito", valor);
      movimentacoes.add(movimentacao);
    }

    public Double sacar(Double valor){
 
        if (valor > this.saldo) {
            throw new InputMismatchException("O saldo é insuficiente.");
          }
        
        //this.saldo = this.saldo - valor;
        this.saldo -= valor;         

        Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
        movimentacoes.add(movimentacao);

        return valor;
      } 
      
    public void transferir(Double valor, ContaBancaria contaDestino){

        this.sacar(valor);

        contaDestino.depositar(valor);
    }  

    //Metodo abstrato obriga os filhos que herdam a classe a implementar, abstract na classe só não deixa instanciar diretamente a classe.
    public abstract void imprimirExtrato();
    //#endregion


    
}
