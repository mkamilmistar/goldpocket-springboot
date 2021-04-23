package com.enigma.pocket.specification;


import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class ProductSpecification {
    public static Specification<Product> findProducts(ProductSearchDto productSearchForm){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();

                if(! (productSearchForm.getProductName()==null || (productSearchForm.getProductName()).equals(""))){
                    final Predicate productNamePredicate = criteriaBuilder.like(root.get("productName"), "%" + productSearchForm.getProductName() + "%");
                    predicates.add(productNamePredicate);
                }

                if(! (productSearchForm.getProductImage()==null || (productSearchForm.getProductImage()).equals(""))){
                    final Predicate productImagePredicate = criteriaBuilder.like(root.get("productImage"), "%" + productSearchForm.getProductImage() + "%");
                    predicates.add(productImagePredicate);
                }
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
