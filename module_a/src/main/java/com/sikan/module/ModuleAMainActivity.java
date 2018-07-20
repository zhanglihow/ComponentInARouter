package com.sikan.module;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Administrator
 *
 * @time 2018/7/20
 */
@Route(path = ARouterManager.AMMainActivity)
public class ModuleAMainActivity extends BaseActivity {

    @Autowired(name = "title")
    public String title;
    @Autowired(name = "message")
    public String message;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ma_activity_main);

        TextView text1 = findViewById(R.id.a_text_1);
        TextView text2 = findViewById(R.id.a_text_2);
        text1.setText(title);
        text2.setText(message);

        findViewById(R.id.a_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterManager.BMMainActivity)
                        .withString("title", "标题")
                        .withString("message", "发出 ModuleA->ModuleB 的消息 ARouter")
                        .navigation();
            }
        });

    }
}
