package com.UCMobile.Apollo.text.a;

import android.text.Layout.Alignment;
import com.UCMobile.Apollo.text.b;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class a extends b {
    public final long i;
    public final long j;

    /* compiled from: ProGuard */
    final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Alignment.values().length];

        static {
            try {
                a[Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: ProGuard */
    public final class a {
        long a;
        long b;
        CharSequence c;
        Alignment d;
        float e;
        int f;
        int g;
        float h;
        int i;
        float j;

        public a() {
            a();
        }

        public final void a() {
            this.a = 0;
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = Float.MIN_VALUE;
            this.f = SectionHeader.SHT_LOUSER;
            this.g = SectionHeader.SHT_LOUSER;
            this.h = Float.MIN_VALUE;
            this.i = SectionHeader.SHT_LOUSER;
            this.j = Float.MIN_VALUE;
        }
    }

    public a(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private a(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, SectionHeader.SHT_LOUSER, SectionHeader.SHT_LOUSER, Float.MIN_VALUE, SectionHeader.SHT_LOUSER, Float.MIN_VALUE);
    }

    public a(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.i = j;
        this.j = j2;
    }
}
