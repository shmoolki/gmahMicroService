package dao;


import entities.Personne;

import java.util.ArrayList;

public class InMemoryPersonneRepository implements PersonneRepository {
    private ArrayList<Personne> personneArrayList = new ArrayList<Personne>();
    @Override
    public ArrayList<Personne> all() {
        return personneArrayList;
    }

    @Override
    public void save(Personne personne) {
        personneArrayList.add(personne);
    }
}
