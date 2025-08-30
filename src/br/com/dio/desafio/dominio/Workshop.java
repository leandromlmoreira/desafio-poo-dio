package br.com.dio.desafio.dominio;

import java.time.LocalDateTime;

public class Workshop extends Conteudo {

    private LocalDateTime dataHora;
    private int duracaoMinutos;
    private String facilitador;

    @Override
    public double calcularXp() {
        return XP_PADRAO + (duracaoMinutos / 10.0);
    }

    public Workshop() {
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dataHora=" + dataHora +
                ", duracaoMinutos=" + duracaoMinutos +
                ", facilitador='" + facilitador + '\'' +
                '}';
    }
}
