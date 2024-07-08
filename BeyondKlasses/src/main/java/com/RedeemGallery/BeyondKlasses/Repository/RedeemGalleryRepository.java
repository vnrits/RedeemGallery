package com.RedeemGallery.BeyondKlasses.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.RedeemGallery.BeyondKlasses.Model.RedeemGallery;

import java.util.List;
import java.util.Map;

@Repository
public interface RedeemGalleryRepository extends JpaRepository<RedeemGallery,Long>,  PagingAndSortingRepository<RedeemGallery, Long> {
	
	 @Query(value = "SELECT * FROM redeemgallery", 
	           countQuery = "SELECT COUNT(*) FROM redeemgallery", 
	           nativeQuery = true)
	 Page<List<Map>> getRedeemGalleryAscPage( Pageable pageable);
	
}


