package com.roadTransport.RTWallet.controller;

import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.WalletPinRequest;
import com.roadTransport.RTWallet.model.WalletRequest;
import com.roadTransport.RTWallet.model.WalletResponse;
import com.roadTransport.RTWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/add")
    public ResponseEntity<WalletResponse> add(@RequestBody WalletRequest walletRequest) throws Exception {

        WalletDetails walletDetails = walletService.add(walletRequest);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Wallet Created Successfully.");
        walletResponse.setBalance(walletDetails.getBalance());
        return ResponseEntity.ok(walletResponse);
    }

    @CachePut(value = "WalletDetails", key = "#walletId")
    @PutMapping("/update")
    public ResponseEntity<WalletResponse> update (@RequestBody WalletRequest walletRequest) {

        WalletDetails walletDetails = walletService.update(walletRequest);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Wallet Successfully Updated.");
        walletResponse.setBalance(walletDetails.getBalance());
        return ResponseEntity.ok(walletResponse);
    }

    @CacheEvict(value = "WalletDetails")
    @DeleteMapping("delete/{walletId}/{roleName}")
    public ResponseEntity<WalletResponse> delete(@PathVariable("walletId") long walletId,@PathVariable("roleName") String roleName){

        walletService.delete(walletId,roleName);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Successfully Deleted.");
        return ResponseEntity.ok(walletResponse);
    }

    @Cacheable(value = "WalletDetails", key = "#walletId")
    @GetMapping("get/{walletId}/{roleName}")
    public ResponseEntity<WalletDetails> getData(@PathVariable("walletId") long walletId,@PathVariable("roleName")  String roleName) throws Exception {

        WalletDetails walletDetails = walletService.getListByWallet(walletId,roleName);
        return ResponseEntity.ok(walletDetails);
    }

    @CachePut(value = "WalletDetails", key = "#walletId")
    @PutMapping("updateBalance/{walletId}")
    public ResponseEntity<WalletResponse> updateBalance(@RequestBody WalletRequest walletRequest){

       WalletDetails walletDetails =  walletService.updateBalance(walletRequest);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Balance Update Successfully.");
        walletResponse.setBalance(walletDetails.getBalance());
        return ResponseEntity.ok(walletResponse);
    }

    @Cacheable(value = "WalletDetails", key = "#walletId")
    @GetMapping("getBalance/{walletId}/{roleName}")
    public ResponseEntity<WalletResponse> getBalance(@PathVariable("walletId") long walletId,@PathVariable("roleName") String roleName){

        WalletDetails walletDetails = walletService.getBalance(walletId,roleName);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setBalance(walletDetails.getBalance());
        return ResponseEntity.ok(walletResponse);
    }

    @CachePut(value = "WalletDetails", key = "#walletId")
    @PutMapping("updateWalletPin")
    public ResponseEntity<WalletResponse> updatePin(@RequestBody WalletPinRequest walletRequest) throws Exception {

        WalletDetails walletDetails = walletService.updateWalletPin(walletRequest);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Pin Change Successfully.");
        return ResponseEntity.ok(walletResponse);
    }

}
