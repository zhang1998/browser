package com.uc.qrcode;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/* compiled from: ProGuard */
public final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ n b;

    public k(n nVar, String str) {
        this.b = nVar;
        this.a = str;
    }

    public final void run() {
        int i = 1;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.a, options);
        options.inJustDecodeBounds = false;
        int i2 = (int) (((float) options.outHeight) / 400.0f);
        if (i2 > 0) {
            i = i2;
        }
        options.inSampleSize = i;
        this.b.b = BitmapFactory.decodeFile(this.a, options);
        if (this.b.b != null) {
            this.b.a = n.a(this.b.b);
            return;
        }
        this.b.a = null;
    }
}
