package com.enigma.pocket.specification;

import com.enigma.pocket.dto.ProductHistoryPriceSearchDto;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class ProductHistoryPriceSpecification {
    public static Specification<ProductHistoryPrice> findHistoryProducts(ProductHistoryPriceSearchDto historyProductSearchForm){
        return new Specification<ProductHistoryPrice>() {
            @Override
            public Predicate toPredicate(Root<ProductHistoryPrice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();

                if(! (historyProductSearchForm.getHistoryDate()==null || (historyProductSearchForm.getHistoryDate()).equals(""))){
                    final Predicate priceBuyPredicate = criteriaBuilder.equal(root.get("priceBuy"), historyProductSearchForm.getPriceBuy());
                    predicates.add(priceBuyPredicate);
                }
                if(! (historyProductSearchForm.getHistoryDate()==null || (historyProductSearchForm.getHistoryDate()).equals(""))){
                    final Predicate priceSellPredicate = criteriaBuilder.equal(root.get("sellBuy"), historyProductSearchForm.getPriceSell());
                    predicates.add(priceSellPredicate);
                }

                return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[predicates.size()])));
            }
        };
    }
}
