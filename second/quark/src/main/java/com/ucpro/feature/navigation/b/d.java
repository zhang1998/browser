package com.ucpro.feature.navigation.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.uc.util.b;
import com.ucpro.services.f.i;
import java.util.HashMap;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class d extends i {
    String a = "";
    String b = "";
    final /* synthetic */ b c;

    public d(b bVar, String str, String str2) {
        this.c = bVar;
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return SpdyRequest.GET_METHOD;
    }

    public final HashMap<String, String> c() {
        return null;
    }

    public final byte[] d() {
        return new byte[0];
    }

    public final Object a(byte[] bArr) {
        if (bArr != null) {
            try {
                Bitmap a = b.a(bArr);
                Bitmap a2 = b.a(a);
                if (a2 != null) {
                    this.c.a(this.b, new BitmapDrawable(com.ucweb.common.util.d.c(), a2));
                    String a3 = this.c.a(this.b);
                    this.c.a();
                    b.a(a3, a2);
                }
                if (a != null) {
                    a.recycle();
                }
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public final void a(Object obj) {
        if (obj instanceof Boolean) {
            ((Boolean) obj).booleanValue();
        }
        if (this.c.b != null && this.c.b.get() != null) {
            ((c) this.c.b.get()).d();
        }
    }
}
