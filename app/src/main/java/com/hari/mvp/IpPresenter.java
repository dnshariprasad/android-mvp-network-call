package com.hari.mvp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by smartron on 29/1/18.
 */

public class IpPresenter implements IpMvp.Presenter {
    private IpMvp.View mView;
    private IpMvp.Model mModel;

    public IpPresenter(IpMvp.Model model) {
        this.mModel = model;
    }

    @Override
    public void setView(IpMvp.View view) {
        this.mView = view;
    }

    @Override
    public void getIpInfo() {
        mModel.fetchIpInfo().enqueue(new Callback<IpInfoBean>() {
            @Override
            public void onResponse(Call<IpInfoBean> call, Response<IpInfoBean> response) {
                if (response.isSuccessful()) {
                    mView.displayIpInfo(response.body());
                } else
                    mView.displayError(response.message());
            }

            @Override
            public void onFailure(Call<IpInfoBean> call, Throwable t) {
                mView.displayError(t.getMessage());
            }
        });
    }

}