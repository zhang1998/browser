package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* compiled from: ProGuard */
final class cq {
    final Context a;
    @Nullable
    bz b;
    private String c;
    private final Map<String, bc> d;
    private final Map<String, Bitmap> e = new HashMap();

    cq(Callback callback, String str, bz bzVar, Map<String, bc> map) {
        Assert.assertNotNull(callback);
        this.c = str;
        if (!(TextUtils.isEmpty(str) || this.c.charAt(this.c.length() - 1) == '/')) {
            this.c += '/';
        }
        if (callback instanceof View) {
            this.a = ((View) callback).getContext();
            this.d = map;
            this.b = bzVar;
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.d = new HashMap();
        this.a = null;
    }

    @Nullable
    final Bitmap a(String str) {
        Bitmap bitmap = (Bitmap) this.e.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        bc bcVar = (bc) this.d.get(str);
        if (bcVar == null) {
            return null;
        }
        if (this.b != null) {
            bitmap = this.b.a(bcVar);
            this.e.put(str, bitmap);
            return bitmap;
        }
        try {
            if (TextUtils.isEmpty(this.c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            InputStream open = this.a.getAssets().open(this.c + bcVar.b);
            Options options = new Options();
            options.inScaled = true;
            options.inDensity = 160;
            bitmap = BitmapFactory.decodeStream(open, null, options);
            this.e.put(str, bitmap);
            return bitmap;
        } catch (Throwable e) {
            Log.w("LOTTIE", "Unable to open asset.", e);
            return null;
        }
    }

    final void a() {
        Iterator it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!(entry == null || entry.getValue() == null)) {
                ((Bitmap) entry.getValue()).recycle();
            }
            it.remove();
        }
    }
}
