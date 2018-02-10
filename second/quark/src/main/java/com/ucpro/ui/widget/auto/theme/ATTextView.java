package com.ucpro.ui.widget.auto.theme;

import android.content.Context;
import android.util.AttributeSet;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public class ATTextView extends TextView {
    private String a;

    public ATTextView(Context context) {
        this(context, null, 0);
    }

    public ATTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setTextColorResName(String str) {
        this.a = str;
        a();
    }

    private void a() {
        if (a.b(this.a)) {
            setTextColor(com.ucpro.ui.c.a.c(this.a));
        }
    }
}
