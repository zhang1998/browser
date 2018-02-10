package com.ucpro.feature.t.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ucpro.base.d.a;

/* compiled from: ProGuard */
public abstract class s extends ViewGroup implements a {
    public abstract View a(int i);

    public abstract int getFirstCardCurrentProcess();

    public abstract int getInitVisibileChildCount();

    public abstract int getScrollMaxProcess();

    public abstract int getScrollMinProcess();

    public s(Context context) {
        super(context);
    }
}
