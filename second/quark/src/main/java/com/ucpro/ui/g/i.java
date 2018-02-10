package com.ucpro.ui.g;

import android.content.Context;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.Button;

/* compiled from: ProGuard */
public final class i extends Button implements q {
    final /* synthetic */ u c;
    private int d;

    public i(u uVar, Context context) {
        this.c = uVar;
        super(context);
        this.d = 0;
        this.d = a.c("default_maintext_gray");
        a();
    }

    public final void a() {
        setTextColor(this.d);
        setBackgroundDrawable(a.c());
        getPaint().setFakeBoldText(true);
    }

    public final void setTextColor(int i) {
        this.d = i;
        super.setTextColor(i);
    }
}
