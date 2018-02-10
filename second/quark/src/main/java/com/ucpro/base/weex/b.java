package com.ucpro.base.weex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.taobao.weex.a.k;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b implements k {
    private final Context a;

    public b(Context context) {
        this.a = context;
        try {
            com.bumptech.glide.f.a.k.e();
        } catch (Exception e) {
        }
    }

    static void a(Drawable drawable, ImageView imageView, com.taobao.weex.common.k kVar) {
        int intrinsicWidth;
        int intrinsicHeight;
        boolean z = false;
        if (drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (kVar.e != null) {
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                z = true;
            }
            Map hashMap = new HashMap(2);
            hashMap.put("naturalWidth", Integer.valueOf(intrinsicWidth));
            hashMap.put("naturalHeight", Integer.valueOf(intrinsicHeight));
            kVar.e.a(imageView, z, hashMap);
        }
    }

    public final void a(String str, ImageView imageView, int i, com.taobao.weex.common.k kVar) {
        if (TextUtils.isEmpty(str)) {
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
        } else if (str.startsWith("localResImage://") || str.startsWith("localResImageNihgt://")) {
            Drawable a = a.a(str.substring(str.indexOf("://") + 3));
            a(a, imageView, kVar);
            if (imageView != null) {
                a.a(imageView);
                imageView.setImageDrawable(a);
            }
        } else {
            m.a(2, new k(this, str, imageView, i, kVar));
        }
    }
}
