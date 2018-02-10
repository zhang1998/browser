package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class BaseHintView extends FrameLayout {
    private Context a;
    private LinearLayout b;
    private ImageView c;
    private av d;

    public BaseHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    public BaseHintView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public void setImage(Drawable drawable) {
        this.c.setImageDrawable(drawable);
    }

    public void setText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public void setTextSize(float f) {
        this.d.setTextSize(0, f);
    }

    protected LayoutParams getImageLayoutParams() {
        int c = a.c((int) R.dimen.player_center_hint_margin);
        int c2 = a.c((int) R.dimen.player_center_hint_img_size);
        LayoutParams layoutParams = new LayoutParams(c2, c2);
        layoutParams.setMargins(0, 0, c, 0);
        return layoutParams;
    }

    protected LayoutParams getTextLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void a() {
        setBackgroundDrawable(a.a("new_video_tip_bg.svg"));
        this.b = new LinearLayout(this.a);
        this.b.setOrientation(0);
        this.b.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.b, layoutParams);
        this.c = new ImageView(this.a);
        av avVar = new av(this.a);
        avVar.setGravity(17);
        avVar.setTextSize(0, (float) a.c((int) R.dimen.player_center_hint_text_szie));
        avVar.setTextColor(a.c("player_menu_text_color"));
        avVar.setSingleLine();
        this.d = avVar;
        this.b.addView(this.c, getImageLayoutParams());
        this.b.addView(this.d, getTextLayoutParams());
    }
}
