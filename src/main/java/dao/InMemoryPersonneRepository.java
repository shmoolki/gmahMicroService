package dao;


import entities.Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryPersonneRepository implements PersonneRepository {
    private ArrayList<Personne> personneArrayList = new ArrayList<Personne>();
    @Override
    public ArrayList<Personne> all() {
        return personneArrayList;
    }

    @Override
    public void save(Personne personne) {
        List<Personne> listPersonne =  personneArrayList.stream().filter(p -> p.getId() == personne.getId()).collect(Collectors.toList());
        if(listPersonne.size() > 0) update(personne);
        else personneArrayList.add(personne);
        
    }

    private void update(Personne personne) {
        personneArrayList.forEach(personne1 -> {
            if(personne1.getId() == personne.getId()){
                personne1 = personne;
            }
        });
    }

    @Override
    public Optional<Personne> getById(long id) {
        List<Personne> listPersonne =  personneArrayList.stream().filter(personne -> personne.getId() == id).collect(Collectors.toList());
        if(listPersonne.size() > 0)
            return Optional.ofNullable(listPersonne.get(0));
        return null;
    }
}
