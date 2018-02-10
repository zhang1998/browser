package com.ucpro.feature.r.b;

import com.uc.encrypt.f;
import com.ucweb.a.b.a;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class b implements a {
    public final byte[] a(byte[] bArr) {
        return f.a(bArr, com.uc.encrypt.a.c);
    }

    public final byte[] b(byte[] bArr) {
        return f.b(bArr, com.uc.encrypt.a.c);
    }

    public final boolean a(File file, byte[] bArr, int i) {
        return com.ucweb.common.util.k.a.a(file, bArr, i);
    }

    public final boolean a(String str, String str2, byte[] bArr, int i) {
        return com.ucweb.common.util.k.a.a(str, str2, bArr, i);
    }

    public final byte[] a(File file) {
        return com.ucweb.common.util.k.a.e(file);
    }

    public final String b(File file) throws IOException {
        return com.ucweb.common.util.k.a.b(file, 4000);
    }
}
