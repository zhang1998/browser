package com.ucpro.feature.downloadpage.dirselect;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public class DirManagerItemView extends LinearLayout {
    private ImageView a;
    private ATTextView b;

    public DirManagerItemView(Context context) {
        super(context);
        a();
    }

    public DirManagerItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setOrientation(0);
        setBackgroundDrawable(a.c());
        this.a = new ImageView(getContext());
        int c = a.c((int) R.dimen.dir_manager_item_icon_size);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = a.c((int) R.dimen.dir_manager_item_icon_margin_left);
        layoutParams.rightMargin = a.c((int) R.dimen.dir_manager_item_icon_margin_right);
        addView(this.a, layoutParams);
        this.b = new ATTextView(getContext());
        this.b.setTextSize(0, (float) a.c((int) R.dimen.dir_manager_item_text_size));
        this.b.setTextColor(a.c("default_maintext_gray"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = a.c((int) R.dimen.dir_manager_item_icon_margin_right);
        addView(this.b, layoutParams2);
    }

    public void setDirDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public void setDirName(String str) {
        this.b.setText(str);
    }
}
