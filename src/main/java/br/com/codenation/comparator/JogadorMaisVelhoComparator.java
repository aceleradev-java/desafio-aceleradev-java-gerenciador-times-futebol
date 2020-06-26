package br.com.codenation.comparator;

import br.com.codenation.model.Jogador;
import java.util.Comparator;

public class JogadorMaisVelhoComparator implements Comparator<Jogador>{

    @Override
    public int compare(Jogador jogador1, Jogador jogador2) {
        int comparadorDeIdade = jogador1.getDataNascimento().compareTo(jogador2.getDataNascimento());
        if (comparadorDeIdade > 0) {
            return 1;
        } else if (comparadorDeIdade < 0) {
            return -1;
        } else if (jogador1.getId() > jogador2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

}
