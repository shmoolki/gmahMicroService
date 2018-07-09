package dao;

import entities.Personne;

import java.util.ArrayList;

public interface PersonneRepository {
    public ArrayList<Personne> all();

    public void save(Personne personne) ;
}
