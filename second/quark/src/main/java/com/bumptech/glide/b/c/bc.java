package com.bumptech.glide.b.c;

import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class bc implements ar<Integer, InputStream> {
    private final Resources a;

    public bc(Resources resources) {
        this.a = resources;
    }

    public final aq<Integer, InputStream> a(ba baVar) {
        return new bd(this.a, baVar.a(Uri.class, InputStream.class));
    }
}
