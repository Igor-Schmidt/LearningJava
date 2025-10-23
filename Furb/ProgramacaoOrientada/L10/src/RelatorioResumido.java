// Aluno: Igor Zafriel Schmidt
import java.util.List;
import java.util.Set;

public class RelatorioResumido implements IRelatorio {
    @Override
    public void gerar(List<Projeto> projetos, Set<Profissional> profissionais) {
        System.out.println("\n--- Relatório Resumido de Projetos ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
            return;
        }
        projetos.forEach(p -> {
            System.out.println("ID: " + p.getId() + " | Resumo: " + p.getResumo());
        });
        System.out.println("--------------------------------------");
    }
}
