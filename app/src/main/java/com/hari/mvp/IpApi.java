package com.hari.mvp;

import com.hari.mvp.IpInfoBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by smartron on 29/1/18.
 */

public interface IpApi {
    String URL = "https://ipapi.co";

    @GET("/json")
    Call<IpInfoBean> getIpInfo();
}
