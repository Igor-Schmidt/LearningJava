import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class TesteMain {
    Profissional p1 = new Profissional("ENG01", "444.444.444-44", "Outro João");

    @Test
    public void PROF_001() {
        p1.setCpf("12345678900");
        p1.setNome("João Silva");

        Assertions.assertEquals("12345678900", p1.getCpf());
        Assertions.assertEquals("João Silva", p1.getNome());
    }

    @Test
    public void PROF_002() {
        p1.setCpf(null);
        p1.setNome("");

        Assertions.assertNull(p1.getCpf());
        Assertions.assertEquals("", p1.getNome());
    }

    @Test
    public void PROF_003() {
        Construtech sistema = new Construtech();

        ProjetoPublico projPub1 = new ProjetoPublico(
                "PUB001",
                "Construção da Ponte Central",
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 3, 1),
                LocalDate.of(2024, 8, 31)
        );

        sistema.cadastrarProjeto(projPub1);
        Assertions.assertEquals(1, sistema.getProjetos().size());
    }

    @Test
    public void PPUB_001() {
        ProjetoPublico projPub1 = new ProjetoPublico(
                "PUB001",
                "Construção da Ponte Central",
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 3, 1),
                LocalDate.of(2024, 8, 31)
        );
        projPub1.setId("101");

        projPub1.setDataInicio(LocalDate.of(2023, 01, 01));
        projPub1.setDataFim(LocalDate.of(2023, 01, 31));

        Assertions.assertEquals(30, projPub1.getDuracaoEmDias());
        Assertions.assertEquals("Projeto Público 101: Construção da Ponte Central (Duração: 30 dias)", projPub1.getResumo());
    }

    @Test
    public void PPUB_002() {
//        Adicionar Responsável Duplicado (Exceção)
//        Projeto Público P (nº 102). Profissional prof1 (CPF: '111'). Chamar P.adicionarResponsavel(prof1) duas vezes.
//        A segunda chamada deve lançar IllegalArgumentException com a mensagem: 'Profissional já registrado para o projeto: 102'.

        ProjetoPublico projPub1 = new ProjetoPublico(
                "PUB001",
                "Construção da Ponte Central",
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 3, 1),
                LocalDate.of(2024, 8, 31)
        );
        projPub1.setId("102");

        Profissional prof1 = new Profissional("001", "111", "Nome01");
        projPub1.adicionarResponsavel(prof1);

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> projPub1.adicionarResponsavel(prof1)
        );
    }

    @Test
    public void PPRIV_001() {
//        Criação Válida e Resumo
//        Criar Projeto Privado P: setNumero(201), setTipoArea(RESIDENCIAL), setMetragem(150.5).
//        P.getMetragem() deve retornar 150.5. P.getResumo() deve conter 'RESIDENCIAL' e '150.5 m²'.

        EmpreendimentoPrivado projPrivado = new EmpreendimentoPrivado(
                "EMP001",
                "Condomínio Residencial Flores",
                LocalDate.of(2023, 2, 20),
                TipoArea.URBANA,
                15000.0
        );

        projPrivado.setId("201");
        projPrivado.setTipoArea(TipoArea.RESIDENCIAL);
        projPrivado.setMetragem(150.5);

        Assertions.assertEquals(150.5, projPrivado.getMetragem());
        Assertions.assertEquals("Empreendimento Privado: Localização: RESIDENCIAL, Tamanho: 150,50 m²", projPrivado.getResumo());
    }

    @Test
    public void PPRIV_002() {
//        Metragem Inválida
//        Criar Projeto Privado P: setMetragem(-10.0).
//        P.getMetragem() deve retornar -10.0 (Confirma a ausência de validação para metragem negativa).


        EmpreendimentoPrivado projPrivado = new EmpreendimentoPrivado(
                "EMP001",
                "Condomínio Residencial Flores",
                LocalDate.of(2023, 2, 20),
                TipoArea.URBANA,
                15000.0
        );

        projPrivado.setMetragem(-10.0);

        Assertions.assertEquals(-10.0, projPrivado.getMetragem());
    }
}
