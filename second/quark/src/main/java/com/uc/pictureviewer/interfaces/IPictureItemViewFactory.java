package com.uc.pictureviewer.interfaces;

import android.content.Context;
import com.uc.pictureviewer.interfaces.PictureRecommendItemView.Config;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IPictureItemViewFactory {
    PictureRecommendItemView create(Context context, Config config, PictureInfo pictureInfo);
}
