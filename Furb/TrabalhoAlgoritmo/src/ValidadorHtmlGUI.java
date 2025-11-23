package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class ValidadorHtmlGUI extends JFrame {

    private JTextField txtCaminhoArquivo;
    private JButton btnAnalisar;
    private JButton btnProcurar;
    private JTextArea areaResultado;
    private JTable tabelaOcorrencias;
    private AnalisadorHtml analisador;

    public ValidadorHtmlGUI() {
        super("Validador de Arquivo HTML");
        this.analisador = new AnalisadorHtml();
        inicializarComponentes();
        configurarJanela();
    }

    private void inicializarComponentes() {
        JPanel painelSuperior = new JPanel(new BorderLayout(5, 5));
        painelSuperior.setBorder(BorderFactory.createTitledBorder("Arquivo"));

        txtCaminhoArquivo = new JTextField(40);
        btnProcurar = new JButton("Procurar...");
        btnAnalisar = new JButton("Analisar");

        JPanel painelBotoesArquivo = new JPanel();
        painelBotoesArquivo.add(btnProcurar);
        painelBotoesArquivo.add(btnAnalisar);

        painelSuperior.add(new JLabel("Arquivo:"), BorderLayout.WEST);
        painelSuperior.add(txtCaminhoArquivo, BorderLayout.CENTER);
        painelSuperior.add(painelBotoesArquivo, BorderLayout.EAST);

        JPanel painelCentral = new JPanel(new BorderLayout(5, 5));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        areaResultado = new JTextArea(5, 50);
        areaResultado.setEditable(false);
        painelCentral.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new BorderLayout(5, 5));
        painelInferior.setBorder(BorderFactory.createTitledBorder("Ocorrências de Tags"));
        tabelaOcorrencias = new JTable();
        painelInferior.add(new JScrollPane(tabelaOcorrencias), BorderLayout.CENTER);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, painelCentral, painelInferior);
        splitPane.setResizeWeight(0.3);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));
        contentPane.add(painelSuperior, BorderLayout.NORTH);
        contentPane.add(splitPane, BorderLayout.CENTER);

        btnProcurar.addActionListener(e -> procurarArquivo());
        btnAnalisar.addActionListener(e -> analisarArquivo());
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void procurarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo HTML");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            txtCaminhoArquivo.setText(fileToOpen.getAbsolutePath());
        }
    }

    private void analisarArquivo() {
        String caminho = txtCaminhoArquivo.getText();
        if (caminho == null || caminho.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um arquivo HTML.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        analisador.analisar(caminho);
        areaResultado.setText(analisador.getResultadoAnalise());

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Tag", "Número de Ocorrências"}, 0);
        ListaEncadeada<TagContador> contadores = analisador.getContadores();
        NoLista<TagContador> no = contadores.getPrimeiro();
        while (no != null) {
            TagContador tc = no.getInfo();
            model.addRow(new Object[]{tc.getNome(), tc.getContagem()});
            no = no.getProximo();
        }
        tabelaOcorrencias.setModel(model);
    }
}
