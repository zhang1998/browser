package com.ucpro.feature.video.cache.d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class a implements s {
    private File a;
    private OutputStream b = new FileOutputStream(this.a);

    public a(String str) throws IOException {
        this.a = File.createTempFile("NanoHTTPD-", "", new File(str));
    }

    public final void a() throws Exception {
        c.a(this.b);
        this.a.delete();
    }

    public final String b() {
        return this.a.getAbsolutePath();
    }
}
