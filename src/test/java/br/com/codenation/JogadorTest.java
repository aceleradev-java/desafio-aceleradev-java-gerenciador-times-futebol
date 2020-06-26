package br.com.codenation;

import br.com.codenation.comparator.JogadorMaiorSalarioComparator;
import br.com.codenation.comparator.JogadorMaisVelhoComparator;
import br.com.codenation.comparator.JogadorNiveldeHabilidadeComparator;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import br.com.codenation.model.Jogador;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import org.junit.Test;

public class JogadorTest {
    
    public static String NOME1 = "Jogador1";
    public static String NOME2 = "Jogador2";
    public static String NOME3 = "Jogador3";

    @Test
    public void deveOrdenarOsJogadoresDeFormaNatural() {
        Jogador jogador1 = new Jogador(1l, 1l, NOME1, LocalDate.now(), 1, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 1, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador2);
        jogadores.add(jogador1);
        assertEquals(NOME1, jogadores.get(1).getNome());
        assertEquals(NOME2, jogadores.get(0).getNome());
    }

    @Test
    public void deveOrdenarOsJogadoresPorId() {
        Jogador jogador1 = new Jogador(1l, 1l, NOME1, LocalDate.now(), 1, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 1, BigDecimal.TEN);
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now(), 1, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador2);
        jogadores.add(jogador1);
        jogadores.add(jogador3);

        Collections.sort(jogadores);
        assertEquals(1l, jogadores.get(0).getId().longValue());
    }

    @Test
    public void deveOrdenarOsJogadoresPorNivelDeHabilidade() {
        Jogador jogador1 = new Jogador(1l, 1l, NOME1, LocalDate.now(), 5, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 4, BigDecimal.TEN);
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now(), 3, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador2);
        jogadores.add(jogador1);
        jogadores.add(jogador3);

        Collections.sort(jogadores, new JogadorNiveldeHabilidadeComparator());
        assertEquals(1l, jogadores.get(0).getId().longValue());
        assertEquals(3l, jogadores.get(2).getId().longValue());
    }

    @Test
    public void deveOrdenarOsJogadoresPorNivelDeHabilidadeEmpatados() {
        Jogador jogador1 = new Jogador(5l, 1l, NOME1, LocalDate.now(), 5, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 5, BigDecimal.TEN);
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now(), 5, BigDecimal.TEN);
        Jogador j4 = new Jogador(1l, 1l, "Jogador4", LocalDate.now(), 5, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador2);
        jogadores.add(jogador1);
        jogadores.add(jogador3);
        jogadores.add(j4);

        assertEquals(2l, jogadores.get(0).getId().longValue());
        assertEquals(5l, jogadores.get(1).getId().longValue());
        assertEquals(3l, jogadores.get(2).getId().longValue());
        Collections.sort(jogadores, new JogadorNiveldeHabilidadeComparator());
        assertEquals(1l, jogadores.get(0).getId().longValue());
    }

    @Test
    public void deveOrdenarPeloJogadorMaisVelho() {
        Jogador jogador1 = new Jogador(5l, 1l, NOME1, LocalDate.now().minus(2, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now().minus(3, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now().minus(10, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador2);
        jogadores.add(jogador1);
        jogadores.add(jogador3);

        Collections.sort(jogadores, new JogadorMaisVelhoComparator());
        assertEquals(3l, jogadores.get(0).getId().longValue());
    }

    @Test
    public void deveOrdenarPeloIdQuandoJogadorMaisVelhoEstaComEmpateDeIdade() {
        Jogador jogador1 = new Jogador(5l, 1l, NOME1, LocalDate.now().minus(2, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now().minus(10, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now().minus(10, ChronoUnit.YEARS), 5, BigDecimal.TEN);
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador3);
        jogadores.add(jogador2);

        Collections.sort(jogadores, new JogadorMaisVelhoComparator());
        assertEquals(2l, jogadores.get(0).getId().longValue());
    }
    
    @Test
    public void deveOrdenarOsJogadoresPorSalarioDecrescente() {
        Jogador jogador1 = new Jogador(1l, 1l, NOME1, LocalDate.now(), 1, new BigDecimal(1000));
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 1, new BigDecimal(3000));
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now(), 1, new BigDecimal(2000));
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);

        Collections.sort(jogadores, new JogadorMaiorSalarioComparator());
        assertEquals(2l, jogadores.get(0).getId().longValue());
    }
    
    @Test
    public void deveOrdenarOsJogadoresPorCrescenteQuandoSalarioEmpatado() {
        Jogador jogador1 = new Jogador(1l, 1l, NOME1, LocalDate.now(), 1, new BigDecimal(3000));
        Jogador jogador2 = new Jogador(2l, 1l, NOME2, LocalDate.now(), 1, new BigDecimal(1000));
        Jogador jogador3 = new Jogador(3l, 1l, NOME3, LocalDate.now(), 1, new BigDecimal(3000));
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        jogadores.add(jogador3);

        Collections.sort(jogadores, new JogadorMaiorSalarioComparator());
        assertEquals(1l, jogadores.get(0).getId().longValue());
    }
}
