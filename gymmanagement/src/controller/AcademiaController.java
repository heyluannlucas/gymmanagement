package controller;

import View.AcademiaView;
import model.Academia;
import model.Aula;
import model.Membro;

import javax.swing.*;


public class AcademiaController {
    private Academia academia;
    private AcademiaView view;

    public AcademiaController(Academia academia, AcademiaView view) {
        this.academia = academia;
        this.view = view;

        view.addCadastroMembroListener(e -> cadastrarMembro());
        view.addCadastroAulaListener(e -> cadastrarAula());
        view.addInscreverMembroListener(e -> inscreverMembroEmAula());
        view.addRegistrarFrequenciaListener(e -> registrarFrequencia());
        view.addListarAulasListener(e -> listarAulas());
    }

    private void cadastrarMembro() {
        String nome = JOptionPane.showInputDialog("Nome do Membro:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Membro:"));
        boolean pagamentoEmDia = JOptionPane.showConfirmDialog(null, "Pagamento em dia?") == JOptionPane.YES_OPTION;
        Membro membro = new Membro(nome, id, pagamentoEmDia);
        academia.adicionarMembro(membro);
        view.exibirMensagem("Membro cadastrado: " + nome);
    }

    private void cadastrarAula() {
        String nome = JOptionPane.showInputDialog("Nome da Aula:");
        String instrutor = JOptionPane.showInputDialog("Nome do Instrutor:");
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Capacidade da Aula:"));
        Aula aula = new Aula(nome, instrutor, capacidade);
        academia.adicionarAula(aula);
        view.exibirMensagem("Aula cadastrada: " + nome);
    }

    private void inscreverMembroEmAula() {
        int membroId = Integer.parseInt(JOptionPane.showInputDialog("ID do Membro:"));
        String nomeAula = JOptionPane.showInputDialog("Nome da Aula:");

        Membro membro = academia.getMembros().stream().filter(m -> m.getId() == membroId).findFirst().orElse(null);
        Aula aula = academia.getAulas().stream().filter(a -> a.getNome().equalsIgnoreCase(nomeAula)).findFirst().orElse(null);

        if (membro != null && aula != null) {
            if (academia.inscreverMembroEmAula(membro, aula)) {
                view.exibirMensagem("Membro inscrito na aula: " + nomeAula);
            } else {
                view.exibirMensagem("Não foi possível inscrever o membro. Verifique o pagamento ou capacidade.");
            }
        } else {
            view.exibirMensagem("Membro ou Aula não encontrado.");
        }
    }

    private void registrarFrequencia() {
        int membroId = Integer.parseInt(JOptionPane.showInputDialog("ID do Membro:"));
        String nomeAula = JOptionPane.showInputDialog("Nome da Aula:");

        Membro membro = academia.getMembros().stream().filter(m -> m.getId() == membroId).findFirst().orElse(null);
        Aula aula = academia.getAulas().stream().filter(a -> a.getNome().equalsIgnoreCase(nomeAula)).findFirst().orElse(null);

        if (membro != null && aula != null) {
            academia.registrarFrequencia(aula, membro);
            view.exibirMensagem("Frequência registrada para o membro: " + membro.getNome());
        } else {
            view.exibirMensagem("Membro ou Aula não encontrado.");
        }
    }

    private void listarAulas() {
        view.limparExibicao();
        for (Aula aula : academia.getAulas()) {
            view.exibirMensagem(aula.toString());
        }
    }
}
