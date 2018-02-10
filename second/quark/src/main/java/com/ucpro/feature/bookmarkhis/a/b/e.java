package com.ucpro.feature.bookmarkhis.a.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.ucpro.ui.widget.u;
import com.ucweb.common.util.a.a;

/* compiled from: ProGuard */
final class e extends u {
    final /* synthetic */ f b;

    public e(f fVar, Context context) {
        this.b = fVar;
        super(context);
        setLayoutParams(fVar.e);
        setDivider(fVar.d);
        setChildDivider(fVar.d);
        setDividerHeight(1);
        setVerticalFadingEdgeEnabled(false);
        a.a((View) this, com.ucpro.ui.c.a.a("scrollbar_thumb.9.png"));
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        setCacheColorHint(0);
    }
}
