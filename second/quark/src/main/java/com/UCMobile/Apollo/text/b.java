package com.UCMobile.Apollo.text;

import android.text.Layout.Alignment;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public class b {
    public final CharSequence a;
    public final Alignment b;
    public final float c;
    public final int d;
    public final int e;
    public final float f;
    public final int g;
    public final float h;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this(null, null, Float.MIN_VALUE, SectionHeader.SHT_LOUSER, SectionHeader.SHT_LOUSER, Float.MIN_VALUE, SectionHeader.SHT_LOUSER, Float.MIN_VALUE);
    }

    public b(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this.a = charSequence;
        this.b = alignment;
        this.c = f;
        this.d = i;
        this.e = i2;
        this.f = f2;
        this.g = i3;
        this.h = f3;
    }
}
