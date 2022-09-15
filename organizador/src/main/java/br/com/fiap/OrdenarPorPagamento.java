package br.com.fiap;

import java.util.Comparator;

public class OrdenarPorPagamento implements Comparator<Conta>{

    

    public int compare(Conta o1, Conta o2){
        return o1.getPagamento().compareTo(o2.getPagamento());
    }
 

}
