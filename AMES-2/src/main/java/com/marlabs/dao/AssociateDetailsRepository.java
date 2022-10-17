package com.marlabs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marlabs.model.AssociateDetails;
@Repository
public interface AssociateDetailsRepository extends JpaRepository<AssociateDetails, String> {

}
