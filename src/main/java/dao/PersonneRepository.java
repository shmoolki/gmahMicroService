package dao;

import entities.Personne;

import java.util.ArrayList;
import java.util.Optional;

public interface PersonneRepository {
    public ArrayList<Personne> all();

    public void save(Personne personne) ;

    Optional<Personne> getById(long id);
}
