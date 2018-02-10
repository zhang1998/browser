package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class p extends FrameLayout {
    private Context a;
    private ATTextView b;

    public p(Context context) {
        super(context);
        this.a = context;
        View linearLayout = new LinearLayout(this.a);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        addView(linearLayout, layoutParams);
        View linearLayout2 = new LinearLayout(this.a);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        linearLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.setOrientation(1);
        this.b = new ATTextView(this.a);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        linearLayout2.addView(this.b, layoutParams3);
        this.b.setGravity(17);
        this.b.setText(a.d((int) R.string.no_bookmark_text_root));
        this.b.setTextSize(0, a.a((int) R.dimen.common_titlebar_title_size));
        a();
    }

    public final void a() {
        this.b.setTextColor(a.c("bookmark_empty_title_color"));
        setBackgroundColor(a.c("default_background_white"));
    }

    public final void setContentText(String str) {
        ATTextView aTTextView = this.b;
        if (TextUtils.isEmpty(str)) {
            str = a.d((int) R.string.no_bookmark_text_root);
        }
        aTTextView.setText(Html.fromHtml(str));
    }
}
