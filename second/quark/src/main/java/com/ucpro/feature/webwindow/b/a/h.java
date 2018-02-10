package com.ucpro.feature.webwindow.b.a;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.uc.pictureviewer.interfaces.PictureViewerSkinProvider;
import com.uc.pictureviewer.interfaces.PictureViewerSkinProvider.ImageResID;
import com.uc.pictureviewer.interfaces.PictureViewerSkinProvider.TextResID;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class h implements PictureViewerSkinProvider {
    public final Drawable getDrawable(ImageResID imageResID) {
        return null;
    }

    public final String getLocalizedString(TextResID textResID) {
        return null;
    }

    public final boolean isEnableNightColorFilter() {
        if (a.b()) {
            return true;
        }
        return false;
    }

    public final Typeface getTypeface() {
        return null;
    }
}
