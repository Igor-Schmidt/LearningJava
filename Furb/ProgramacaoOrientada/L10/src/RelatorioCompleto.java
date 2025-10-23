// Aluno: Igor Zafriel Schmidt
import java.util.List;
import java.util.Set;

public class RelatorioCompleto implements IRelatorio {
    @Override
    public void gerar(List<Projeto> projetos, Set<Profissional> profissionais) {
        System.out.println("\n--- Relatório Completo de Projetos ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
            return;
        }
        projetos.forEach(projeto -> {
            System.out.println("----------------------------------------");
            System.out.println("ID: " + projeto.getId());
            System.out.println("Descrição: " + projeto.getDescricao());
            System.out.println("Data de Entrada: " + projeto.getDataEntrada());

            if (projeto instanceof ProjetoPublico) {
                ProjetoPublico projetoPublico = (ProjetoPublico) projeto;
                System.out.println("Tipo: Projeto Público");
                System.out.println("Data de Início: " + projetoPublico.getDataInicio());
                System.out.println("Data de Fim: " + projetoPublico.getDataFim());
                System.out.println("Duração (dias): " + projetoPublico.getDuracaoEmDias());
            } else if (projeto instanceof EmpreendimentoPrivado) {
                EmpreendimentoPrivado empPrivado = (EmpreendimentoPrivado) projeto;
                System.out.println("Tipo: Empreendimento Privado");
                System.out.println("Área: " + empPrivado.getTipoArea());
                System.out.println("Metragem: " + empPrivado.getMetragem() + " m²");
            }

            String nomesResponsaveis = "";
            Set<Profissional> responsaveisRelatorio = projeto.getResponsaveis();
            int count = 0;
            int total = responsaveisRelatorio.size();

            for (Profissional p : responsaveisRelatorio) {
                nomesResponsaveis += p.getNome();

                if (count < total - 1) {
                    nomesResponsaveis += ", ";
                }
                count++;
            }
            System.out.println("Responsáveis: " + (nomesResponsaveis.isEmpty() ? "Nenhum" : nomesResponsaveis));
        });
        System.out.println("----------------------------------------");
    }
}
