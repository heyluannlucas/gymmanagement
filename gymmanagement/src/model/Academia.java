package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Membro> membros;
    private List<Aula> aulas;
    private List<RegistroFrequencia> registrosFrequencia;

    public Academia() {
        this.membros = new ArrayList<>();
        this.aulas = new ArrayList<>();
        this.registrosFrequencia = new ArrayList<>();
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    public boolean inscreverMembroEmAula(Membro membro, Aula aula) {
        return aula.inscreverMembro(membro);
    }

    public void registrarFrequencia(Aula aula, Membro membro) {
        registrosFrequencia.add(new RegistroFrequencia(aula, membro, LocalDate.now()));
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<RegistroFrequencia> listarRegistrosFrequencia() {
        return registrosFrequencia;
    }
}
