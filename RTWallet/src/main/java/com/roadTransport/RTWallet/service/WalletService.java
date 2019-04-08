package com.roadTransport.RTWallet.service;

import com.roadTransport.RTWallet.entity.WalletDetails;
import com.roadTransport.RTWallet.model.WalletPinRequest;
import com.roadTransport.RTWallet.model.WalletRequest;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {

    public WalletDetails add (WalletRequest walletRequest) throws Exception;
    public WalletDetails getListByWallet(long walletId, String roleName) throws Exception;
    public WalletDetails update(WalletRequest walletRequest);
    public WalletDetails delete(long walletId, String roleName);
    public WalletDetails updateBalance(WalletRequest walletRequest);
    public WalletDetails getBalance(long walletId,String roleName);
    public WalletDetails updateWalletPin(WalletPinRequest walletRequest) throws Exception;

}
