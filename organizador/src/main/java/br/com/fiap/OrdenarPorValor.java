package br.com.fiap;

import java.util.Comparator;


public class OrdenarPorValor implements Comparator<Conta> {

    @Override
    public int compare(Conta o1, Conta o2) {
        return Double.compare(o1.getValor(), o2.getValor());
    }
    
}
