package com.enigma.pocket.specification;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerSpecification {

    public static Specification<Customer> findCustomers(Customer customerSearchForm){

        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();

                if(! (customerSearchForm.getFirstName()==null || (customerSearchForm.getFirstName().equals(""))) ){
                    final Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%"+ customerSearchForm.getFirstName()+ "%");
                    predicates.add(firstNamePredicate);
                }

                if(! (customerSearchForm.getLastName()==null || (customerSearchForm.getLastName().equals(""))) ){
                    final Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%"+ customerSearchForm.getLastName()+ "%");
                    predicates.add(lastNamePredicate);
                }

                //where ........firstName like..... lastName like .........
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
