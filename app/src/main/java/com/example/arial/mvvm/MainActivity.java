package com.example.arial.mvvm;

import android.os.Bundle;
import android.view.View;

import com.arialyy.frame.core.AbsActivity;
import com.example.arial.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AbsActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_dialog:
                ShowDialog dialog = new ShowDialog(this);
                dialog.show(getSupportFragmentManager(), "testDialog");
                break;
            case R.id.get_ip_info:
                getModule(IPModule.class).getIpInfo();
                break;
        }
    }

    @Override
    protected void dataCallback(int resultCode, Object data) {
        if (resultCode == 1) {
            getBinding().setStr(data + "");
        } else if (resultCode == 2) {
            getBinding().setDialogStr(data + "");
        }
    }
}
