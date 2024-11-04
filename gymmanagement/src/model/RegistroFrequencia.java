package model;

import java.time.LocalDate;

public class RegistroFrequencia {
    private Aula aula;
    private Membro membro;
    private LocalDate data;

    public RegistroFrequencia(Aula aula, Membro membro, LocalDate data) {
        this.aula = aula;
        this.membro = membro;
        this.data = data;
    }

    public Aula getAula() { return aula; }
    public Membro getMembro() { return membro; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return "Frequência [Aula: " + aula.getNome() + ", Membro: " + membro.getNome() + ", Data: " + data + "]";
    }
}
