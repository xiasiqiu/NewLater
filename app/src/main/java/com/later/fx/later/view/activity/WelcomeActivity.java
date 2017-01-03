package com.later.fx.later.view.activity;

import android.Manifest;
import android.os.Bundle;

import com.later.fx.later.R;
import com.later.fx.later.presenter.WelcomeContract;
import com.later.fx.later.presenter.WelcomePresenter;
import com.later.fx.later.view.widget.FixedImageView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
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
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
