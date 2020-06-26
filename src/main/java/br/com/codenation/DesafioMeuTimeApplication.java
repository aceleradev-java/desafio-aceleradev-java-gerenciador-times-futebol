package br.com.codenation;

import br.com.codenation.comparator.JogadorMaisVelhoComparator;
import br.com.codenation.comparator.JogadorNiveldeHabilidadeComparator;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.TimeDeFutebol;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<TimeDeFutebol> listaDeTimes = new ArrayList<>();
    private List<Jogador> listaDeJogadores = new ArrayList<>();
    private TimeDeFutebol time = new TimeDeFutebol();
    private Jogador jogador = new Jogador();

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        TimeDeFutebol time = new TimeDeFutebol(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        listaDeTimes.add(time);
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        listaDeJogadores.add(jogador);
    }

    public void definirCapitao(Long idJogador) {
        jogador = null;
        jogador = buscarJogadorPorId(idJogador);
        time = buscarTimePorId(jogador.getIdTime());
        time.setIdDoJogadorCapitao(idJogador);
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        time = buscarTimePorId(idTime);
        return time.getIdDoJogadorCapitao();
    }
    
    public TimeDeFutebol buscarTimePorId(Long id) {
        time = null;
        for (TimeDeFutebol t : listaDeTimes) {
            if (t.getId().equals(id)) {
                time = t;
            }
        }
        return time;
    }

    
    public Jogador buscarJogadorPorId(Long idDoJogador) {
        jogador = new Jogador();
        jogador.setId(idDoJogador);
        int posicao;
        for (Jogador j : listaDeJogadores) {
            if (j.getId().equals(idDoJogador)) {
                jogador = j;
            }
        }
        return jogador;        
    }
    
    public String buscarNomeJogador(Long idJogador) {
        jogador = buscarJogadorPorId(idJogador);
        return jogador.getNome();
    }

    public String buscarNomeTime(Long idTime) {
        time = null;
        time = buscarTimePorId(idTime);
        return time.getNome();
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        List<Long> jogadores = new ArrayList<>();
        for (Jogador jogador : listaDeJogadores) {
            if (jogador.getIdTime().equals(idTime)) {
                jogadores.add(jogador.getId());
            }
        }
        return jogadores;
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        List<Jogador> jogadoresDoTime = new ArrayList<>();
        for (Long idDoJogador : buscarJogadoresDoTime(idTime)) {
            jogadoresDoTime.add(buscarJogadorPorId(idDoJogador));
        }
        Collections.sort(jogadoresDoTime, new JogadorNiveldeHabilidadeComparator());
        Long idDoMelhorJogador = jogadoresDoTime.get(0).getId();
        return idDoMelhorJogador;
    }
    
    public Long buscarJogadorMaisVelho(Long idTime) {
        List<Jogador> jogadoresDoTime = new ArrayList<>();
        for (Long idDoJogador : buscarJogadoresDoTime(idTime)) {
            jogadoresDoTime.add(buscarJogadorPorId(idDoJogador));
        }
        Collections.sort(jogadoresDoTime, new JogadorMaisVelhoComparator());
        Long idDoJogadorMaisVelho = jogadoresDoTime.get(0).getId();
        return idDoJogadorMaisVelho;
    }

    public List<Long> buscarTimes() {
        List<Long> idDosTimes = new ArrayList<>();
        for (TimeDeFutebol time : listaDeTimes) {
            idDosTimes.add(time.getId());
        }
        return idDosTimes;
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        throw new UnsupportedOperationException();
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    public List<Long> buscarTopJogadores(Integer top) {
        throw new UnsupportedOperationException();
    }
    
}
