package com.ucpro.feature.setting.b.d.b;

import android.content.Context;
import android.view.animation.RotateAnimation;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.setting.b.b.b;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class g extends h {
    private b e;
    private RotateAnimation f;

    public g(Context context, b bVar) {
        super(context);
        this.e = bVar;
        c.a(this.e);
        a();
    }

    protected final void a() {
        super.a();
        this.d.setImageDrawable(a.a("searchpage_search_associate_list_fill.svg"));
        this.f = getRotationAnimation();
    }

    public final void b() {
        this.b.setText(this.e.a);
    }

    protected final void c() {
        if (this.e != null) {
            i iVar = this.e.c;
            if (iVar != null) {
                iVar.a();
                this.d.startAnimation(this.f);
                return;
            }
            c.a("IDeveloperItemClick == null");
            return;
        }
        c.a("mDeveloperSettingClickConfig == null");
    }

    private RotateAnimation getRotationAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setFillAfter(true);
        return rotateAnimation;
    }
}
