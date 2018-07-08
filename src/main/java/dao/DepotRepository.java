package dao;

import entities.Depot;

import java.util.ArrayList;

public interface DepotRepository {
    public ArrayList<Depot> all();

    public void save(Depot depot) ;
}
