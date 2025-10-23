// Aluno: Igor Zafriel Schmidt
import java.util.List;
import java.util.Set;

public class RelatorioPorTipo implements IRelatorio {

    private Class<? extends Projeto> tipo;

    public RelatorioPorTipo(Class<? extends Projeto> tipo) {
        this.tipo = tipo;
    }

    @Override
    public void gerar(List<Projeto> projetos, Set<Profissional> profissionais) {
        String nomeTipo = tipo.equals(ProjetoPublico.class) ? "Públicos" : "Empreendimentos Privados";
        System.out.println("\n--- Relatório por Tipo: " + nomeTipo + " ---");

        long count = projetos.stream().filter(tipo::isInstance).count();
        if (count == 0) {
            System.out.println("Nenhum projeto deste tipo encontrado.");
            return;
        }

        projetos.stream()
            .filter(tipo::isInstance)
            .forEach(p -> {
                System.out.println("----------------------------------------");
                System.out.println("ID: " + p.getId() + " | Descrição: " + p.getDescricao());
            });
        System.out.println("----------------------------------------");
    }
}
