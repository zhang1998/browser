package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;

/* compiled from: ProGuard */
public class CheckBox extends android.widget.CheckBox {
    private static Typeface a;
    private boolean b = true;
    private boolean c = false;

    public static void setApplicationTypeface(Typeface typeface) {
        a = typeface;
    }

    public CheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        c();
        b();
    }

    private void b() {
        if (!this.c && this.b) {
            f.a();
            int i = j.j;
            this.c = true;
        }
    }

    private void c() {
        if (this.b) {
            setTypeface(a);
        } else {
            setTypeface(null);
        }
    }

    public void setEnableApplicationTypeface(boolean z) {
        this.b = z;
        if (this.b) {
            b();
        } else if (this.c) {
            f.a();
            int i = j.j;
            this.c = false;
        }
        c();
    }
}
