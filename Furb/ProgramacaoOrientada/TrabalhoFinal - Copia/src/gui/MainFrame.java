package gui;

import model.*;
import service.ServicoEstoque;
import service.ServicoMovimento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

public class MainFrame extends JFrame {

    private final ServicoEstoque servicoEstoque;
    private final ServicoMovimento servicoMovimento;

    // Componentes do Painel de Produtos
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabelaProdutos;
    private JTextField txtCodigo, txtNome, txtPreco;
    private JComboBox<CategoriaProduto> comboCategoria;
    private JButton btnNovo, btnSalvar, btnExcluir;

    // Componentes do Painel de Entradas
    private JComboBox<Produto> comboProdutoEntrada;
    private JTextField txtDataEntrada, txtQtdEntrada, txtValorUnitarioEntrada;
    private JButton btnRegistrarEntrada;

    // Componentes do Painel de Saídas
    private JComboBox<Produto> comboProdutoSaida;
    private JTextField txtDataSaida, txtQtdSaida;
    private JComboBox<TipoSaida> comboTipoSaida;
    private JButton btnRegistrarSaida;

    // Componentes do Painel de Movimentos
    private JTable tabelaMovimentos;
    private DefaultTableModel modeloTabelaMovimentos;


    public MainFrame() {
        this.servicoEstoque = new ServicoEstoque();
        this.servicoMovimento = new ServicoMovimento(servicoEstoque);

        setTitle("Controle de Estoque - Loja de Informática");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cadastro de Produtos", criarPainelProdutos());
        tabbedPane.addTab("Registrar Entrada", criarPainelEntrada());
        tabbedPane.addTab("Registrar Saída", criarPainelSaida());
        tabbedPane.addTab("Listar Movimentos", criarPainelMovimentos());

        add(tabbedPane);

        // Carregar dados iniciais
        atualizarTabelaProdutos();
        atualizarTabelaMovimentos();
        atualizarCombosProduto();
    }

