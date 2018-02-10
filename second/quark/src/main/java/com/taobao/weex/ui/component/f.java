package com.taobao.weex.ui.component;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.taobao.weex.c.o;

/* compiled from: ProGuard */
final class f implements OnEditorActionListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ l b;

    f(l lVar, TextView textView) {
        this.b = lVar;
        this.a = textView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        o domObject = this.b.getDomObject();
        if (domObject == null || i != this.b.h) {
            return false;
        }
        CharSequence text = this.a.getText();
        if (text == null) {
            text = "";
        }
        if (!text.toString().equals(this.b.g)) {
            this.b.a(domObject.c_().contains("change") ? "change" : null, text.toString());
            this.b.g = this.a.getText().toString();
        }
        if (this.b.getParent() != null) {
            this.b.getParent().i();
        }
        this.b.c();
        return true;
    }
}
