package com.hari.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IpMvp.View, View.OnClickListener {
    private TextView ip_info_tv;

    private IpPresenter mIpPresenter;
    private IpModel mIpModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIpModel = new IpModel(NetworkHandler.instance());
        mIpPresenter = new IpPresenter(mIpModel);

        ip_info_tv = findViewById(R.id.ip_info_tv);
        findViewById(R.id.get_ip_info_btn).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIpPresenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_ip_info_btn:
                mIpPresenter.getIpInfo();
                break;
        }
    }

    @Override
    public void displayIpInfo(IpInfoBean ipInfoBean) {
        ip_info_tv.setText(ipInfoBean.getCity());
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
