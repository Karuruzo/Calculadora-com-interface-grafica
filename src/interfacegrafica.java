import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfacegrafica {
    private JFrame janela;
    private JPanel painel;
    private JTextField campoA;
    private JTextField campoB;
    private JTextField campoC;
    private JLabel resultadoLabel;

    public interfacegrafica() {
        janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 400);
        janela.setLocationRelativeTo(null); // Centralizar janela na tela

        painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        JLabel tituloLabel = new JLabel("Calculadora");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Alterar a fonte e tamanho do título

        JLabel dicaLabel = new JLabel("Valor C apenas para Bhaskara");
        dicaLabel.setHorizontalAlignment(SwingConstants.LEFT); // Alinhar à esquerda

        JLabel rotuloA = new JLabel("Valor de A");
        campoA = new JTextField();
        campoA.setHorizontalAlignment(SwingConstants.RIGHT); // Alinhar à direita
        campoA.setPreferredSize(new Dimension(150, campoA.getPreferredSize().height));
        JLabel rotuloB = new JLabel("Valor de B");
        campoB = new JTextField();
        campoB.setHorizontalAlignment(SwingConstants.RIGHT); // Alinhar à direita
        campoB.setPreferredSize(new Dimension(150, campoB.getPreferredSize().height));
        JLabel rotuloC = new JLabel("Valor de C");
        campoC = new JTextField();
        campoC.setHorizontalAlignment(SwingConstants.RIGHT); // Alinhar à direita
        campoC.setPreferredSize(new Dimension(150, campoC.getPreferredSize().height)); // Aumentar a largura da caixa de texto

        JButton botaoSoma = new JButton("Soma");
        JButton botaoSubtracao = new JButton("Subtração");
        JButton botaoMultiplicacao = new JButton("Multiplicação");
        JButton botaoDivisao = new JButton("Divisão");
        JButton botaoRaiz = new JButton("Raiz");
        JButton botaoPotencia = new JButton("Potência");
        JButton botaoBhaskara = new JButton("Bhaskara");

        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Alterar a fonte e tamanho do resultado

        BotaoListener listener = new BotaoListener();

        botaoSoma.addActionListener(listener);
        botaoSubtracao.addActionListener(listener);
        botaoMultiplicacao.addActionListener(listener);
        botaoDivisao.addActionListener(listener);
        botaoRaiz.addActionListener(listener);
        botaoPotencia.addActionListener(listener);
        botaoBhaskara.addActionListener(listener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(tituloLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(dicaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(rotuloA, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        painel.add(campoA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(rotuloB, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        painel.add(campoB, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(rotuloC, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        painel.add(campoC, gbc);

        JPanel botoesPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        botoesPanel.add(botaoSoma);
        botoesPanel.add(botaoSubtracao);
        botoesPanel.add(botaoMultiplicacao);
        botoesPanel.add(botaoDivisao);
        botoesPanel.add(botaoRaiz);
        botoesPanel.add(botaoPotencia);
        botoesPanel.add(botaoBhaskara);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(botoesPanel, gbc);

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(resultadoLabel, gbc);

        // Configurar cores de fundo e texto
        painel.setBackground(Color.WHITE);
        tituloLabel.setForeground(Color.BLUE);
        resultadoLabel.setForeground(Color.RED);

        janela.add(painel);
        janela.setVisible(true);
    }

    class BotaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double valorA = Double.parseDouble(campoA.getText());
            double valorB = Double.parseDouble(campoB.getText());
            double valorC = 0.0;

            if (!campoC.getText().isEmpty()) {
                valorC = Double.parseDouble(campoC.getText());
            }

            double resultado = 0.0;

            if (e.getSource() instanceof JButton) {
                JButton botao = (JButton) e.getSource();
                String operacao = botao.getText();

                switch (operacao) {
                    case "Soma":
                        resultado = valorA + valorB;
                        break;
                    case "Subtração":
                        resultado = valorA - valorB;
                        break;
                    case "Multiplicação":
                        resultado = valorA * valorB;
                        break;
                    case "Divisão":
                        if (valorB != 0) {
                            resultado = valorA / valorB;
                        } else {
                            JOptionPane.showMessageDialog(janela, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Raiz":
                        if (valorA >= 0) {
                            resultado = Math.sqrt(valorA);
                        } else {
                            JOptionPane.showMessageDialog(janela, "Erro: Valor inválido para raiz!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Potência":
                        resultado = Math.pow(valorA, valorB);
                        break;
                    case "Bhaskara":
                        double delta = valorB * valorB - 4 * valorA * valorC;
                        if (delta >= 0) {
                            double x1 = (-valorB + Math.sqrt(delta)) / (2 * valorA);
                            double x2 = (-valorB - Math.sqrt(delta)) / (2 * valorA);
                            JOptionPane.showMessageDialog(janela, "Soluções da equação:\n x1 = " + x1 + "\n x2 = " + x2);
                        } else {
                            JOptionPane.showMessageDialog(janela, "Erro: Delta negativo!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }

                resultadoLabel.setText("Resultado: " + resultado);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new interfacegrafica();
            }
        });
    }
}
