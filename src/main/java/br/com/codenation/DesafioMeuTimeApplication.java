package br.com.codenation;

import br.com.codenation.model.TimeDeFutebol;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<TimeDeFutebol> listaDeTimes = new ArrayList<>();

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        TimeDeFutebol time = new TimeDeFutebol(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        listaDeTimes.add(time);
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        throw new UnsupportedOperationException();
    }

    public void definirCapitao(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    public String buscarNomeJogador(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    public String buscarNomeTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        throw new UnsupportedOperationException();
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
