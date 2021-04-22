package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketServiceDBImpl implements PocketService{

    @Autowired
    PocketRepository pocketRepository;

    @Override
    public Pocket getPocketById(String id) {
        return null;
    }

    @Override
    public List<Pocket> findAllPocket() {
        return null;
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }
}
