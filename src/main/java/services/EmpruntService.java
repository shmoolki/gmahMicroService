package services;

import dao.EmpruntRepository;
import entities.Emprunt;

import java.util.*;
import java.util.stream.Collectors;

public class EmpruntService {
    private ArrayList<Emprunt> empruntArrayList = new ArrayList<Emprunt>();
    private EmpruntRepository empruntRepository;
    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public ArrayList<Emprunt> getInProgress() {
        return empruntRepository.getInProgress();
    }
}
