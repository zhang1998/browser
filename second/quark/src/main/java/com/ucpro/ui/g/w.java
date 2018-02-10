package com.ucpro.ui.g;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.i;

/* compiled from: ProGuard */
public final class w extends LinearLayout implements q {
    final /* synthetic */ u a;

    public w(u uVar, Context context) {
        this.a = uVar;
        super(context);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public final void a() {
        setBackgroundDrawable(new i(a.c((int) R.dimen.mainmenu_bg_radius), a.c("main_menu_content_bg_color")));
    }
}
