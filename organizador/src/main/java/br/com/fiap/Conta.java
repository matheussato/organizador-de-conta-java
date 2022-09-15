package br.com.fiap;

import java.time.LocalDate;

public class Conta implements Comparable<Conta> {

    private String nome;
    private double valor;
    private String categoria;
    private String pagamento;
    private LocalDate dataDeVencimento;
    
    

    
    public Conta(String nome, double valor, String categoria, String pagamento,
            LocalDate dataDeVencimento) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.pagamento = pagamento;
        this.dataDeVencimento = dataDeVencimento;
    }

    

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public double getValor() {
        return valor;
    }



    public void setValor(double valor) {
        this.valor = valor;
    }



    public String getCategoria() {
        return categoria;
    }



    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPagamento() {
        return pagamento;
    }



    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }



    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }



    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }



    @Override
    public String toString() {
        return "Nome da conta: " + nome + " -- " + " Valor da conta: " + valor + " -- " + " Data de Vencimento " + "(" + dataDeVencimento + ") " + " -- " + " Categoria: " + categoria + " -- " + " Foi paga?: " + pagamento;
    }

    @Override
    public int compareTo(Conta outro) {
        return Double.compare(this.valor, outro.getValor());
    }

    
}
