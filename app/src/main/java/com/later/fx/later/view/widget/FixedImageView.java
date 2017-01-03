package com.later.fx.later.view.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 20:41
 */

public class FixedImageView extends ImageView {
    private int mScreenHeight;

    public FixedImageView(Context paramContext) {
        this(paramContext, null);
    }

    public FixedImageView(Context paramContext, AttributeSet paramAttributSet) {
        this(paramContext, paramAttributSet, 0);
    }

    public FixedImageView(Context paramContext, AttributeSet paramAttributSet, int paramInt) {
        super(paramContext, paramAttributSet, paramInt);
        init(paramContext, paramAttributSet);
    }

    private void init(Context paramContext, AttributeSet paramAttributeSet) {
        this.mScreenHeight = getScreenWidthHeight(paramContext)[1];
    }

    private static int[] getScreenWidthHeight(Context paramContext) {
        int[] arrayOfInt = new int[2];
        if (paramContext == null)
            return arrayOfInt;
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity) paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        arrayOfInt[0] = i;
        arrayOfInt[1] = j;
        return arrayOfInt;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i = View.MeasureSpec.getSize(paramInt1);
        View.MeasureSpec.getSize(paramInt1);
        setMeasuredDimension(i, this.mScreenHeight);
    }
}
