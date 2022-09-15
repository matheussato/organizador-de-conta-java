package br.com.fiap;

import java.util.Comparator;

public class OrdenarPorDataDeVencimento implements Comparator<Conta> {
    
    public int compare(Conta o1, Conta o2){
        return o1.getDataDeVencimento().compareTo(o2.getDataDeVencimento());
    }
 
    
}
