package com.ucpro.feature.webwindow.b.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.pictureviewer.interfaces.PictureDataLoader;
import com.ucpro.feature.webwindow.b.w;
import com.ucpro.feature.webwindow.e.k;

/* compiled from: ProGuard */
public final class a extends PictureDataLoader {
    public final void loadPictureData(String str, int i, int i2) {
        new StringBuilder("loadPictureData: ").append(str).append(" clipWidth: ").append(i).append(" , clipHeight: ").append(i2);
        if (!TextUtils.isEmpty(str)) {
            w.a(str, i, i2, new c(this));
        }
    }

    public final void savePicture(String str, String str2, String str3, boolean z, ValueCallback<Bundle> valueCallback) {
        k.a(str3, null, (ValueCallback) valueCallback);
    }
}
