package com.ucpro.feature.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.ui.g.o;
import com.ucpro.ui.scrollview.ScrollViewWithMaxHeight;

/* compiled from: ProGuard */
public class a extends o {
    public LinearLayout a;
    private ScrollViewWithMaxHeight b;

    public a(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(com.ucpro.ui.c.a.b() ? R.layout.base_dialog_night : R.layout.base_dialog_normal, null);
        this.a = (LinearLayout) inflate.findViewById(R.id.base_ll);
        this.b = (ScrollViewWithMaxHeight) inflate.findViewById(R.id.base_sv);
        this.b.setMaxHeight(b.a.g() / 2);
        this.b.setScrollBarStyle(33554432);
        h().a(inflate);
    }
}
