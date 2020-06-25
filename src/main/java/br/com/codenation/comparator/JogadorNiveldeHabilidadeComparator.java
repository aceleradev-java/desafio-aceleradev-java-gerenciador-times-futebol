package br.com.codenation.comparator;

import br.com.codenation.model.Jogador;
import java.util.Comparator;

public class JogadorNiveldeHabilidadeComparator implements Comparator<Jogador>{

    @Override
    public int compare(Jogador jogador1, Jogador jogador2) {
        return jogador2.getNivelHabilidade() - jogador1.getNivelHabilidade();
    }
    
}
