package com.ucpro.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.quark.browser.R;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class Button extends android.widget.Button {
    private static Typeface c;
    protected String a;
    protected String b;
    private boolean d = true;
    private boolean e = false;

    public static void setApplicationTypeface(Typeface typeface) {
        c = typeface;
    }

    public Button(Context context) {
        super(context);
        a();
    }

    public Button(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public Button(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public Button(Context context, boolean z) {
        super(context, null, 0);
        setGravity(17);
        if (z) {
            a();
        }
    }

    private void a() {
        setBackgroundDrawableName("button_bg_selector.xml");
        setTextColorName("button_text_color_selector.xml");
        setTextSize(0, getResources().getDimension(R.dimen.common_button_text_size));
        setBackgroundDrawable(a.a(this.a));
        ColorStateList d = a.d(this.b);
        if (d != null) {
            setTextColor(d);
        }
        c();
        b();
    }

    private void b() {
        if (!this.e && this.d) {
            f.a();
            int i = j.j;
            this.e = true;
        }
    }

    private void c() {
        if (this.d) {
            setTypeface(c);
        } else {
            setTypeface(null);
        }
    }

    public void setEnableApplicationTypeface(boolean z) {
        this.d = z;
        if (this.d) {
            b();
        } else if (this.e) {
            f.a();
            int i = j.j;
            this.e = false;
        }
        c();
    }

    public void setBackgroundDrawableName(String str) {
        if (str != null && str.length() > 0) {
            this.a = str;
        }
    }

    public void setTextColorName(String str) {
        if (str != null && str.length() > 0) {
            this.b = str;
        }
    }
}
