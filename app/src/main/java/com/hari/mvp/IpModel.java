package com.hari.mvp;


import retrofit2.Call;

/**
 * Created by smartron on 29/1/18.
 */

public class IpModel implements IpMvp.Model {
    private NetworkHandler mNetworkHandler;

    public IpModel(NetworkHandler networkHandler) {
        this.mNetworkHandler = networkHandler;
    }

    @Override
    public Call<IpInfoBean> fetchIpInfo() {
        return mNetworkHandler.ipInfoApi().getIpInfo();
    }
}
