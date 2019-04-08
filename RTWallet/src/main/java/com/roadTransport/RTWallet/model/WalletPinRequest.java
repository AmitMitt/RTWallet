package com.roadTransport.RTWallet.model;

public class WalletPinRequest {

    private long currentPin;
    private long newPin;
    private long confirmPin;
    private long walletId;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getCurrentPin() {
        return currentPin;
    }

    public void setCurrentPin(long currentPin) {
        this.currentPin = currentPin;
    }

    public long getNewPin() {
        return newPin;
    }

    public void setNewPin(long newPin) {
        this.newPin = newPin;
    }

    public long getConfirmPin() {
        return confirmPin;
    }

    public void setConfirmPin(long confirmPin) {
        this.confirmPin = confirmPin;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "WalletPinRequest{" +
                "currentPin=" + currentPin +
                ", newPin=" + newPin +
                ", confirmPin=" + confirmPin +
                ", walletId=" + walletId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
