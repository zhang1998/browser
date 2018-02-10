package com.ucpro.business.a.e;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class a extends FrameLayout implements OnClickListener {
    public LottieAnimationView a = null;
    public boolean b = false;
    private com.ucpro.business.a.d.a c = null;
    private b d = null;

    public a(Context context, com.ucpro.business.a.d.a aVar) {
        super(context);
        c.a((Object) aVar);
        this.c = aVar;
        this.a = new LottieAnimationView(getContext());
        this.a.setAnimation("searchcode/" + this.c.b + "/data.json");
        this.a.setImageAssetsFolder("searchcode/" + this.c.b + "/images");
        LayoutParams layoutParams = new FrameLayout.LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.searchcode_page_anim_width), com.ucpro.ui.c.a.c((int) R.dimen.searchcode_page_anim_width));
        layoutParams.gravity = 5;
        addView(this.a, layoutParams);
        this.a.setOnClickListener(this);
        setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.d != null) {
            if (view == this.a) {
                this.d.a();
            } else if (view == this) {
                this.d.b();
            }
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1 || this.d == null) {
            return true;
        }
        this.d.c();
        return true;
    }

    public final void setCallback(b bVar) {
        this.d = bVar;
    }
}
