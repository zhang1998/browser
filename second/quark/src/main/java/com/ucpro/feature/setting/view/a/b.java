package com.ucpro.feature.setting.view.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class b extends LinearLayout {
    TextView a = new TextView(getContext());
    ImageView b;

    public b(Context context) {
        super(context);
        setOrientation(0);
        this.a.setSingleLine();
        this.a.setEllipsize(TruncateAt.END);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, a.c((int) R.dimen.setting_item_red_dot_margin), 0);
        addView(this.a, layoutParams);
        this.b = new ImageView(getContext());
        layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.setting_item_red_dot_size), a.c((int) R.dimen.setting_item_red_dot_size));
        layoutParams.gravity = 16;
        this.b.setVisibility(4);
        addView(this.b, layoutParams);
        if (this.b != null) {
            this.b.setImageDrawable(a.a("menu_red_dot.xml"));
        }
    }

    public final void setText(String str) {
        if (this.a != null) {
            this.a.setText(str);
        }
    }

    public final void setTextSize(float f) {
        if (this.a != null) {
            this.a.setTextSize(0, f);
        }
    }

    public final void setTextColor(int i) {
        if (this.a != null) {
            this.a.setTextColor(i);
        }
    }
}
