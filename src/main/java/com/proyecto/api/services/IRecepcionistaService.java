package com.proyecto.api.services;

 

import java.util.List;
import com.proyecto.api.entity.Recepcionista;

public interface IRecepcionistaService {

    List<Recepcionista> getBooksByTitle(String usuario);

    public List<Recepcionista> findAll();

    public Recepcionista save(Recepcionista recepcionista);

    public Recepcionista findById(Long idRecepcionista);

    public void delete(Long idRecepcionista);
}
