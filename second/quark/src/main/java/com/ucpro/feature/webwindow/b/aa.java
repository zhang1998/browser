package com.ucpro.feature.webwindow.b;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class aa extends FrameLayout {
    private int a = 0;
    private int b = 0;
    private ATTextView c = new ATTextView(getContext());
    private float d = a.b((int) R.dimen.pic_viewer_titlebar_text_size);
    private StringBuilder e;

    public aa(Context context) {
        super(context);
        this.c.setSingleLine();
        this.c.setTextSize(0, this.d);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.c, layoutParams);
        a();
    }

    public final void a() {
        setBackgroundColor(-16777216);
        getBackground().setAlpha(229);
        this.c.setTextColor(a.c("pic_viewer_titlebar_text_color"));
    }

    public final void a(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (this.e == null) {
            this.e = new StringBuilder();
        }
        this.e.setLength(0);
        this.e.append(this.a).append("/").append(this.a > this.b ? this.a : this.b);
        new StringBuilder("PicViewerTitlebar updateTitlebarStr mTitleString : ").append(this.e);
        this.c.setText(this.e);
    }
}
