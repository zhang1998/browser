package com.bumptech.glide.b.c;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: ProGuard */
public final class bb implements ar<Integer, ParcelFileDescriptor> {
    private final Resources a;

    public bb(Resources resources) {
        this.a = resources;
    }

    public final aq<Integer, ParcelFileDescriptor> a(ba baVar) {
        return new bd(this.a, baVar.a(Uri.class, ParcelFileDescriptor.class));
    }
}
