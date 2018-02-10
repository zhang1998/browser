package com.ucpro.feature.webwindow.b.a.a;

import com.ucpro.feature.webwindow.b.m;

/* compiled from: ProGuard */
final class c implements m {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a(byte[] bArr) {
        this.a.didFinishLoadingPictureData(true, bArr.length, bArr);
    }

    public final void a() {
        this.a.didFinishLoadingPictureData(false, 0, null);
    }
}
