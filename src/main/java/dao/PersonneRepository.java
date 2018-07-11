package dao;

import entities.Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonneRepository {
    public ArrayList<Personne> all();

    public void save(Personne personne) ;

    Optional<Personne> getById(long id);

    Optional<List<Personne>> getByMc(String mc);
}
