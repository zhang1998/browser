package com.taobao.weex.ui.component;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: ProGuard */
final class b implements OnEditorActionListener {
    final /* synthetic */ l a;
    private boolean b = true;

    b(l lVar) {
        this.a = lVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        for (OnEditorActionListener onEditorActionListener : this.a.j) {
            if (onEditorActionListener != null) {
                this.b = onEditorActionListener.onEditorAction(textView, i, keyEvent) & this.b;
            }
        }
        return this.b;
    }
}
