// Aluno: Igor Zafriel Schmidt

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Construtech sistema = new Construtech();

        System.out.println();
        System.out.println(" 1: CADASTRO DE PROFISSIONAIS ");
        cadastrarProfissionais(sistema);
        System.out.println("\n 2: TENTATIVA DE CADASTRO DUPLICADO (VALIDAÇÃO) ");
        tentarCadastroDuplicado(sistema);
        System.out.println("\n 3: CADASTRO DE PROJETOS ");
        cadastrarProjetos(sistema);
        System.out.println("\n 4: EMISSÃO DE RELATÓRIOS ");
        emitirRelatorios(sistema);
    }

    private static void cadastrarProfissionais(Construtech sistema) {
        sistema.cadastrarProfissional(new Profissional("ENG01", "111.111.111-11", "João Silva"));
        sistema.cadastrarProfissional(new Profissional("ARQ01", "222.222.222-22", "Maria Souza"));
        sistema.cadastrarProfissional(new Profissional("ENG02", "333.333.333-33", "Carlos Pereira"));
    }

    private static void tentarCadastroDuplicado(Construtech sistema) {
        // Tentando cadastrar com mesmo ID
        sistema.cadastrarProfissional(new Profissional("ENG01", "444.444.444-44", "Outro João"));
        // Tentando cadastrar com mesmo CPF
        sistema.cadastrarProfissional(new Profissional("ARQ02", "222.222.222-22", "Outra Maria"));
    }

    private static void cadastrarProjetos(Construtech sistema) {
        Optional<Profissional> joao = sistema.getProfissionais().stream().filter(p -> p.getId().equals("ENG01")).findFirst();
        Optional<Profissional> maria = sistema.getProfissionais().stream().filter(p -> p.getId().equals("ARQ01")).findFirst();
        Optional<Profissional> carlos = sistema.getProfissionais().stream().filter(p -> p.getId().equals("ENG02")).findFirst();

        // Projeto Público 1
        ProjetoPublico projPub1 = new ProjetoPublico("PUB001", "Construção da Ponte Central", LocalDate.of(2023, 1, 15), LocalDate.of(2023, 3, 1), LocalDate.of(2024, 8, 31));
        joao.ifPresent(projPub1::adicionarResponsavel);
        carlos.ifPresent(projPub1::adicionarResponsavel);
        sistema.cadastrarProjeto(projPub1);

        // Empreendimento Privado 1
        EmpreendimentoPrivado empPriv1 = new EmpreendimentoPrivado("PRIV001", "Condomínio Residencial Flores", LocalDate.of(2023, 2, 20), TipoArea.URBANA, 15000.0);
        maria.ifPresent(empPriv1::adicionarResponsavel);
        sistema.cadastrarProjeto(empPriv1);

        // Projeto Público 2
        ProjetoPublico projPub2 = new ProjetoPublico("PUB002", "Reforma do Hospital Municipal", LocalDate.of(2023, 5, 10), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 12, 20));
        carlos.ifPresent(projPub2::adicionarResponsavel);
        sistema.cadastrarProjeto(projPub2);
    }

    private static void emitirRelatorios(Construtech sistema) {
        // 1. Relatório Completo
        sistema.emitirRelatorio(new RelatorioCompleto());

        // 2. Relatório por Tipo (Públicos)
        sistema.emitirRelatorio(new RelatorioPorTipo(ProjetoPublico.class));

        // 3. Relatório por Tipo (Privados)
        sistema.emitirRelatorio(new RelatorioPorTipo(EmpreendimentoPrivado.class));

        // 4. Relatório por Profissional (Carlos)
        sistema.emitirRelatorio(new RelatorioPorProfissional("ENG02"));

        // 5. Relatório por Profissional (Maria)
        sistema.emitirRelatorio(new RelatorioPorProfissional("ARQ01"));

        // 6. Relatório por Profissional (Inexistente)
        sistema.emitirRelatorio(new RelatorioPorProfissional("XYZ99"));

        // 7. Relatório Resumido
        sistema.emitirRelatorio(new RelatorioResumido());
    }
}
