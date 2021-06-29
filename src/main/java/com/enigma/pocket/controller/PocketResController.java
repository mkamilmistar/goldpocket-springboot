package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.model.request.GetPocketCustomerByProductRequest;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PocketResController {

    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/{id}")
    public Pocket getPocketById(@PathVariable(name = "id") String id){
        return pocketService.getPocketById(id);
    }

    @GetMapping("/pockets")
    public Page<Pocket> getAllPocket(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                     @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return pocketService.findAllPocket(pageable);
    }

    @PostMapping(value = "/pocket/customer-by-product")
    public List<Pocket> pocketCustomerByProduct(
      @RequestBody GetPocketCustomerByProductRequest request
    ) {
      List<Pocket> getPocketCustomerByProduct = pocketService.findPocketCustomerByProduct(request);
      return getPocketCustomerByProduct;
    }

    @PostMapping("/pocket")
    public Pocket createPocket(@RequestBody Pocket pocket){
        return pocketService.createNewPocket(pocket);
    }

    @PutMapping("/pocket")
    public Pocket editPocket(@RequestBody Pocket pocket){
        return pocketService.updatePocket(pocket);
    }

    @DeleteMapping("/pocket/{id}")
    public void deletePocketById(@PathVariable(name = "id") String id){
        pocketService.deletePocketById(id);
    }


}
