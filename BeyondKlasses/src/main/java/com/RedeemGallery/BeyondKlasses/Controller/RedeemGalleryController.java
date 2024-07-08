package com.RedeemGallery.BeyondKlasses.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RedeemGallery.BeyondKlasses.Model.RedeemGallery;
import com.RedeemGallery.BeyondKlasses.Services.RedeemGalleryService;

@RestController
@RequestMapping("/winnergallery")
public class RedeemGalleryController {
    @Autowired
    private RedeemGalleryService redeemGalleryService;

    @GetMapping
    public List<RedeemGallery> getAllWinnerGalleries(){
        return redeemGalleryService.getAllWinnerGalleries();
    }
    @PostMapping
    public RedeemGallery createWinnerGallery(@RequestBody RedeemGallery winnerGallery){
        return redeemGalleryService.createRedeemGallery(winnerGallery);
    }
    @GetMapping("/{id}")
    public Optional <RedeemGallery> getWinnerGalleryById(@PathVariable Long id ){
        return redeemGalleryService.getRedeemGalleryById(id);
    }
    @PutMapping("/{id}")
    public RedeemGallery updateWinnerGalleryById(@PathVariable Long id , @RequestBody RedeemGallery winnerGallery){
        return redeemGalleryService.updateRedeemGalleryById(id,winnerGallery);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteWinnerGalleryById(@PathVariable Long id){
        try {
        	redeemGalleryService.deleteRedeemGalleryById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        
        @GetMapping("/get-all-redeem-gallery")
    	public Page<List<Map>> getAllWinnersVideos(
    			@RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size,
                @RequestParam(defaultValue = "id") String sortBy,
                @RequestParam(defaultValue = "desc") String sortOrder) 
    {
    		Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
            Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
            return redeemGalleryService.getRedeemGalleryAscPage(pageable);
    }

        

        
 }
