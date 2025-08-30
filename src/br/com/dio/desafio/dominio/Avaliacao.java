package br.com.dio.desafio.dominio;

import java.time.LocalDateTime;

public class Avaliacao {
    private Dev dev;
    private Conteudo conteudo;
    private double nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;

    public Avaliacao(Dev dev, Conteudo conteudo, double nota, String comentario) {
        this.dev = dev;
        this.conteudo = conteudo;
        this.nota = nota;
        this.comentario = comentario;
        this.dataAvaliacao = LocalDateTime.now();
    }

    public double calcularXpBonus() {
        if (nota >= 9.0) {
            return 50.0;
        } else if (nota >= 7.0) {
            return 25.0;
        } else if (nota >= 5.0) {
            return 10.0;
        }
        return 0.0;
    }

    public Dev getDev() {
        return dev;
    }

    public void setDev(Dev dev) {
        this.dev = dev;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "dev=" + dev.getNome() +
                ", conteudo=" + conteudo.getTitulo() +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
