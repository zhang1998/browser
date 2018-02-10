package com.ucpro.feature.z.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.q;
import com.ucpro.ui.widget.TextView;
import com.ucpro.ui.widget.o;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class r extends ViewGroup implements OnClickListener, OnLongClickListener, q {
    private o a = null;
    private o b = null;
    private TextView c = null;
    private View d = null;
    private View e = null;
    private View f = null;
    private ImageView g = null;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = -1;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private b p = null;

    public r(Context context, int i) {
        super(context);
        this.k = i;
        this.h = a.c((int) R.dimen.search_input_history_visit_url_icon_right_margin);
        this.i = a.c((int) R.dimen.search_input_history_delete_width);
        this.j = a.c((int) R.dimen.search_input_history_delete_padding);
        this.e = new View(getContext());
        addView(this.e);
        LayoutParams layoutParams = new LayoutParams(a.c((int) R.dimen.search_input_history_keyword_halfcirle_width), a.c((int) R.dimen.search_input_history_keyword_halfcirle_height));
        this.a = new o(getContext());
        this.a.setLayoutParams(layoutParams);
        addView(this.a);
        this.b = new o(getContext());
        this.b.setType(1);
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        this.c = new TextView(getContext());
        layoutParams = new LayoutParams(-2, a.c((int) R.dimen.search_input_history_keyword_text_height));
        this.c.setTextSize(0, (float) a.c((int) R.dimen.search_input_history_keyword_textsize));
        this.c.setLayoutParams(layoutParams);
        this.c.setGravity(17);
        this.c.setSingleLine();
        this.c.setEllipsize(TruncateAt.END);
        addView(this.c);
        this.d = new View(getContext());
        this.d.setLayoutParams(new LayoutParams(a.c((int) R.dimen.search_input_history_visit_url_icon_width), a.c((int) R.dimen.search_input_history_visit_url_icon_width)));
        addView(this.d);
        setOnClickListener(this);
        this.g = new ImageView(getContext());
        this.g.setLayoutParams(new LayoutParams(-2, -2));
        this.g.setVisibility(8);
        this.g.setClickable(true);
        this.g.setOnClickListener(this);
        addView(this.g);
        this.f = new View(getContext());
        this.f.setVisibility(8);
        addView(this.f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        a();
    }

    public final void a() {
        this.c.setTextColor(a.c("default_maintext_gray"));
        this.d.setBackgroundDrawable(a.a("searchpage_input_history_visit_url_icon.svg"));
        this.g.setImageDrawable(a.a("searchpage_input_history_delete_one.png"));
        this.f.setBackgroundDrawable(a.a("searchpage_input_history_tag_delete_bg.xml"));
        setBgColor(a.c("default_bubble"));
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        int childCount = getChildCount();
        measureChild(this.b, i, i2);
        measureChild(this.a, i, i2);
        measureChild(this.d, i, i2);
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        if (this.d.getVisibility() == 8) {
            size = (size - this.b.getMeasuredWidth()) - this.a.getMeasuredWidth();
        } else {
            size = (((size - this.b.getMeasuredWidth()) - this.a.getMeasuredWidth()) - this.d.getMeasuredWidth()) - this.h;
        }
        measureChild(this.c, MeasureSpec.makeMeasureSpec(size, mode), i2);
        size = 0;
        for (mode = 0; mode < childCount; mode++) {
            View childAt = getChildAt(mode);
            if (!(childAt.getVisibility() == 8 || childAt == this.e || childAt == this.g || childAt == this.f)) {
                size += childAt.getMeasuredWidth();
            }
            if (!(childAt.getVisibility() == 8 || childAt == this.f)) {
                i3 = Math.max(i3, childAt.getMeasuredHeight());
            }
        }
        if (this.d.getVisibility() != 8) {
            size += this.h;
        }
        setMeasuredDimension(size, i3);
        if (this.d.getVisibility() == 8) {
            size = MeasureSpec.makeMeasureSpec(this.c.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK);
        } else {
            size = MeasureSpec.makeMeasureSpec((this.c.getMeasuredWidth() + this.d.getMeasuredWidth()) + this.h, UCCore.VERIFY_POLICY_QUICK);
        }
        this.e.measure(size, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.g.measure(MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.f.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e != null && this.e.getVisibility() == 0) {
            int measuredWidth = this.a.getMeasuredWidth();
            this.e.layout(measuredWidth, 0, this.e.getMeasuredWidth() + measuredWidth, this.e.getMeasuredHeight() + 0);
        }
        if (this.a != null && this.a.getVisibility() == 0) {
            this.a.layout(0, 0, this.a.getMeasuredWidth() + 0, this.a.getMeasuredHeight() + 0);
        }
        if (this.c != null && this.c.getVisibility() == 0) {
            measuredWidth = this.a.getMeasuredWidth();
            if (this.d.getVisibility() != 8) {
                measuredWidth = (this.a.getMeasuredWidth() + this.d.getMeasuredWidth()) + this.h;
            }
            this.c.layout(measuredWidth, 0, this.c.getMeasuredWidth() + measuredWidth, this.c.getMeasuredHeight() + 0);
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            this.b.layout(getMeasuredWidth() - this.b.getMeasuredWidth(), 0, getMeasuredWidth(), this.b.getMeasuredHeight() + 0);
        }
        if (this.d != null && this.d.getVisibility() == 0) {
            measuredWidth = this.a.getMeasuredWidth();
            int measuredHeight = (getMeasuredHeight() - this.d.getMeasuredHeight()) / 2;
            this.d.layout(measuredWidth, measuredHeight, this.d.getMeasuredWidth() + measuredWidth, this.d.getMeasuredHeight() + measuredHeight);
        }
        if (this.g != null && this.g.getVisibility() == 0) {
            measuredWidth = getMeasuredWidth();
            measuredHeight = (getMeasuredHeight() - this.g.getMeasuredHeight()) / 2;
            this.g.layout(measuredWidth - this.g.getMeasuredWidth(), measuredHeight, measuredWidth, this.g.getMeasuredHeight() + measuredHeight);
        }
        if (this.f != null && this.f.getVisibility() == 0) {
            this.f.layout(0, 0, this.f.getMeasuredWidth() + 0, this.f.getMeasuredHeight() + 0);
        }
    }

    public final void setBgColor(int i) {
        this.n = i;
        this.o = a(i, 0.5f);
        if (com.ucpro.model.a.a.a.a("setting_night_mode", false)) {
            this.l = this.o;
        } else {
            this.l = this.n;
        }
        this.a.setColor(this.l);
        this.b.setColor(this.l);
        this.e.setBackgroundColor(this.l);
        this.m = a(this.l, 0.85f);
    }

    private static int a(int i, float f) {
        float f2 = IPictureView.DEFAULT_MIN_SCALE - f;
        return ((((int) ((f2 * 0.0f) + (((float) (i & 255)) * f))) & 255) << 0) | ((((((int) ((((float) ((i >> 24) & 255)) * f) + (255.0f * f2))) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * f) + (0.0f * f2))) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * f) + (0.0f * f2))) & 255) << 8));
    }

    public final void setText(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public final void setTypeface(Typeface typeface) {
        this.c.setTypeface(typeface);
    }

    public final TextView getTextView() {
        return this.c;
    }

    public final ImageView getDeleteBtn() {
        return this.g;
    }

    public final View getBorderView() {
        return this.f;
    }

    public final View getHistoryUrlIcon() {
        return this.d;
    }

    public final void setPosition(int i) {
        this.k = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a.setColor(this.m);
            this.b.setColor(this.m);
            this.e.setBackgroundColor(this.m);
        } else if (action == 1 || action == 3) {
            this.a.setColor(this.l);
            this.b.setColor(this.l);
            this.e.setBackgroundColor(this.l);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void onClick(View view) {
        if (this.p != null) {
            if (view == this.g) {
                this.p.a(this.k);
            } else if (view == this) {
                this.p.a(this.k, this.c.getText().toString());
            }
        }
    }

    public final void setCallback(b bVar) {
        this.p = bVar;
    }

    public final boolean onLongClick(View view) {
        if (view != this || this.p == null) {
            return false;
        }
        this.p.a(view);
        return true;
    }
}
