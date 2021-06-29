package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.model.request.GetPocketCustomerByProductRequest;
import com.enigma.pocket.repository.CustomerRepository;
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

    private final String notFoundMessage = "Pocket with id: %s Not Found";

    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public Pocket getPocketById(String id) {
        validatePresent(id);
//        return pocketRepository.findById(id).get();
        return pocketRepository.getPocketById(id);
    }

    @Override
    public Page<Pocket> findAllPocket(Pageable pageable) {
        return pocketRepository.getAllPocket(pageable);
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        pocket.setPocketQty(0.0);
        return pocketRepository.save(pocket);
    }

    @Override
    public List<Pocket> findAllPocketByCustomer(String customerId) {
      Customer customer = customerService.findCustomerById(customerId);
      List<Pocket> pocketByCustomer = customer.getPockets();

      return pocketByCustomer;
    }


  @Override
  public List<Pocket> findPocketCustomerByProduct(GetPocketCustomerByProductRequest request) {
    List<Pocket> pocketCustomerByProduct = pocketRepository.findPocketCustomerByProduct(request.getCustomerId(), request.getProductId());

    return pocketCustomerByProduct;
  }

  @Override
    public Pocket updatePocket(Pocket pocket) {
        validatePresent(pocket.getId());
        return pocketRepository.save(pocket);
    }

    @Override
    public void deletePocketById(String id) {
        validatePresent(id);
//        pocketRepository.deleteById(id);
        pocketRepository.deletePocketById(id);
    }

    @Override
    public void topUp(Pocket pocket, Double qty, Integer purchaseType) {
        if(purchaseType == 0){
            pocket.setPocketQty(pocket.getPocketQty()+qty);
        } else{
            pocket.setPocketQty(pocket.getPocketQty()-qty);
        }
        pocketRepository.save(pocket);
    }

    private void validatePresent(String id) {
        if(! (pocketRepository.findById(id).isPresent())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
