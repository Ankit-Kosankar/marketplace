package com.app.homerepairs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.homerepairs.model.SellerServiceInfo;

@Repository
public interface SellerMasterInfoRepo extends JpaRepository<SellerServiceInfo, Long>
{

}
