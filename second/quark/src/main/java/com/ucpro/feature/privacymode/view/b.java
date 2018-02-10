package com.ucpro.feature.privacymode.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.f;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public abstract class b extends ViewGroup implements OnClickListener {
    StringBuffer a = new StringBuffer();
    int b = 4;
    String c;
    String d;
    ImageView[] e = new ImageView[4];
    private ATTextView f;
    private ATTextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private EditText m;
    private int n = a.c((int) R.dimen.privacymode_password_radius);
    private int o = a.c((int) R.dimen.privacymode_password_text_margin);
    private int p = a.c((int) R.dimen.privacymode_password_image_text_margin);
    private int q = a.c((int) R.dimen.privacymode_password_image_margin_left_right);
    private GradientDrawable r;
    private int s = p.a;

    protected abstract void a(String str);

    protected abstract boolean b(String str);

    public void setPassWordType$1e30636a(int i) {
        if (i != 0) {
            this.s = i;
            if (i == p.b) {
                this.f.setText(a.d((int) R.string.privacymode_unlock_title_tips));
                this.g.setText(a.d((int) R.string.privacymode_unlock_desc_tips));
            } else if (i == p.c) {
                this.f.setText(a.d((int) R.string.privacymode_setting_change_password_title));
                this.g.setText(a.d((int) R.string.privacymode_unlock_desc_tips));
            }
        }
    }

    public b(Context context) {
        super(context);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) this.n);
        gradientDrawable.setColor(a.c("privacymode_password_image_bg"));
        this.r = new GradientDrawable();
        this.r.setCornerRadius((float) this.n);
        this.r.setColor(a.c("privacymode_password_image_select_bg"));
        this.h = new ImageView(getContext());
        this.h.setImageDrawable(a.a("privacy_mode_password_lock.svg"));
        addView(this.h);
        this.f = new ATTextView(getContext());
        this.f.setText(a.d((int) R.string.privacymode_confirm_title_tips));
        this.f.setTypeface(null, 1);
        this.f.setTextColor(a.c("privacymode_password_title"));
        this.f.setTextSize(0, a.a((int) R.dimen.privacymode_password_title_textsize));
        addView(this.f);
        this.g = new ATTextView(getContext());
        this.g.setTextColor(a.c("default_assisttext_gray"));
        this.g.setText(a.d((int) R.string.privacymode_confirm_desc_tips));
        this.g.setTextSize(0, a.a((int) R.dimen.privacymode_password_desc_textsize));
        addView(this.g);
        this.i = new ImageView(getContext());
        this.i.setBackgroundDrawable(gradientDrawable);
        this.i.setScaleType(ScaleType.CENTER_INSIDE);
        this.i.setOnClickListener(this);
        addView(this.i);
        this.e[0] = this.i;
        this.j = new ImageView(getContext());
        this.j.setBackgroundDrawable(gradientDrawable);
        this.j.setScaleType(ScaleType.CENTER_INSIDE);
        this.j.setOnClickListener(this);
        addView(this.j);
        this.e[1] = this.j;
        this.k = new ImageView(getContext());
        this.k.setBackgroundDrawable(gradientDrawable);
        this.k.setScaleType(ScaleType.CENTER_INSIDE);
        this.k.setOnClickListener(this);
        addView(this.k);
        this.e[2] = this.k;
        this.l = new ImageView(getContext());
        this.l.setBackgroundDrawable(gradientDrawable);
        this.l.setScaleType(ScaleType.CENTER_INSIDE);
        this.l.setOnClickListener(this);
        addView(this.l);
        this.e[3] = this.l;
        this.m = new EditText(getContext());
        addView(this.m);
        this.m.setCursorVisible(true);
        this.m.setInputType(2);
        this.m.setOnKeyListener(new c(this));
        this.m.addTextChangedListener(new m(this));
        this.m.requestFocus();
        f.c(getContext());
    }

    public void setTitle(String str) {
        if (com.ucweb.common.util.n.a.b(str)) {
            this.f.setText(str);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        this.f.measure(makeMeasureSpec, makeMeasureSpec2);
        this.g.measure(makeMeasureSpec, makeMeasureSpec2);
        this.m.measure(makeMeasureSpec, makeMeasureSpec2);
        this.h.measure(makeMeasureSpec, makeMeasureSpec2);
        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.n * 2, UCCore.VERIFY_POLICY_QUICK);
        makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.n * 2, UCCore.VERIFY_POLICY_QUICK);
        this.i.measure(makeMeasureSpec, makeMeasureSpec2);
        this.j.measure(makeMeasureSpec, makeMeasureSpec2);
        this.k.measure(makeMeasureSpec, makeMeasureSpec2);
        this.l.measure(makeMeasureSpec, makeMeasureSpec2);
        setMeasuredDimension(getMeasuredWidth(), ((((this.f.getMeasuredHeight() + this.g.getMeasuredHeight()) + this.i.getMeasuredHeight()) + this.o) + (this.p * 2)) + this.h.getMeasuredHeight());
    }

    public void onClick(View view) {
        this.m.requestFocus();
        f.c(getContext());
    }

    protected final void a() {
        f.a(getContext(), this.m);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = (getWidth() / 2) - (this.h.getMeasuredWidth() / 2);
        int measuredHeight = this.h.getMeasuredHeight() + 0;
        this.h.layout(width, 0, this.h.getMeasuredWidth() + width, measuredHeight);
        width = (getWidth() / 2) - (this.f.getMeasuredWidth() / 2);
        int i5 = this.p + measuredHeight;
        int measuredHeight2 = this.f.getMeasuredHeight() + i5;
        this.f.layout(width, i5, this.f.getMeasuredWidth() + width, measuredHeight2);
        width = (getWidth() / 2) - (this.g.getMeasuredWidth() / 2);
        i5 = this.o + measuredHeight2;
        measuredHeight2 = this.g.getMeasuredHeight() + i5;
        this.g.layout(width, i5, this.g.getMeasuredWidth() + width, measuredHeight2);
        width = this.p;
        i5 = (getWidth() - ((width * 3) + (this.i.getMeasuredWidth() * 4))) / 2;
        measuredHeight = this.p + measuredHeight2;
        measuredHeight2 = this.i.getMeasuredWidth() + i5;
        int measuredHeight3 = this.i.getMeasuredHeight() + measuredHeight;
        this.i.layout(i5, measuredHeight, measuredHeight2, measuredHeight3);
        i5 = measuredHeight2 + width;
        measuredHeight2 = this.j.getMeasuredWidth() + i5;
        this.j.layout(i5, measuredHeight, measuredHeight2, measuredHeight3);
        i5 = measuredHeight2 + width;
        measuredHeight2 = this.k.getMeasuredWidth() + i5;
        this.k.layout(i5, measuredHeight, measuredHeight2, measuredHeight3);
        width += measuredHeight2;
        this.l.layout(width, measuredHeight, this.l.getMeasuredWidth() + width, measuredHeight3);
        this.m.layout(width, measuredHeight3, this.m.getMeasuredWidth() + width, this.m.getMeasuredHeight() + measuredHeight3);
    }

    static /* synthetic */ void h(b bVar) {
        bVar.a = new StringBuffer();
        bVar.d = "";
        m.a(2, new e(bVar), 100);
    }

    static /* synthetic */ void j(b bVar) {
        bVar.a = new StringBuffer();
        bVar.c = "";
        bVar.d = "";
        m.a(2, new s(bVar), 100);
    }
}
