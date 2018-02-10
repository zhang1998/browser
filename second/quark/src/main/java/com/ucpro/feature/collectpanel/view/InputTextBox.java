package com.ucpro.feature.collectpanel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ui.edittext.ai;

/* compiled from: ProGuard */
public class InputTextBox extends ViewGroup {
    private String a;
    private CustomEditText b;
    private ImageView c;
    private ImageView d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;

    static /* synthetic */ void d(InputTextBox inputTextBox) {
        if (inputTextBox.d.getVisibility() == 0) {
            inputTextBox.d.setVisibility(8);
        }
        if (inputTextBox.c.getVisibility() == 8) {
            inputTextBox.c.setVisibility(0);
            inputTextBox.c.setScaleX(0.0f);
            inputTextBox.c.setScaleY(0.0f);
            inputTextBox.c.animate().cancel();
            inputTextBox.c.animate().scaleX(IPictureView.DEFAULT_MIN_SCALE).scaleY(IPictureView.DEFAULT_MIN_SCALE).setStartDelay(250).setDuration(300).start();
        }
    }

    static /* synthetic */ void e(InputTextBox inputTextBox) {
        if (inputTextBox.c.getScaleX() != IPictureView.DEFAULT_MIN_SCALE) {
            inputTextBox.c.animate().cancel();
            inputTextBox.c.animate().scaleX(IPictureView.DEFAULT_MIN_SCALE).scaleY(IPictureView.DEFAULT_MIN_SCALE).setDuration(150).start();
        }
    }

    static /* synthetic */ void f(InputTextBox inputTextBox) {
        if (inputTextBox.c.getScaleX() != 0.0f) {
            inputTextBox.c.animate().cancel();
            inputTextBox.c.animate().scaleX(0.0f).scaleY(0.0f).setDuration(150).start();
        }
    }

    public InputTextBox(Context context) {
        super(context);
        a();
    }

    public InputTextBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f = a.c("collect_panel_inactive_text_color");
        this.g = a.c("default_maintext_gray");
        this.h = a.c((int) R.dimen.collect_panel_content_delete_button_size);
        this.i = a.c((int) R.dimen.collect_panel_content_delete_button_marginleft);
        this.b = new CustomEditText(getContext());
        this.b.setSingleLine(true);
        this.b.setGravity(16);
        this.b.setBackgroundColor(0);
        this.b.a(0, (float) a.c((int) R.dimen.collect_panel_content_textsize));
        addView(this.b);
        this.b.a(new g(this));
        this.c = new ImageView(getContext());
        this.c.setOnClickListener(new h(this));
        this.c.setVisibility(8);
        addView(this.c);
        this.d = new ImageView(getContext());
        this.d.setOnClickListener(new e(this));
        addView(this.d);
        this.e = new View(getContext());
        addView(this.e);
        this.e.setBackgroundColor(a.c("collect_panel_bottom_line_color"));
        this.c.setImageDrawable(a.a("searchpage_search_bar_delete.svg"));
        this.d.setImageDrawable(a.a("collect_panel_edit.svg"));
    }

    public void setOnEditorActionListener(ai aiVar) {
        this.b.setOnEditorActionListener(aiVar);
    }

    private void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setText(String str) {
        this.a = str;
        this.b.setText((CharSequence) str);
    }

    public String getText() {
        if (this.b.getText() != null) {
            return this.b.getText().toString();
        }
        return "";
    }

    public void setBottomLineVisibility(int i) {
        this.e.setVisibility(i);
    }

    public void setActiveTextColor(int i) {
        this.g = i;
    }

    public void setInactiveTextColor(int i) {
        this.f = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.measure(MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.d.measure(MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.b.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.c.getMeasuredWidth()) - this.i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.e.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(1, UCCore.VERIFY_POLICY_QUICK));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        this.c.layout(width - this.c.getMeasuredWidth(), 0, width, getHeight());
        width = getWidth();
        this.d.layout(width - this.d.getMeasuredWidth(), 0, width, getHeight());
        this.b.layout(0, 0, this.b.getMeasuredWidth() + 0, getHeight());
        this.e.layout(0, getHeight() - this.e.getMeasuredHeight(), getWidth(), getHeight());
    }
}
