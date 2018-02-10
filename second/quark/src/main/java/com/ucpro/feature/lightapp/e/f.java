package com.ucpro.feature.lightapp.e;

import android.content.Context;
import com.ucpro.base.d.b;
import com.ucpro.business.stat.a.a;
import com.ucpro.business.stat.a.d;

/* compiled from: ProGuard */
public final class f extends e implements d {
    private g e;

    public f(Context context) {
        super(context);
        setEnableGestureLimited(false);
    }

    public final void setPresenter(b bVar) {
        super.setPresenter(bVar);
        this.e = (g) bVar;
    }

    public final String getSpm() {
        return a.a("9133882");
    }

    public final String getPageName() {
        return "Page_lightapp_article";
    }
}
