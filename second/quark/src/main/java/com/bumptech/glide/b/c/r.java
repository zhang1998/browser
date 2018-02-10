package com.bumptech.glide.b.c;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class r implements p<InputStream> {
    final /* synthetic */ s a;

    r(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ Object a(String str) throws IllegalArgumentException {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Missing comma in data URL.");
            } else if (str.substring(0, indexOf).endsWith(";base64")) {
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            } else {
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
    }

    public final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public final Class<InputStream> a() {
        return InputStream.class;
    }
}
