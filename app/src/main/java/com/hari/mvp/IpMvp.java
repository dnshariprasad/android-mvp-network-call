package com.hari.mvp;

import retrofit2.Call;

/**
 * Created by smartron on 29/1/18.
 */

public class IpMvp {
    public interface View {
        void displayIpInfo(IpInfoBean ipInfoBean);
        void displayError(String message);
    }

    public interface Presenter {
        void getIpInfo();
        void setView(View view);
    }

    public interface Model {
        Call<IpInfoBean> fetchIpInfo();
    }
}
