package dao;

import entities.Emprunt;

import java.util.ArrayList;
import java.util.Optional;

public interface EmpruntRepository {

    public ArrayList<Emprunt> all();

    public void save(Emprunt emprunt) ;
}
