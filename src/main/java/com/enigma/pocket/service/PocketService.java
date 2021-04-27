package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PocketService {

    public Pocket getPocketById(String id);
    public Page<Pocket> findAllPocket(Pageable pageable);
    public Pocket createNewPocket(Pocket pocket);
    public Pocket updatePocket(Pocket pocket);
    public void deletePocketById(String id);
    public void topUp(Pocket pocket, Double qty, Integer purchaseType);
    public List<Pocket> findAllPocketByCustomer(String customerId);
}
