package com.uc.apollo.widget;

import com.uc.apollo.media.widget.a;

/* compiled from: ProGuard */
final class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a(int i) {
        String str = this.a.mLogTag;
    }

    public final void a() {
        String str = this.a.mLogTag;
        if (this.a.g != null) {
            this.a.g.getController().enterFullScreen(false);
        }
        this.a.a();
    }
}
