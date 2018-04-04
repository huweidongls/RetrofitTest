package com.a99zan.retrofittest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.a99zan.retrofittest.module.reponse.LoginBean;
import com.a99zan.retrofittest.net.RetrofitHelper;
import com.zhpan.idea.net.common.DefaultObserver;
import com.zhpan.idea.net.common.ProgressUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private EditText et1;
    private EditText et2;
    private Button button;
    private String name;
    private String pwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et1.getText().toString();
                pwd = et2.getText().toString();
                RetrofitHelper.getApiService()
                        .getLoginInfo(name, pwd)
                        .compose(MainActivity.this.<LoginBean>bindToLifecycle())
                        .compose(ProgressUtils.<LoginBean>applyProgressBar(MainActivity.this))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DefaultObserver<LoginBean>() {
                            @Override
                            public void onSuccess(LoginBean response) {
                                showToast(response.getInfo());
                            }
                        });
            }
        });
    }
}
