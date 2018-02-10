package com.ucpro.feature.bookmarkhis.bookmark.category;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.collectpanel.view.a;

/* compiled from: ProGuard */
public class CategoryEditBar extends LinearLayout {
    public boolean a = false;
    public a b = null;
    private TextView c = null;
    private TextView d = null;
    private TextView e = null;

    public CategoryEditBar(Context context) {
        super(context);
        a();
        b();
    }

    public CategoryEditBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        b();
    }

    private void a() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(R.layout.category_edit_bar, this, true);
        this.c = (TextView) findViewById(R.id.cancel_btn);
        this.d = (TextView) findViewById(R.id.confim_btn);
        this.e = (TextView) findViewById(R.id.add_btn);
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        this.b = new a(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ((FrameLayout) findViewById(R.id.edit_btn_container)).addView(this.b, layoutParams);
        this.b.setAlpha(0.0f);
    }

    private void b() {
        this.b.a();
        this.c.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.d.setTextColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.e.setTextColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.c.setBackgroundDrawable(com.ucpro.ui.c.a.c());
        this.d.setBackgroundDrawable(com.ucpro.ui.c.a.c());
        this.e.setBackgroundDrawable(com.ucpro.ui.c.a.c());
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
    }

    public TextView getAddBtn() {
        return this.e;
    }

    public TextView getCancelBtn() {
        return this.c;
    }

    public TextView getConfimBtn() {
        return this.d;
    }

    public a getEditView() {
        return this.b;
    }

    public final void a(boolean z) {
        setClickable(true);
        if (z) {
            this.b.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).start();
        } else {
            this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        }
        this.b.setText("");
    }

    public void setEditMode(boolean z) {
        this.a = z;
        if (z) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }
}
