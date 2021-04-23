package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketServiceDBImpl implements PocketService{

    @Autowired
    PocketRepository pocketRepository;

    @Override
    public Pocket getPocketById(String id) {
        return pocketRepository.findById(id).get();
    }

    @Override
    public Page<Pocket> findAllPocket(Pageable pageable) {
        return pocketRepository.findAll(pageable);
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }

    @Override
    public Pocket editPocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }

    @Override
    public void deletePocketById(String id) {
        pocketRepository.deleteById(id);
    }
}
