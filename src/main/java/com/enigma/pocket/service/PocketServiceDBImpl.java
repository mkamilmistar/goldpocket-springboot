package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PocketServiceDBImpl implements PocketService{

    private final String notFoundMessage = "Customer with id: %s Not Found";

    @Autowired
    PocketRepository pocketRepository;

    @Override
    public Pocket getPocketById(String id) {
        validatePresent(id);
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
    public Pocket updatePocket(Pocket pocket) {
        validatePresent(pocket.getId());
        return pocketRepository.save(pocket);
    }

    @Override
    public void deletePocketById(String id) {
        validatePresent(id);
        pocketRepository.deleteById(id);
    }

    private void validatePresent(String id) {
        if(! (pocketRepository.findById(id).isPresent())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
