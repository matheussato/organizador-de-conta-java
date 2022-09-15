package br.com.fiap;

import java.util.Comparator;

public class OrdenarPorCategoria implements Comparator<Conta>{

    @Override
    public int compare(Conta o1, Conta o2) {
        return o1.getCategoria().compareTo(o2.getCategoria());
    }

}
    

