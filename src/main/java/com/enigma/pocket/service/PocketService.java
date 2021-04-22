package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;

import java.util.List;

public interface PocketService {

    public Pocket getPocketById(String id);
    public List<Pocket> findAllPocket();
    public Pocket createNewPocket(Pocket pocket);
}
