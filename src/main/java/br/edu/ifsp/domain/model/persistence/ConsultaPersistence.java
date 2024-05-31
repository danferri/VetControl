package br.edu.ifsp.domain.model.persistence;

import br.edu.ifsp.domain.model.consulta.Consulta;
import br.edu.ifsp.domain.model.consulta.ConsultaRepository;

import java.util.ArrayList;
import java.util.List;

public class ConsultaPersistence implements ConsultaRepository {
    private List<Consulta> consultas = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void save(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public Consulta findById(int id) {
        return consultas.get(id - 1); // Assuming id is 1-based and corresponds to list index
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(consultas);
    }
}
