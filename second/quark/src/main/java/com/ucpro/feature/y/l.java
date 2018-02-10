package com.ucpro.feature.y;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class l {
    public ArrayList<WeakReference<r>> a = new ArrayList();
    public View b;

    public final void a(r rVar) {
        if (rVar != null && this.b != null) {
            View view = this.b;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            View view2 = this.b;
            if (view2 != null) {
                if (rVar.a.getVisibility() == 0) {
                    rVar.a.setVisibility(8);
                }
                rVar.addView(view2, -1, -1);
            }
        }
    }
}
