package com.taobao.weex.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.List;

/* compiled from: ProGuard */
public final class i {
    public static Drawable a(Context context, Uri uri) {
        Resources resources = context.getResources();
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 1) {
            WXLogUtils.e("Local src format is invalid.");
            return null;
        }
        int identifier = resources.getIdentifier((String) pathSegments.get(0), "drawable", context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(identifier, null);
        }
        return resources.getDrawable(identifier);
    }
}
