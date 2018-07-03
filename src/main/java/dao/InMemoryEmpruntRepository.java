package dao;

import entities.Emprunt;

import java.util.ArrayList;

public class InMemoryEmpruntRepository implements EmpruntRepository {

    private ArrayList<Emprunt> empruntArrayList = new ArrayList<Emprunt>();
    @Override
    public ArrayList<Emprunt> all() {
        return empruntArrayList;
    }

    @Override
    public void save(Emprunt emprunt) {
        empruntArrayList.add(emprunt);
    }

}
