package dao;

import entities.Emprunt;

import java.util.ArrayList;

public interface EmpruntRepository {

    public ArrayList<Emprunt> all();

    public void save(Emprunt emprunt) ;
}
