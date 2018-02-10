package com.ucpro.feature.collectpanel.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.widget.o;
import com.ui.edittext.EditText;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class a extends ViewGroup implements OnClickListener {
    private int a;
    private o b;
    private o c;
    private EditText d;
    private View e;
    private int f;
    private int g;
    private int h;

    public a(Context context) {
        super(context);
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = new View(getContext());
        addView(this.e);
        LayoutParams layoutParams = new LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.search_input_history_keyword_halfcirle_width), com.ucpro.ui.c.a.c((int) R.dimen.search_input_history_keyword_halfcirle_height));
        this.b = new o(getContext());
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        this.c = new o(getContext());
        this.c.setType(1);
        this.c.setLayoutParams(layoutParams);
        addView(this.c);
        this.d = new EditText(getContext());
        layoutParams = new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.search_input_history_keyword_text_height));
        this.d.a(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.search_input_history_keyword_textsize));
        this.d.setLayoutParams(layoutParams);
        this.d.setGravity(17);
        this.d.setPadding(0, 0, 0, 0);
        this.d.setSingleLine(true);
        this.d.setBackgroundColor(0);
        this.d.setEllipsize(TruncateAt.END);
        addView(this.d);
        setOnClickListener(this);
        a();
    }

    public final void a() {
        this.d.setTextColor(com.ucpro.ui.c.a.c("bookmark_category_tag_select_text_color"));
        setBgColor(com.ucpro.ui.c.a.c("default_purpleblue"));
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        measureChild(this.c, i, i2);
        measureChild(this.b, i, i2);
        measureChild(this.d, MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.c.getMeasuredWidth()) - this.b.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), i2);
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                i3 = Math.max(i3, childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(getMeasuredWidth(), i3);
        this.e.measure(MeasureSpec.makeMeasureSpec(this.d.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e != null && this.e.getVisibility() == 0) {
            int measuredWidth = this.b.getMeasuredWidth();
            this.e.layout(measuredWidth, 0, this.e.getMeasuredWidth() + measuredWidth, this.e.getMeasuredHeight() + 0);
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            this.b.layout(0, 0, this.b.getMeasuredWidth() + 0, this.b.getMeasuredHeight() + 0);
        }
        if (this.d != null && this.d.getVisibility() == 0) {
            measuredWidth = this.b.getMeasuredWidth();
            this.d.layout(measuredWidth, 0, this.d.getMeasuredWidth() + measuredWidth, this.d.getMeasuredHeight() + 0);
        }
        if (this.c != null && this.c.getVisibility() == 0) {
            this.c.layout(getMeasuredWidth() - this.c.getMeasuredWidth(), 0, getMeasuredWidth(), this.c.getMeasuredHeight() + 0);
        }
    }

    public final void setBgColor(int i) {
        this.g = i;
        this.h = ((((((int) ((((float) ((i >> 24) & 255)) * 0.5f) + 127.5f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.5f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.5f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.5f) + 0.0f)) & 255) << 0);
        if (com.ucpro.model.a.a.a.a("setting_night_mode", false)) {
            this.f = this.h;
        } else {
            this.f = this.g;
        }
        this.b.setColor(this.f);
        this.c.setColor(this.f);
        this.e.setBackgroundColor(this.f);
    }

    public final void setText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public final void setTypeface(Typeface typeface) {
        this.d.setTypeface(typeface);
    }

    public final EditText getEditText() {
        return this.d;
    }

    public final void onClick(View view) {
    }

    public final void setType(int i) {
        this.a = i;
    }
}
