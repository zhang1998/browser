package com.taobao.weex.ui.component;

import android.widget.TextView;
import com.taobao.weex.c.o;

/* compiled from: ProGuard */
final class e implements aa {
    final /* synthetic */ TextView a;
    final /* synthetic */ l b;

    e(l lVar, TextView textView) {
        this.b = lVar;
        this.a = textView;
    }

    public final void a(boolean z) {
        o domObject = this.b.getDomObject();
        if (domObject != null) {
            if (z) {
                this.b.g = this.a.getText().toString();
                return;
            }
            CharSequence text = this.a.getText();
            if (text == null) {
                text = "";
            }
            if (!text.toString().equals(this.b.g)) {
                this.b.a(domObject.c_().contains("change") ? "change" : null, text.toString());
                this.b.g = this.a.getText().toString();
            }
        }
    }
}
