package com.ucpro.ui.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public class o extends u {
    private LinearLayout a;

    public o(Context context) {
        super(context);
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
        setCancelable(f());
        setCanceledOnTouchOutside(g());
    }

    public boolean f() {
        return true;
    }

    public boolean g() {
        return true;
    }

    public final h b() {
        return b(t, u);
    }

    public final h b(String str, String str2) {
        a((CharSequence) str2, d).d().a((CharSequence) str, c);
        b(a.c("dialog_yes_button_default_color"));
        return this;
    }

    public final h c() {
        CharSequence charSequence = t;
        a(charSequence, c).d().a(u, d);
        b(a.c("dialog_yes_button_default_color"));
        return this;
    }

    public final h a(CharSequence charSequence, int i) {
        a(charSequence, i, null);
        return this;
    }

    public final h a(CharSequence charSequence, int i, LinearLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = this.n;
        }
        View iVar = new i(this, this.h);
        iVar.setId(i);
        iVar.setText(charSequence);
        iVar.setTextSize(0, (float) p);
        iVar.setOnClickListener(this);
        this.j.add(iVar);
        iVar.setMinimumHeight(o);
        iVar.setPadding(this.q, this.q, this.q, this.q);
        this.a.addView(iVar, layoutParams);
        return this;
    }

    public final h a(View view) {
        return a(view, new LinearLayout.LayoutParams(-1, -2));
    }

    public final h a(View view, LinearLayout.LayoutParams layoutParams) {
        this.a.addView(view, layoutParams);
        return this;
    }

    public final h d() {
        a(new View(this.h), this.s);
        return this;
    }

    public final i i() {
        View findViewById = findViewById(c);
        if (findViewById == null || !(findViewById instanceof i)) {
            return null;
        }
        return (i) findViewById;
    }

    public final i j() {
        View findViewById = findViewById(d);
        if (findViewById == null || !(findViewById instanceof i)) {
            return null;
        }
        return (i) findViewById;
    }

    public final h a(int i) {
        if (i == 1) {
            b(a.c("dialog_yes_button_warning_color"));
        }
        return this;
    }

    public final h b(int i) {
        i i2 = i();
        if (i2 != null) {
            i2.setTextColor(i);
        }
        return this;
    }

    public final h a(int i, CharSequence charSequence) {
        return a(i, charSequence, null);
    }

    public final h a(int i, CharSequence charSequence, LinearLayout.LayoutParams layoutParams) {
        View bVar = new b(this, getContext(), true);
        bVar.setId(i);
        if (!TextUtils.isEmpty(charSequence)) {
            bVar.setHint(charSequence);
        }
        LinearLayout linearLayout = this.a;
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(a.c((int) R.dimen.common_dialog_margin_left), 0, a.c((int) R.dimen.common_dialog_margin_left), 0);
            layoutParams.gravity = 16;
        }
        linearLayout.addView(bVar, layoutParams);
        return this;
    }

    public View findViewById(int i) {
        return this.i.findViewById(i);
    }

    public final void e() {
        m.a(2, new e(this), 80);
    }

    public final h a(CharSequence charSequence, LinearLayout.LayoutParams layoutParams) {
        View textView = new TextView(this.h);
        textView.setText(charSequence);
        textView.setTextSize(0, (float) r);
        this.j.add(new v(this, textView, "dialog_text_color"));
        this.a.addView(textView, layoutParams);
        return this;
    }

    public final h h() {
        this.a = new LinearLayout(this.h);
        this.a.setGravity(16);
        this.i.addView(this.a, this.m);
        return this;
    }
}
