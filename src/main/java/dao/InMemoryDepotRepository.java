package dao;

import entities.Depot;

import java.util.ArrayList;

public class InMemoryDepotRepository implements DepotRepository {

    private ArrayList<Depot> depotArrayList = new ArrayList<Depot>();
    @Override
    public ArrayList<Depot> all() {
        return depotArrayList;
    }

    @Override
    public void save(Depot depot) {
        depotArrayList.add(depot);
    }
}
