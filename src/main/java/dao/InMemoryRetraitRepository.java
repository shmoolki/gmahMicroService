package dao;


import entities.Retrait;

import java.util.ArrayList;

public class InMemoryRetraitRepository implements RetraitRepository {
    private ArrayList<Retrait> retraitArrayList = new ArrayList<Retrait>();
    @Override
    public ArrayList<Retrait> all() {
        return retraitArrayList;
    }

    @Override
    public void save(Retrait retrait) {
        retraitArrayList.add(retrait);
    }

}
