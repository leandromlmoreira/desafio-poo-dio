import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.Workshop;
import br.com.dio.desafio.dominio.Avaliacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Workshop workshop = new Workshop();
        workshop.setTitulo("workshop de spring boot");
        workshop.setDescricao("descrição workshop spring boot");
        workshop.setDataHora(LocalDateTime.now().plusDays(7));
        workshop.setDuracaoMinutos(120);
        workshop.setFacilitador("João Silva");

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(workshop);

        System.out.println("\n" + "=".repeat(60));
        System.out.println(">>> BOOTCAMP: " + bootcamp.getNome().toUpperCase());
        System.out.println("=".repeat(60));
        System.out.println(">>> DESCRIÇÃO: " + bootcamp.getDescricao());
        System.out.println(">>> DATA INICIAL: " + bootcamp.getDataInicial());
        System.out.println(">>> DATA FINAL: " + bootcamp.getDataFinal());
        System.out.println(">>> TOTAL DE CONTEÚDOS: " + bootcamp.getConteudos().size());
        
        System.out.println("\n>>> CONTEÚDOS DISPONÍVEIS:");
        bootcamp.getConteudos().forEach(conteudo -> {
            if (conteudo instanceof Curso) {
                Curso cursoItem = (Curso) conteudo;
                System.out.println("  [CURSO] " + cursoItem.getTitulo() + " (" + cursoItem.getCargaHoraria() + "h)");
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoriaItem = (Mentoria) conteudo;
                System.out.println("  [MENTORIA] " + mentoriaItem.getTitulo() + " - " + mentoriaItem.getData());
            } else if (conteudo instanceof Workshop) {
                Workshop workshopItem = (Workshop) conteudo;
                System.out.println("  [WORKSHOP] " + workshopItem.getTitulo() + " - " + workshopItem.getFacilitador() + " (" + workshopItem.getDuracaoMinutos() + "min)");
            }
        });

        System.out.println("\n" + "=".repeat(60));
        System.out.println(">>> DEV: CAMILA");
        System.out.println("=".repeat(60));
        
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        
        System.out.println(">>> CONTEÚDOS INSCRITOS:");
        devCamila.getConteudosInscritos().forEach(conteudo -> 
            System.out.println("  * " + conteudo.getTitulo() + " - " + conteudo.getDescricao()));
        
        System.out.println("\n>>> PROGREDINDO...");
        devCamila.progredir();
        devCamila.progredir();
        
        System.out.println("\n>>> CONTEÚDOS CONCLUÍDOS:");
        devCamila.getConteudosConcluidos().forEach(conteudo -> 
            System.out.println("  [OK] " + conteudo.getTitulo() + " - XP: " + conteudo.calcularXp()));
        
        System.out.println("\n>>> CONTEÚDOS AINDA INSCRITOS:");
        devCamila.getConteudosInscritos().forEach(conteudo -> 
            System.out.println("  [PENDENTE] " + conteudo.getTitulo()));
        
        System.out.println("\n>>> AVALIAÇÕES:");
        devCamila.avaliarConteudo(curso1, 9.5, "Excelente curso!");
        devCamila.avaliarConteudo(curso2, 8.0, "Muito bom conteúdo");
        
        devCamila.getAvaliacoes().forEach(avaliacao -> 
            System.out.println("  [NOTA " + avaliacao.getNota() + "] " + avaliacao.getConteudo().getTitulo() + 
                             " - Comentário: " + avaliacao.getComentario()));
        
        System.out.println("\n>>> RESUMO:");
        System.out.println("  XP Base: " + devCamila.getConteudosConcluidos().stream()
                .mapToDouble(conteudo -> conteudo.calcularXp()).sum());
        System.out.println("  XP Bônus (Avaliações): " + devCamila.getAvaliacoes().stream()
                .mapToDouble(Avaliacao::calcularXpBonus).sum());
        System.out.println("  XP Total: " + devCamila.calcularTotalXp());
        System.out.println("  Média das Avaliações: " + String.format("%.2f", devCamila.getMediaAvaliacoes()));

        System.out.println("\n" + "=".repeat(60));
        System.out.println(">>> DEV: JOÃO");
        System.out.println("=".repeat(60));
        
        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        
        System.out.println(">>> CONTEÚDOS INSCRITOS:");
        devJoao.getConteudosInscritos().forEach(conteudo -> 
            System.out.println("  * " + conteudo.getTitulo() + " - " + conteudo.getDescricao()));
        
        System.out.println("\n>>> PROGREDINDO...");
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        
        System.out.println("\n>>> CONTEÚDOS CONCLUÍDOS:");
        devJoao.getConteudosConcluidos().forEach(conteudo -> 
            System.out.println("  [OK] " + conteudo.getTitulo() + " - XP: " + conteudo.calcularXp()));
        
        System.out.println("\n>>> CONTEÚDOS AINDA INSCRITOS:");
        devJoao.getConteudosInscritos().forEach(conteudo -> 
            System.out.println("  [PENDENTE] " + conteudo.getTitulo()));
        
        System.out.println("\n>>> AVALIAÇÕES:");
        devJoao.avaliarConteudo(curso1, 7.5, "Bom curso");
        devJoao.avaliarConteudo(mentoria, 9.0, "Mentoria muito útil");
        
        devJoao.getAvaliacoes().forEach(avaliacao -> 
            System.out.println("  [NOTA " + avaliacao.getNota() + "] " + avaliacao.getConteudo().getTitulo() + 
                             " - Comentário: " + avaliacao.getComentario()));
        
        System.out.println("\n>>> RESUMO:");
        System.out.println("  XP Base: " + devJoao.getConteudosConcluidos().stream()
                .mapToDouble(conteudo -> conteudo.calcularXp()).sum());
        System.out.println("  XP Bônus (Avaliações): " + devJoao.getAvaliacoes().stream()
                .mapToDouble(Avaliacao::calcularXpBonus).sum());
        System.out.println("  XP Total: " + devJoao.calcularTotalXp());
        System.out.println("  Média das Avaliações: " + String.format("%.2f", devJoao.getMediaAvaliacoes()));

    }

}
