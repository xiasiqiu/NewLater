package com.later.fx.later.view.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.later.fx.later.R;
import com.later.fx.later.app.FXApplication;
import com.later.fx.later.di.components.DaggerWelcomeComponent;
import com.later.fx.later.di.modules.WelcomeModule;
import com.later.fx.later.presenter.WelcomeContract;
import com.later.fx.later.presenter.WelcomePresenter;
import com.later.fx.later.util.AppUtil;
import com.later.fx.later.util.FileUtil;
import com.later.fx.later.view.widget.FixedImageView;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

public class WelcomeActivity extends BaseActivity implements WelcomeContract.View, EasyPermissions.PermissionCallbacks {
    @Bind(R.id.welcome_img)
    FixedImageView fiv_img;
    @Inject
    WelcomePresenter presenter;
    private static final int PERMISSON_REQUESTCODE = 1;

    protected String[] needPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        DaggerWelcomeComponent.builder()
                .netComponent(FXApplication.get(this).getNetComponent())
                .welcomeModule(new WelcomeModule(this))
                .build().inject(this);
        initStatus();
    }

    public void initStatus() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        requestCodePermissions();
    }

    private void requestCodePermissions(){
        if(!EasyPermissions.hasPermissions(this,needPermissions)){
            EasyPermissions.requestPermissions(this,"应用需要这些权限",PERMISSON_REQUESTCODE,needPermissions);
        }else {
            setContentView(R.layout.activity_welcome);
            ButterKnife.bind(this);
            delayWelcome();
            String deviceId= AppUtil.getDeviceId(this);
            presenter.getWelcome(deviceId);
        }
    }

    private void delayWelcome(){
        List<String>picList= FileUtil.getAllAD();
        if(picList.size()>0){
            Random random=new Random();
            int index=random.nextInt(picList.size());
            int imgIndex=PreferenceUtil.
        }
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
            showMissingPermissionDialog();
    }
    private void showMissingPermissionDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("当前应用缺少必要权限，请点击\"设置\"-\"权限\"-打开所需权");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }


    private void startAppSettings(){
        Intent intent=new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:"+getPackageName()));
        startActivity(intent);
    }
}
