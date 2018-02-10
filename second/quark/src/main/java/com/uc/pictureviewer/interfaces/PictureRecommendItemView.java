package com.uc.pictureviewer.interfaces;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class PictureRecommendItemView extends FrameLayout {

    @Api
    /* compiled from: ProGuard */
    public class Config {
        public int pictureHeight = 90;
        public int pictureWidth = 180;
        public int viewHeight = 137;
        public int viewWidth = 180;
    }

    public abstract ViewGroup getPictureContainer();

    public abstract PictureInfo getPictureInfo();

    public abstract void releaseResources();

    public abstract void setPictureInfo(PictureInfo pictureInfo);

    public abstract void setTypeface(Typeface typeface);

    public PictureRecommendItemView(Context context) {
        super(context);
    }
}