    private JPanel criarPainelProdutos() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Formulário de Cadastro
        JPanel painelForm = new JPanel(new GridBagLayout());
        painelForm.setBorder(BorderFactory.createTitledBorder("Cadastro de Produto"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; painelForm.add(new JLabel("Código (SKU):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; txtCodigo = new JTextField(15); painelForm.add(txtCodigo, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painelForm.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; txtNome = new JTextField(15); painelForm.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 2; painelForm.add(new JLabel("Preço Unitário:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; txtPreco = new JTextField(15); painelForm.add(txtPreco, gbc);

        gbc.gridx = 0; gbc.gridy = 3; painelForm.add(new JLabel("Categoria:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; comboCategoria = new JComboBox<>(CategoriaProduto.values()); painelForm.add(comboCategoria, gbc);

        // Botões do formulário
        JPanel painelBotoesForm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        painelBotoesForm.add(btnNovo);
        painelBotoesForm.add(btnSalvar);
        painelBotoesForm.add(btnExcluir);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; painelForm.add(painelBotoesForm, gbc);

        // Tabela de Produtos
        modeloTabelaProdutos = new DefaultTableModel(new String[]{"SKU", "Nome", "Categoria", "Preço Unit.", "Estoque"}, 0);
        tabelaProdutos = new JTable(modeloTabelaProdutos);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Produtos em Estoque"));

        painel.add(painelForm, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);

        // Ações dos botões
        btnNovo.addActionListener(e -> limparFormularioProdutos());
        btnSalvar.addActionListener(e -> salvarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());
        tabelaProdutos.getSelectionModel().addListSelectionListener(e -> preencherFormularioComProdutoSelecionado());

        return painel;
    }

    private JPanel criarPainelEntrada() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; painel.add(new JLabel("Produto:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; comboProdutoEntrada = new JComboBox<>(); painel.add(comboProdutoEntrada, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painel.add(new JLabel("Data Entrada (yyyy-MM-dd):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; txtDataEntrada = new JTextField(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)); painel.add(txtDataEntrada, gbc);

        gbc.gridx = 0; gbc.gridy = 2; painel.add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; txtQtdEntrada = new JTextField(10); painel.add(txtQtdEntrada, gbc);

        gbc.gridx = 0; gbc.gridy = 3; painel.add(new JLabel("Valor Unitário (Custo):"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; txtValorUnitarioEntrada = new JTextField(10); painel.add(txtValorUnitarioEntrada, gbc);

        gbc.gridx = 1; gbc.gridy = 4; btnRegistrarEntrada = new JButton("Registrar Entrada"); painel.add(btnRegistrarEntrada, gbc);

        btnRegistrarEntrada.addActionListener(e -> registrarEntrada());

        return painel;
    }

    private JPanel criarPainelSaida() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; painel.add(new JLabel("Produto:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; comboProdutoSaida = new JComboBox<>(); painel.add(comboProdutoSaida, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painel.add(new JLabel("Data Saída (yyyy-MM-dd):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; txtDataSaida = new JTextField(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)); painel.add(txtDataSaida, gbc);

        gbc.gridx = 0; gbc.gridy = 2; painel.add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; txtQtdSaida = new JTextField(10); painel.add(txtQtdSaida, gbc);

        gbc.gridx = 0; gbc.gridy = 3; painel.add(new JLabel("Tipo de Saída:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; comboTipoSaida = new JComboBox<>(TipoSaida.values()); painel.add(comboTipoSaida, gbc);

        gbc.gridx = 1; gbc.gridy = 4; btnRegistrarSaida = new JButton("Registrar Saída"); painel.add(btnRegistrarSaida, gbc);

        btnRegistrarSaida.addActionListener(e -> registrarSaida());

        return painel;
    }

    private JPanel criarPainelMovimentos() {
        JPanel painel = new JPanel(new BorderLayout());
        modeloTabelaMovimentos = new DefaultTableModel(new String[]{"ID", "Data", "Tipo", "Produto", "Qtd", "Valor", "Tipo Saída"}, 0);
        tabelaMovimentos = new JTable(modeloTabelaMovimentos);
        painel.add(new JScrollPane(tabelaMovimentos), BorderLayout.CENTER);
        return painel;
    }

    // Métodos de Lógica e Atualização
    private void atualizarTabelaProdutos() {
        modeloTabelaProdutos.setRowCount(0);
        List<Produto> produtos = servicoEstoque.getSaldoAtual();
        for (Produto p : produtos) {
            modeloTabelaProdutos.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNome(),
                    p.getCategoria(),
                    String.format("%.2f", p.getPrecoUnitario()),
                    p.getQuantidadeEstoque()
            });
        }
    }

    private void atualizarTabelaMovimentos() {
        modeloTabelaMovimentos.setRowCount(0);
        List<Movimento> movimentos = servicoMovimento.listarMovimentosOrdenados();
        for (Movimento m : movimentos) {
            String valor = "";
            String tipoSaida = "";
            if (m instanceof Entrada) {
                valor = String.format("%.2f", ((Entrada) m).getValorUnitario());
            } else {
                valor = String.format("%.2f", m.getProduto().getPrecoUnitario());
                tipoSaida = ((Saida) m).getTipoSaida().name();
            }
            modeloTabelaMovimentos.addRow(new Object[]{
                    m.getId(),
                    m.getData().format(DateTimeFormatter.ISO_LOCAL_DATE),
                    m.getTipo(),
                    m.getProduto().getNome(),
                    m.getQuantidade(),
                    valor,
                    tipoSaida
            });
        }
    }

    private void atualizarCombosProduto() {
        comboProdutoEntrada.removeAllItems();
        comboProdutoSaida.removeAllItems();
        List<Produto> produtos = servicoEstoque.getSaldoAtual();
        for (Produto p : produtos) {
            comboProdutoEntrada.addItem(p);
            comboProdutoSaida.addItem(p);
        }
    }

    private void limparFormularioProdutos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        comboCategoria.setSelectedIndex(0);
        txtCodigo.setEditable(true);
        tabelaProdutos.clearSelection();
    }

    private void salvarProduto() {
        try {
            String codigo = txtCodigo.getText();
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            CategoriaProduto categoria = (CategoriaProduto) comboCategoria.getSelectedItem();

            if (codigo.isEmpty() || nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Código e Nome são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Na criação de um novo produto, a quantidade inicial é 0.
            // A quantidade só é alterada via movimentos de entrada/saída.
            Produto p = new Produto(codigo, nome, preco, 0, categoria);
            servicoEstoque.cadastrarProduto(p);

            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            limparFormularioProdutos();
            atualizarTabelaProdutos();
            atualizarCombosProduto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirProduto() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            String codigo = (String) modeloTabelaProdutos.getValueAt(selectedRow, 0);
            servicoEstoque.buscarProduto(codigo).ifPresent(produto -> {
                int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o produto " + produto.getNome() + "?\nIsso não alterará os registros de movimentos existentes.", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    servicoEstoque.excluirProduto(produto);
                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                    limparFormularioProdutos();
                    atualizarTabelaProdutos();
                    atualizarCombosProduto();
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preencherFormularioComProdutoSelecionado() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            String codigo = (String) modeloTabelaProdutos.getValueAt(selectedRow, 0);
            servicoEstoque.buscarProduto(codigo).ifPresent(p -> {
                txtCodigo.setText(p.getCodigo());
                txtNome.setText(p.getNome());
                txtPreco.setText(String.valueOf(p.getPrecoUnitario()));
                comboCategoria.setSelectedItem(p.getCategoria());
                txtCodigo.setEditable(false); // Não pode editar código de produto existente
            });
        }
    }

    private void registrarEntrada() {
        try {
            Produto produto = (Produto) comboProdutoEntrada.getSelectedItem();
            LocalDate data = LocalDate.parse(txtDataEntrada.getText());
            int qtd = Integer.parseInt(txtQtdEntrada.getText());
            double valor = Double.parseDouble(txtValorUnitarioEntrada.getText());

            if (produto == null || qtd <= 0 || valor <= 0) {
                JOptionPane.showMessageDialog(this, "Dados de entrada inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Entrada entrada = new Entrada(produto, data, qtd, valor);
            servicoMovimento.registrarEntrada(entrada);

            JOptionPane.showMessageDialog(this, "Entrada registrada com sucesso!");
            atualizarTabelaProdutos();
            atualizarTabelaMovimentos();
            txtQtdEntrada.setText("");
            txtValorUnitarioEntrada.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar entrada: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarSaida() {
        try {
            Produto produto = (Produto) comboProdutoSaida.getSelectedItem();
            LocalDate data = LocalDate.parse(txtDataSaida.getText());
            int qtd = Integer.parseInt(txtQtdSaida.getText());
            TipoSaida tipoSaida = (TipoSaida) comboTipoSaida.getSelectedItem();

            if (produto == null || qtd <= 0) {
                JOptionPane.showMessageDialog(this, "Dados de saída inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (produto.getQuantidadeEstoque() < qtd) {
                JOptionPane.showMessageDialog(this, "Quantidade em estoque insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Saida saida = new Saida(produto, data, qtd, tipoSaida);
            servicoMovimento.registrarSaida(saida);

            JOptionPane.showMessageDialog(this, "Saída registrada com sucesso!");
            atualizarTabelaProdutos();
            atualizarTabelaMovimentos();
            txtQtdSaida.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar saída: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
