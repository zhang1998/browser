package com.ui.edittext;

import android.content.Context;
import android.text.Spannable;
import android.widget.PopupWindow;

/* compiled from: ProGuard */
final class ap extends PopupWindow {
    final /* synthetic */ at a;

    public ap(at atVar, Context context) {
        this.a = atVar;
        super(context, null, 16843635);
    }

    public final void dismiss() {
        super.dismiss();
        this.a.g.getPositionListener().a(this.a);
        ((Spannable) this.a.g.g).removeSpan(this.a.g.P);
        this.a.g.setCursorVisible(this.a.j);
        if (this.a.g.i) {
            this.a.g.getInsertionController().a();
        }
    }
}
