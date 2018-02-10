package com.bumptech.glide.b.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class z implements y<InputStream> {
    z() {
    }

    public final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final /* synthetic */ Object a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
