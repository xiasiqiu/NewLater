package com.later.fx.later.util;

import com.later.fx.later.model.util.HttpUtils;
import com.orhanobut.logger.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 21:17
 */

public class OkHttpImageDownloader {
    public static void download(String url) {
        final Request request = new Request.Builder().url(url).build();
        HttpUtils.client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.d(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FileUtil.createSdDir();
                String url = response.request().url().toString();
                int index = url.lastIndexOf("/");
                String pictureName = url.substring(index + 1);
                if (FileUtil.isFileExist(pictureName)) {
                    return;
                }
                Logger.i("pictureName" + pictureName);
                FileOutputStream fos = new FileOutputStream(FileUtil.createFile(pictureName));
                InputStream is = response.body().byteStream();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                fos.flush();
                is.close();
                fos.close();
            }
        });
    }
}
