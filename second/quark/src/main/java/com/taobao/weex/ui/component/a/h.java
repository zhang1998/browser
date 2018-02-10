package com.taobao.weex.ui.component.a;

import android.mini.support.annotation.Nullable;
import android.widget.TextView;
import com.taobao.weex.b.b.e;
import com.taobao.weex.ui.component.l;

/* compiled from: ProGuard */
public final class h implements e {
    final /* synthetic */ TextView a;
    final /* synthetic */ l b;

    public h(TextView textView, l lVar) {
        this.a = textView;
        this.b = lVar;
    }

    public final void a(boolean z, @Nullable String str) {
        if (z) {
            this.a.setText(str);
            this.b.a(str);
        }
    }
}
