package dao;

import entities.Emprunt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ArrayList<Emprunt> getInProgress() {
        Date todayDate = new Date();
        List<Emprunt> listEmpInProg = empruntArrayList.stream().filter(emprunt -> {
            return (
                    ( emprunt.getDateEmprunt().before(todayDate) || emprunt.getDateEmprunt().equals(todayDate))
                            && (emprunt.getDateRemboursement().after(todayDate) || emprunt.getDateRemboursement().equals(todayDate))
            );
        }).collect(Collectors.toList());
        return new ArrayList<Emprunt>(listEmpInProg);
    }


}
