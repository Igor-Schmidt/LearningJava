package persistence;

import java.util.List;

/**
 * Interface genérica para persistência de dados.
 *
 * @param <T> O tipo de objeto a ser persistido.
 */
public interface Persistencia<T> {

    /**
     * Salva uma lista de objetos em um arquivo.
     *
     * @param lista A lista de objetos a ser salva.
     */
    void salvar(List<T> lista);

    /**
     * Carrega uma lista de objetos de um arquivo.
     *
     * @return A lista de objetos carregada.
     */
    List<T> carregar();
}
