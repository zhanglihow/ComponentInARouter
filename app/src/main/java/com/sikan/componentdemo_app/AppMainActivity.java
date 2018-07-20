package com.sikan.componentdemo_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sikan.module.ARouterManager;
import com.sikan.module.BaseActivity;

/**
 * Created by Administrator
 *
 * @time 2018/7/20
 */

public class AppMainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("title", "标题");
                bundle.putString("message", "发出 App->moduleA 的消息 ARouter");
                ARouter.getInstance().build(ARouterManager.AMMainActivity)
                        .with(bundle)
                        .navigation(AppMainActivity.this, new NavCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("NavCallback onFound",postcard.toString());
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("NavCallback onLost",postcard.toString());

                            }

                            @Override
                            public  void onArrival(Postcard postcard){
                                Log.e("NavCallback onArrival",postcard.toString());

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("NavCallback onInterrupt",postcard.toString());
                            }
                        });
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("title", "标题");
                bundle.putString("message", "发出 App->moduleB 的消息 ARouter");
                ARouter.getInstance().build(ARouterManager.BMMainActivity)
                        .with(bundle)
                        .navigation();
            }
        });

    }
}
