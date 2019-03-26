package com.roadTransport.RTWallet.serviceImpl;

import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.WalletRequest;
import com.roadTransport.RTWallet.repository.WalletRepository;
import com.roadTransport.RTWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletDetails add(WalletRequest walletRequest) throws Exception {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());
       if (walletDetails != null){
           throw new Exception("Wallet Already Exist.");
       }

       WalletDetails walletDetails1 = new WalletDetails();
       walletDetails1.setBalance(walletRequest.getBalance());
       walletDetails1.setCreatedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
       walletDetails1.setOwnerName(walletRequest.getOwnerName());
       walletDetails1.setWalletId(walletRequest.getWalletId());
       walletDetails1.setWalletPin(walletRequest.getWalletPin());

       walletRepository.saveAndFlush(walletDetails1);
        return walletDetails1;
    }

    @Override
    public WalletDetails getListByWallet(long walletId) throws Exception {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId);
        return walletDetails;
    }

    @Override
    public WalletDetails update(WalletRequest walletRequest) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());

        walletDetails.setBalance(walletRequest.getBalance());
        walletDetails.setModifiedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        walletDetails.setOwnerName(walletRequest.getOwnerName());
        walletDetails.setWalletId(walletRequest.getWalletId());
        walletDetails.setWalletPin(walletRequest.getWalletPin());
        walletRepository.saveAndFlush(walletDetails);

        return walletDetails;
    }

    @Override
    public WalletDetails delete(long walletId) {
        WalletDetails walletDetails = walletRepository.findByWallet(walletId);
        walletRepository.delete(walletDetails);
        return null;
    }

    @Override
    public WalletDetails updateBalance(WalletRequest walletRequest) {

       WalletDetails walletDetails = walletRepository.findByWallet(walletRequest.getWalletId());
       walletDetails.setBalance(walletDetails.getBalance());
       walletRepository.saveAndFlush(walletDetails);
        return walletDetails;
    }

    @Override
    public WalletDetails getBalance(long walletId) {

        WalletDetails walletDetails = walletRepository.findByWallet(walletId);

        return walletDetails;
    }

}
