package com.ucpro.feature.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.ucpro.base.c.b.v;
import com.ucweb.common.util.f;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class b implements v {
    public final View a(Context context) {
        View aVar = new a(context);
        aVar.setLayoutParams(new LayoutParams(-1, f.b(context)));
        if (f.a.a()) {
            aVar.setVisibility(0);
        } else {
            aVar.setVisibility(8);
        }
        f.a.a.add(new WeakReference(aVar));
        return aVar;
    }
}
