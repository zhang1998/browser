package com.uc.weex.component.f;

import android.content.Context;
import com.taobao.weex.ui.view.l;

/* compiled from: ProGuard */
public final class c extends l {
    private b b;
    private int c;
    private a d;

    public c(Context context, a aVar) {
        super(context);
        this.d = aVar;
    }

    public final void setHeaderListener(b bVar) {
        this.b = bVar;
    }

    public final b getHeaderListener() {
        return this.b;
    }

    public final void setHeaderHeight(int i) {
        this.c = i;
    }

    public final int getHeaderHeight() {
        return this.c;
    }

    public final int getMaxPullDown() {
        return this.d.b;
    }

    public final int getMinHeight() {
        return this.d.a;
    }

    public final int getMinForRefresh() {
        return this.d.c;
    }
}
