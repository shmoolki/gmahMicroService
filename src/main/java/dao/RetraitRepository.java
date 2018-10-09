package dao;



import entities.Retrait;

import java.util.ArrayList;

public interface RetraitRepository {
    public ArrayList<Retrait> all();

    public void save(Retrait retrait) ;
}
