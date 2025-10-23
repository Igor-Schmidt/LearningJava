// Aluno: Igor Zafriel Schmidt
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RelatorioPorProfissional implements IRelatorio {

    private String idProfissional;

    public RelatorioPorProfissional(String idProfissional) {
        this.idProfissional = idProfissional;
    }

    @Override
    public void gerar(List<Projeto> projetos, Set<Profissional> profissionais) {
        Profissional profissional = profissionais.stream()
                .filter(p -> p.getId().equals(idProfissional))
                .findFirst()
                .orElse(null);

        if (profissional == null) {
            System.out.println("\n--- Erro: Profissional com ID '" + idProfissional + "' não encontrado. ---");
            return;
        }

        System.out.println("\n--- Relatório de Projetos por Profissional: " + profissional.getNome() + " ---");

        List<Projeto> projetosDoProfissional = projetos.stream()
                .filter(p -> p.getResponsaveis().stream().anyMatch(r -> r.getId().equals(idProfissional)))
                .collect(Collectors.toList());

        if (projetosDoProfissional.isEmpty()) {
            System.out.println("Nenhum projeto encontrado para este profissional.");
        } else {
            projetosDoProfissional.forEach(p -> {
                System.out.println(" - ID: " + p.getId() + ", Descrição: " + p.getDescricao());
            });
        }
        System.out.println("---------------------------------------------------------");
    }
}
