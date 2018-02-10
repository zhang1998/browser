package com.ucpro.feature.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
final class b extends bd<c> implements a {
    n c;
    private Context d;
    private l[] e = l.values();

    public final /* synthetic */ void a(bh bhVar, int i) {
        c cVar = (c) bhVar;
        l lVar = this.e[i];
        cVar.m = i;
        TextView textView = cVar.l;
        if (TextUtils.isEmpty(lVar.i)) {
            lVar.i = a.d(lVar.j);
        }
        textView.setText(lVar.i);
        if (lVar.g == null) {
            lVar.g = a.a(a.a(lVar.h));
        }
        Drawable drawable = lVar.g;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        cVar.l.setCompoundDrawables(null, drawable, null, null);
        cVar.l.setTextColor(a.c("default_maintext_gray"));
    }

    public b(Context context) {
        this.d = context;
    }

    public final int a() {
        return this.e.length;
    }

    public final void b_(int i) {
        if (this.c != null) {
            this.c.a(this.e[i].k);
        }
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        TextView aTTextView = new ATTextView(this.d);
        aTTextView.setLayoutParams(new LayoutParams(-1, -2));
        bh cVar = new c(aTTextView);
        cVar.n = this;
        return cVar;
    }
}
