package com.ucpro.feature.webwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.r;

/* compiled from: ProGuard */
public class ar extends r {
    View a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Drawable g;
    private ImageView h;
    private TextView i;
    private LottieAnimationView j;
    private String k;
    private String l;
    private String m;
    private int n;
    private boolean o;

    public ar(Context context) {
        super(context);
        this.o = true;
    }

    public ar(Context context, String str) {
        this(context, str, null);
    }

    public ar(Context context, String str, String str2) {
        super(context);
        this.o = true;
        setWillNotDraw(false);
        this.h = new ImageView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.h, layoutParams);
        this.c = str;
        this.d = str2;
        this.j = new LottieAnimationView(getContext());
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.j, layoutParams);
        this.j.setVisibility(8);
        this.n = a.c((int) R.dimen.mainmenu_item_icon_tips_size);
        this.a = new View(getContext());
        layoutParams = new FrameLayout.LayoutParams(this.n, this.n);
        layoutParams.gravity = 5;
        addView(this.a, layoutParams);
        this.a.setVisibility(8);
        a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o && this.a != null) {
            this.o = false;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.topMargin = this.h.getTop() - this.a.getMeasuredHeight();
            layoutParams.rightMargin = (getMeasuredWidth() - this.h.getRight()) - this.n;
        }
    }

    public void setText(String str) {
        if (this.i != null) {
            this.i.setText(str);
        }
    }

    public final void a(String str, String str2, String str3, int i) {
        if (this.i == null) {
            this.i = new TextView(getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.i, layoutParams);
        }
        this.i.setTextSize(0, (float) i);
        this.i.setTypeface(null, 1);
        this.e = str2;
        this.f = str3;
        this.i.setText(str);
        c();
    }

    public String getText() {
        if (this.i != null) {
            return this.i.getText().toString();
        }
        return "";
    }

    private void c() {
        if (this.i == null) {
            return;
        }
        if (this.f == null || !a.a() || a.d()) {
            this.i.setTextColor(a.c(this.e));
        } else {
            this.i.setTextColor(a.c(this.f));
        }
    }

    public void setItemId(int i) {
        this.b = i;
    }

    public int getItemID() {
        return this.b;
    }

    public void a() {
        if (this.d == null || !a.a() || a.d()) {
            this.g = a.a(this.c);
        } else {
            this.g = a.a(this.d);
        }
        this.h.setImageDrawable(this.g);
        c();
        setBackgroundDrawable(a.c());
        this.j.c();
        if (!TextUtils.isEmpty(this.k)) {
            this.j.setAnimation(this.k);
        }
        if (a.b()) {
            if (!TextUtils.isEmpty(this.m)) {
                this.j.setImageAssetsFolder(this.m);
            } else if (!TextUtils.isEmpty(this.l)) {
                this.j.setImageAssetsFolder(this.l);
            }
        } else if (!TextUtils.isEmpty(this.l)) {
            this.j.setImageAssetsFolder(this.l);
        }
        if (this.a != null) {
            this.a.setBackgroundDrawable(getBlueDotDrawable());
        }
    }

    public void setIconName(String str) {
        this.c = str;
    }

    public void setDarkIconName(String str) {
        this.d = str;
    }

    public final void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(this.k)) {
            this.k = str;
            this.l = str2;
            this.m = str3;
            this.j.setAnimation(this.k);
            this.j.a(true);
            a();
        }
        if (this.j.getVisibility() == 8) {
            this.j.setVisibility(0);
            this.j.b();
            this.h.setVisibility(8);
        }
    }

    public final void b() {
        if (this.j.getVisibility() == 0) {
            this.j.setVisibility(8);
            this.j.a.d();
            this.h.setVisibility(0);
        }
    }

    private Drawable getBlueDotDrawable() {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(this.n);
        shapeDrawable.setIntrinsicWidth(this.n);
        shapeDrawable.getPaint().setColor(a.c("main_menu_icon_tips_color"));
        return shapeDrawable;
    }
}
