package br.edu.ifsp.domain.model.consulta;

import java.util.List;

public interface ConsultaRepository {
    void save(Consulta consulta);
    Consulta findById(int id);
    List<Consulta> findAll();
}