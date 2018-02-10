package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.util.e;
import java.io.IOException;

/* compiled from: ProGuard */
final class ae implements q {
    private final ad a;
    private final e b;

    public ae(ad adVar, e eVar) {
        this.a = adVar;
        this.b = eVar;
    }

    public final void a() {
        this.a.a();
    }

    public final void a(g gVar, Bitmap bitmap) throws IOException {
        IOException iOException = this.b.a;
        if (iOException != null) {
            if (bitmap != null) {
                gVar.a(bitmap);
            }
            throw iOException;
        }
    }
}
