package com.ucpro.feature.navigation.view;

import android.view.View;

/* compiled from: ProGuard */
final class am implements Runnable {
    final /* synthetic */ aq a;

    am(aq aqVar) {
        this.a = aqVar;
    }

    public final void run() {
        aq aqVar = this.a;
        if (aqVar.g() && !aqVar.f) {
            for (int i = 0; i < aqVar.a.getChildCount(); i++) {
                View childAt = aqVar.a.getChildAt(i);
                if (childAt instanceof e) {
                    ((e) childAt).a(700);
                    return;
                }
            }
        }
    }
}
