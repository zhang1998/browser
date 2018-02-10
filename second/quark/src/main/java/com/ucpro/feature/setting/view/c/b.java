package com.ucpro.feature.setting.view.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.setting.view.a.a;
import com.ucpro.feature.setting.view.a.c;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class b extends FrameLayout implements c {
    private ATTextView a;
    private a b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int[] h;
    private String[] i;

    public b(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.c = com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_default_size);
        this.d = com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_space_size);
        this.e = com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_margin_top);
        this.f = com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_margin_bottom);
        this.g = com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_seekbar_height);
        this.a = new ATTextView(getContext());
        this.a.setText(com.ucpro.ui.c.a.d((int) R.string.broswse_setting_item_font_preview_text));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.e;
        this.a.setGravity(17);
        addView(this.a, layoutParams);
        this.b = new a(getContext());
        this.b.setPadding(this.g, this.g, this.g, this.g);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = this.f;
        addView(this.b, layoutParams);
        a();
    }

    public final void setAdapter(com.ucpro.feature.setting.a.b bVar) {
    }

    public final com.ucpro.feature.setting.a.b getAdapter() {
        return null;
    }

    public final void a() {
        this.a.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.b.a();
    }

    public final void setSettingViewCallback(a aVar) {
    }

    public final View getSettingView() {
        return this;
    }

    public final void setFontSize(int i) {
        if (this.h != null && this.i != null) {
            for (int i2 = 0; i2 < this.h.length; i2++) {
                if (this.h[i2] == i) {
                    int i3 = (int) (((float) this.c) + ((((float) (i - 80)) / 20.0f) * ((float) this.d)));
                    this.a.setTextSize(0, (float) i3);
                    this.a.setLineSpacing((float) i3, IPictureView.DEFAULT_MIN_SCALE);
                    this.b.setText(this.i[i2]);
                    this.b.setProgress(i2);
                    return;
                }
            }
        }
    }

    public final void setListener(c cVar) {
        this.b.setBarChangeListener(cVar);
    }

    public final void setFontSizeArray(int[] iArr) {
        this.h = iArr;
        this.b.setMax(iArr.length - 1);
    }

    public final void setFontSizeTips(String[] strArr) {
        this.i = strArr;
    }
}
