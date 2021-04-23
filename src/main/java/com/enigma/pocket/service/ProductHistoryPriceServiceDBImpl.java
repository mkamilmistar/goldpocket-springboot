package com.enigma.pocket.service;

import com.enigma.crudProduct.dto.HistoryProductSearchDto;
import com.enigma.crudProduct.entity.HistoryProduct;
import com.enigma.crudProduct.repository.HistoryProductRepository;
import com.enigma.crudProduct.specification.HistoryProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@Service
public class HistoryProductServiceDBImpl implements HistoryProductService{

    private final String notFoundMessage = "History Product with id: %s Not Found";

    @Autowired
    HistoryProductRepository historyProductRepository;

    @Override
    public HistoryProduct getHistoryProductById(String id) {
        validatePresent(id);
        HistoryProduct historyProduct = historyProductRepository.findById(id).get();
        return historyProduct;
    }

    @Override
    public Page<HistoryProduct> findAllHistoryProduct(HistoryProductSearchDto historyProductSearchForm, Pageable pageable) {
        Specification<HistoryProduct> specification = HistoryProductSpecification.findHistoryProducts(historyProductSearchForm);
        return historyProductRepository.findAll(specification, pageable);
    }

    @Override
    public HistoryProduct createNewHistoryProduct(HistoryProduct historyProduct) {
        historyProduct.setHistoryDate(new Timestamp(System.currentTimeMillis()));
        return historyProductRepository.save(historyProduct);
    }

    @Override
    public HistoryProduct updateHistoryProduct(HistoryProduct historyProduct) {
        validatePresent(historyProduct.getId());
        return historyProductRepository.save(historyProduct);
    }

    @Override
    public void removeHistoryProductById(String id) {
        validatePresent(id);
        historyProductRepository.deleteById(id);
    }

    private void validatePresent(String id) {
        if(!historyProductRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
