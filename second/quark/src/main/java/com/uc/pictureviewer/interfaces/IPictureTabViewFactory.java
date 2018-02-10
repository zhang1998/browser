package com.uc.pictureviewer.interfaces;

import android.content.Context;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IPictureTabViewFactory {
    PictureTabView create(Context context, PictureInfo pictureInfo);
}
