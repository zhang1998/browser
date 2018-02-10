package com.ucpro.feature.t.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.system.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public class k extends ViewGroup {
    protected int A = 0;
    protected int B = 0;
    protected int C = 0;
    protected int D = 0;
    protected int E = 0;
    protected int F = 0;
    protected int G = 0;
    protected int H = -1;
    public float I;
    public float J;
    public ImageView m = null;
    public TextView n = null;
    public ImageView o = null;
    public b p = null;
    public Bitmap q = null;
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected int u = 0;
    protected int v = 0;
    protected int w = 0;
    protected int x = 0;
    protected int y = 0;
    protected int z = 0;

    public k(Context context, int i) {
        boolean z = false;
        super(context);
        if (i >= 0) {
            z = true;
        }
        c.b(z);
        this.H = i;
        a();
        b();
        c();
    }

    public void a() {
        this.r = a.c((int) R.dimen.multi_window_cardview2_icon_width);
        this.t = a.c((int) R.dimen.multi_window_cardview2_icon_width);
        this.s = a.c((int) R.dimen.multi_window_cardview2_icon_margin_left);
        this.u = a.c((int) R.dimen.multi_window_cardview2_icon_margin_right);
        this.v = a.c((int) R.dimen.multi_window_cardview2_delete_btn_width);
        this.x = a.c((int) R.dimen.multi_window_cardview2_title_textsize);
        this.y = a.c((int) R.dimen.multi_window_cardview_title_text_margin_right);
        this.z = a.c((int) R.dimen.multi_window_header_shadow_height);
        this.B = a.c((int) R.dimen.multi_window_cardview2_margin_top);
        this.C = a.c((int) R.dimen.multi_window_cardview2_margin_bottom);
        this.D = a.c((int) R.dimen.multi_window_cardview_web_shot_marigin_left);
        this.E = a.c((int) R.dimen.multi_window_cardview2_corner_radius);
        this.G = a.c((int) R.dimen.multi_window_cardview2_header_margin_top);
    }

    public void b() {
        this.m = new ImageView(getContext());
        addView(this.m);
        this.n = new TextView(getContext());
        this.n.setTextSize(0, (float) this.x);
        this.n.setGravity(17);
        this.n.setSingleLine();
        this.n.setEllipsize(TruncateAt.END);
        addView(this.n);
        this.o = new ImageView(getContext());
        this.o.setClickable(true);
        this.o.setPadding(this.w, this.w, this.w, this.w);
        addView(this.o);
        this.p = new b(this, getContext());
        addView(this.p);
    }

    public void c() {
        this.n.setTextColor(a.c("default_maintext_white"));
        this.o.setImageDrawable(a.a("multiwindow_delete.svg"));
        a.c("default_background_dark");
    }

    public void onMeasure(int i, int i2) {
        if (this.A == 0 || this.F == 0) {
            int[] a = com.ucpro.feature.t.a.a(b.a.f(), ((View) getParent()).getMeasuredHeight(), false);
            this.F = a[0];
            this.A = a[1];
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.F, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec((this.r + this.A) + this.G, UCCore.VERIFY_POLICY_QUICK));
        if (this.m != null) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.t, UCCore.VERIFY_POLICY_QUICK);
            this.m.measure(makeMeasureSpec, makeMeasureSpec);
        }
        if (this.n != null) {
            this.n.measure(MeasureSpec.makeMeasureSpec((((this.F - (this.u * 2)) - (this.s * 2)) - this.t) - this.v, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.o != null) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.v, UCCore.VERIFY_POLICY_QUICK);
            this.o.measure(makeMeasureSpec, makeMeasureSpec);
        }
        d();
    }

    public void d() {
        if (this.p != null) {
            this.p.measure(MeasureSpec.makeMeasureSpec(this.F, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.A, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.m != null && this.m.getVisibility() == 0) {
            int i5 = this.s;
            this.m.layout(i5, 0, this.m.getMeasuredWidth() + i5, this.m.getMeasuredHeight() + 0);
        }
        if (this.n != null && this.n.getVisibility() == 0) {
            i5 = this.m.getRight() + this.u;
            int measuredHeight = (this.r - this.n.getMeasuredHeight()) / 2;
            this.n.layout(i5, measuredHeight, this.n.getMeasuredWidth() + i5, this.n.getMeasuredHeight() + measuredHeight);
        }
        if (this.o != null && this.o.getVisibility() == 0) {
            i5 = getMeasuredWidth() - this.s;
            this.o.layout(i5 - this.o.getMeasuredWidth(), 0, i5, this.o.getMeasuredHeight() + 0);
        }
        e();
    }

    public void e() {
        if (this.p != null && this.p.getVisibility() == 0) {
            int i = this.t + this.G;
            this.p.layout(0, i, this.p.getMeasuredWidth() + 0, this.p.getMeasuredHeight() + i);
        }
    }

    public void setIndex(int i) {
        this.H = i;
    }

    public void setTitleText(String str) {
        this.n.setText(str);
    }

    public void setWebShotImage(Bitmap bitmap) {
        this.q = bitmap;
        this.p.setDrawBitmap(this.q);
    }

    public void setIconDrawable(Drawable drawable) {
        this.m.setImageDrawable(drawable);
    }

    public Bitmap getWebShotBitmap() {
        return this.q;
    }

    public int getIndex() {
        return this.H;
    }

    public b getWebShotImageView() {
        return this.p;
    }

    public View getDeleteBtn() {
        return this.o;
    }

    public void setAnimStartX(float f) {
        this.I = f;
    }

    public void setAnimStartY(float f) {
        this.J = f;
    }

    public float getAnimStartX() {
        return this.I;
    }

    public float getAnimStartY() {
        return this.J;
    }
}
