package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AcademiaView extends JFrame {
    private JButton btnCadastrarMembro;
    private JButton btnCadastrarAula;
    private JButton btnInscreverEmAula;
    private JButton btnRegistrarFrequencia;
    private JButton btnListarAulas;
    private JTextArea displayArea;

    public AcademiaView() {
        setTitle("Sistema de Gerenciamento de Academia");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCadastrarMembro = new JButton("Cadastrar Membro");
        btnCadastrarAula = new JButton("Cadastrar Aula");
        btnInscreverEmAula = new JButton("Inscrever em Aula");
        btnRegistrarFrequencia = new JButton("Registrar Frequência");
        btnListarAulas = new JButton("Listar Aulas Disponíveis");
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(btnCadastrarMembro);
        panel.add(btnCadastrarAula);
        panel.add(btnInscreverEmAula);
        panel.add(btnRegistrarFrequencia);
        panel.add(btnListarAulas);
        panel.add(new JScrollPane(displayArea));

        add(panel, BorderLayout.CENTER);
    }

    public void addCadastroMembroListener(ActionListener listener) {
        btnCadastrarMembro.addActionListener(listener);
    }

    public void addCadastroAulaListener(ActionListener listener) {
        btnCadastrarAula.addActionListener(listener);
    }

    public void addInscreverMembroListener(ActionListener listener) {
        btnInscreverEmAula.addActionListener(listener);
    }

    public void addRegistrarFrequenciaListener(ActionListener listener) {
        btnRegistrarFrequencia.addActionListener(listener);
    }

    public void addListarAulasListener(ActionListener listener) {
        btnListarAulas.addActionListener(listener);
    }

    public void exibirMensagem(String mensagem) {
        displayArea.append(mensagem + "\n");
    }

    public void limparExibicao() {
        displayArea.setText("");
    }
}
