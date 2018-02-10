package com.ucpro.feature.bookmarkhis.a.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ripple.f;

/* compiled from: ProGuard */
public final class c extends LinearLayout {
    private static int b;
    Drawable a;
    private ImageView c = new ImageView(getContext());
    private TextView d = new TextView(getContext());
    private String e;

    public c(Context context) {
        super(context);
        setOrientation(0);
        addView(this.c);
        addView(this.d);
        this.a = f.a(0, a.c("history_list_item_bg_focused_color"));
        b = (int) a.a((int) R.dimen.bookmarkmgntitem_favicon_padding);
    }

    public final void setTitle(String str) {
        this.d.setText(str);
        this.d.setSingleLine();
        this.d.setEllipsize(TruncateAt.valueOf("END"));
        this.d.setTextSize(0, a.b((int) R.dimen.history_item_title_text_size));
        this.d.setTextColor(new ColorStateList(new int[][]{new int[0], new int[]{16842919, 16842908}}, new int[]{a.c("default_maintext_gray"), a.c("histroy_list_item_text_focused_color")}));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = a.c((int) R.dimen.history_item_title_right_margin);
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
    }

    public final void setIcon(Drawable drawable) {
        this.c.setImageDrawable(drawable);
        float c = (float) a.c((int) R.dimen.history_item_fav_icon_size);
        LayoutParams layoutParams = new LinearLayout.LayoutParams((int) c, (int) c);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = a.c((int) R.dimen.history_item_fav_icon_margin);
        layoutParams.leftMargin = a.c((int) R.dimen.history_item_fav_icon_margin);
        this.c.setLayoutParams(layoutParams);
    }

    public final void a() {
        if (this.c != null) {
            this.c.setPadding(b, b, b, b);
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.setPadding(0, 0, 0, 0);
        }
    }

    public final void setUrl(String str) {
        this.e = str;
    }

    public final String getUrl() {
        return this.e;
    }

    public final String getTitle() {
        return this.d.getText().toString();
    }
}
