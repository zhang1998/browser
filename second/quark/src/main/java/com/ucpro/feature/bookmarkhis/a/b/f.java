package com.ucpro.feature.bookmarkhis.a.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class f extends LinearLayout {
    e a;
    l b;
    g c;
    Drawable d = new ColorDrawable(a.c("baselist_divider_color"));
    LayoutParams e = new LayoutParams(-1, -1);
    private com.ucpro.ui.a.a f;

    public f(Context context) {
        super(context);
        setOrientation(1);
    }

    final void a() {
        if (this.f != null) {
            this.f.a("lottie/history_empty/data.json", "lottie/history_empty/images", "lottie/history_empty/images_night");
            this.f.setText(a.d((int) R.string.empty_error_anim_page_history_empty));
        }
    }

    public final void b() {
        if (this.f == null) {
            c();
            if (!(this.f == null || this.f.getParent() == null)) {
                removeView(this.f);
            }
            this.f = new com.ucpro.ui.a.a(getContext());
            addView(this.f, this.e);
            a();
            if (this.f != null) {
                this.f.setVisibility(0);
            }
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    final void c() {
        removeAllViews();
        this.a = null;
        this.f = null;
    }

    public final void setOnHistoryItemClickListener(g gVar) {
        this.c = gVar;
    }
}
