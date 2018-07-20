package com.sikan.module;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
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
@Route(path = ARouterManager.BMMainActivity)
public class ModuleBMianActivity extends BaseActivity {

    @Autowired(name = "title")
    String title;
    @Autowired(name = "message")
    String messageStr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mb_activity_main);

        final TextView message = findViewById(R.id.message);
        TextView text_1 = findViewById(R.id.b_text_1);
        TextView text_2 = findViewById(R.id.b_text_2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    message.setText(R.string.title_home);
                } else if (id == R.id.navigation_dashboard) {
                    message.setText(R.string.title_dashboard);
                } else if (id == R.id.navigation_notifications) {
                    message.setText(R.string.title_notifications);
                }
                return false;
            }
        });

        text_1.setText(title);
        text_2.setText(messageStr);

        findViewById(R.id.b_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterManager.AMMainActivity)
                        .withString("title", "标题")
                        .withString("message", "发出 ModuleB->ModuleA 的消息 ARouter")
                        .navigation();
            }
        });
    }
}
