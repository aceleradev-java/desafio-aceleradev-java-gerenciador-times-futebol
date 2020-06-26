package br.com.codenation.comparator;

import br.com.codenation.model.Jogador;
import java.util.Comparator;

public class JogadorNiveldeHabilidadeComparator implements Comparator<Jogador>{

    @Override
    public int compare(Jogador jogador1, Jogador jogador2) {
//        return jogador2.getNivelHabilidade() - jogador1.getNivelHabilidade();
        if (jogador1.getNivelHabilidade() > jogador2.getNivelHabilidade()) {
            return -1;
        } else if (jogador1.getNivelHabilidade() < jogador2.getNivelHabilidade()) {
            return 1;
        } else if (jogador1.getId() > jogador2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
