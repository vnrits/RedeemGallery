package com.RedeemGallery.BeyondKlasses.Services;


import com.RedeemGallery.BeyondKlasses.Model.RedeemGallery;
import com.RedeemGallery.BeyondKlasses.Repository.RedeemGalleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RedeemGalleryService {
    @Autowired
    private RedeemGalleryRepository redeemGalleryRepository;

    public List<RedeemGallery> getAllWinnerGalleries() {
        return redeemGalleryRepository.findAll();
    }

    public RedeemGallery createRedeemGallery(RedeemGallery winnerGallery) {
        return redeemGalleryRepository.save(winnerGallery);
    }

    public Optional<RedeemGallery> getRedeemGalleryById(Long id) {
        return redeemGalleryRepository.findById(id);
    }
    
    public RedeemGallery updateRedeemGalleryById(Long id, RedeemGallery winnerGallery) {
        winnerGallery.setId(id);
        return redeemGalleryRepository.save(winnerGallery);

    }

    public void deleteRedeemGalleryById(Long id) {
        Optional<RedeemGallery> redeemGallery = redeemGalleryRepository.findById(id);
        if(redeemGallery .isPresent()){
            redeemGalleryRepository.deleteById(id);
        } else {
            throw new RuntimeException("winnerGallery not found with id " + id);
        }

        }
    
    public  Page<List<Map>> getRedeemGalleryAscPage(Pageable pageable) {
    	
    	return redeemGalleryRepository.getRedeemGalleryAscPage( pageable);
    }

    
    }



