package com.ucpro.feature.bookmarkhis.bookmark.category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.q;
import com.ucpro.ui.widget.o;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class d extends ViewGroup implements OnClickListener, q {
    private int a = 0;
    private o b = null;
    private o c = null;
    private TextView d = null;
    private View e = null;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private b k;

    public d(Context context, int i) {
        super(context);
        this.f = i;
        this.e = new View(getContext());
        addView(this.e);
        LayoutParams layoutParams = new LayoutParams(a.c((int) R.dimen.search_input_history_keyword_halfcirle_width), a.c((int) R.dimen.search_input_history_keyword_halfcirle_height));
        this.b = new o(getContext());
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        this.c = new o(getContext());
        this.c.setType(1);
        this.c.setLayoutParams(layoutParams);
        addView(this.c);
        this.d = new TextView(getContext());
        layoutParams = new LayoutParams(-2, a.c((int) R.dimen.search_input_history_keyword_text_height));
        this.d.setTextSize(0, (float) a.c((int) R.dimen.search_input_history_keyword_textsize));
        this.d.setLayoutParams(layoutParams);
        this.d.setGravity(17);
        this.d.setSingleLine();
        this.d.setEllipsize(TruncateAt.END);
        addView(this.d);
        setOnClickListener(this);
        this.h = a.c("default_purpleblue");
        a();
    }

    public final void a() {
        this.d.setTextColor(a.c("default_maintext_gray"));
        setBgColor(a.c("default_bubble"));
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        int childCount = getChildCount();
        measureChild(this.c, i, i2);
        measureChild(this.b, i, i2);
        int size = MeasureSpec.getSize(i);
        measureChild(this.d, MeasureSpec.makeMeasureSpec((size - this.c.getMeasuredWidth()) - this.b.getMeasuredWidth(), MeasureSpec.getMode(i)), i2);
        size = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (!(childAt.getVisibility() == 8 || childAt == this.e)) {
                size += childAt.getMeasuredWidth();
            }
            if (childAt.getVisibility() != 8) {
                i3 = Math.max(i3, childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(size, i3);
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
        this.i = i;
        this.j = ((((((int) ((((float) ((i >> 24) & 255)) * 0.5f) + 127.5f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.5f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.5f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.5f) + 0.0f)) & 255) << 0);
        if (com.ucpro.model.a.a.a.a("setting_night_mode", false)) {
            this.g = this.j;
        } else {
            this.g = this.i;
        }
        this.b.setColor(this.g);
        this.c.setColor(this.g);
        this.e.setBackgroundColor(this.g);
    }

    public final void setText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public final void setTypeface(Typeface typeface) {
        this.d.setTypeface(typeface);
    }

    public final TextView getTextView() {
        return this.d;
    }

    public final void setPosition(int i) {
        this.f = i;
    }

    public final void onClick(View view) {
        if (this.k != null && view == this) {
            b bVar = this.k;
            int i = this.f;
            this.d.getText().toString();
            bVar.a(i);
        }
    }

    public final void setCallback(b bVar) {
        this.k = bVar;
    }

    public final void setSelected(boolean z) {
        if (z) {
            this.d.setTextColor(a.c("bookmark_category_tag_select_text_color"));
            setBgColor(a.c("default_purpleblue"));
            return;
        }
        this.d.setTextColor(a.c("default_maintext_gray"));
        setBgColor(a.c("default_bubble"));
    }

    public final void setType(int i) {
        this.a = i;
    }
}
