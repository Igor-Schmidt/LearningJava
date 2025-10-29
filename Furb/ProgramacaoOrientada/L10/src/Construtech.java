// Aluno: Igor Zafriel Schmidt

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Construtech {
    private Set<Profissional> profissionais = new HashSet<>();
    private List<Projeto> projetos = new ArrayList<>();

    public void cadastrarProfissional(Profissional profissional) {
        for (Profissional p : profissionais) {
            if (p.getId().equals(profissional.getId()) || p.getCpf().equals(profissional.getCpf())) {
                System.out.println("Erro: Profissional com mesmo ID ou CPF, já cadastrado.");
                return;
            }
        }
        profissionais.add(profissional);
        System.out.println("Profissional " + profissional.getNome() + " cadastrado com sucesso.");
    }

    public void cadastrarProjeto(Projeto projeto) {
        for (Projeto p : projetos) {
            if (p.getId().equals(projeto.getId())) {
                System.out.println("Erro: Projeto com mesmo ID já cadastrado.");
                return;
            }
        }
        projetos.add(projeto);
        System.out.println("Projeto " + projeto.getId() + " cadastrado com sucesso.");
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void emitirRelatorio(IRelatorio relatorio) {
        relatorio.gerar(projetos, profissionais);
    }

    public Set<Profissional> getProfissionais() {
        return profissionais;
    }
}
