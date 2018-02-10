package com.uc.pictureviewer.interfaces;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface PictureViewerSkinProvider {

    @Api
    /* compiled from: ProGuard */
    public enum ImageResID {
        IDR_MAIN_PICTURE_LOADING,
        IDR_NAV_PICTURE_ERROR,
        IDR_NAV_PICTURE_LOADING,
        IDR_NAV_ITEM_LIST_LOADING,
        IDR_THUMBNAILS_FAIL,
        IDR_THUMBNAILS_LOADING,
        IDR_THUMBNAILS_AD,
        IDR_MAIN_PICTURE_ERROR
    }

    @Api
    /* compiled from: ProGuard */
    public enum TextResID {
        IDS_LOADING_INDICATION,
        IDS_MAIN_PICTURE_ERROR,
        IDS_MAIN_PICTURE_REFRESH,
        IDS_LOAD_FINISH
    }

    Drawable getDrawable(ImageResID imageResID);

    String getLocalizedString(TextResID textResID);

    Typeface getTypeface();

    boolean isEnableNightColorFilter();
}
