package com.ucpro.feature.lightapp.channelpage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.d.b;
import com.ucpro.business.stat.a.a;
import com.ucpro.business.stat.a.d;

/* compiled from: ProGuard */
public final class e extends b implements d {
    private l e;

    public e(Context context) {
        super(context);
    }

    public final void setPresenter(b bVar) {
        super.setPresenter(bVar);
        this.e = (l) bVar;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1 || this.e == null) {
            return true;
        }
        this.e.f();
        return true;
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.e.a(i);
    }

    public final String getSpm() {
        return a.a("8995302");
    }

    public final String getPageName() {
        return "Page_lightapp_channel";
    }
}
