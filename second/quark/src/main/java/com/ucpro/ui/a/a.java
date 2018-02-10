package com.ucpro.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class a extends RelativeLayout {
    private LottieAnimationView a;
    private TextView b;
    private LinearLayout c;
    private String d;
    private String e;
    private String f;

    public a(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = "";
        this.e = "";
        this.f = "";
        this.c = new LinearLayout(getContext());
        this.c.setOrientation(1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.c, layoutParams);
    }

    public final void a(String str, String str2, String str3) {
        if (this.a == null) {
            this.a = new LottieAnimationView(getContext());
            this.a.a(true);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            this.c.addView(this.a, layoutParams);
        }
        if (!this.d.equals(str)) {
            try {
                this.a.a(new JSONObject(com.ucweb.common.util.k.a.a(str, getContext())), 480);
            } catch (Throwable th) {
            }
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.a.b();
            a();
        }
    }

    public final void a() {
        setBackgroundColor(com.ucpro.ui.c.a.c("default_background_white"));
        if (this.a != null) {
            if (com.ucpro.ui.c.a.b() && !TextUtils.isEmpty(this.f)) {
                this.a.setImageAssetsFolder(this.f);
            } else if (!TextUtils.isEmpty(this.e)) {
                this.a.setImageAssetsFolder(this.e);
            }
        }
        if (this.b != null) {
            this.b.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        }
    }

    public final void setText(String str) {
        if (this.a != null) {
            if (this.b == null) {
                this.b = new TextView(getContext());
                this.b.setText(str);
                this.b.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.empty_error_anim_page_textsize));
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.empty_error_anim_page_text_margin_top);
                this.c.addView(this.b, layoutParams);
            }
            a();
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public final boolean b() {
        return !TextUtils.isEmpty(this.d);
    }
}
