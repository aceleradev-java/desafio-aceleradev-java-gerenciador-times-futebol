package br.com.codenation.comparator;

import br.com.codenation.model.Jogador;
import java.util.Comparator;

public class JogadorMaiorSalarioComparator implements Comparator<Jogador>{

    @Override
    public int compare(Jogador jogador1, Jogador jogador2) {
        int comparadorDeSalario = jogador1.getSalario().compareTo(jogador2.getSalario());
        if (comparadorDeSalario > 0) {
            return -1;
        } else if (comparadorDeSalario < 0) {
            return 1;
        } else if (jogador1.getId() > jogador2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

}
