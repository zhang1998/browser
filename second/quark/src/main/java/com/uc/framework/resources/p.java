package com.uc.framework.resources;

import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* compiled from: ProGuard */
final class p extends ab {
    int[][] a;

    p(p pVar, q qVar) {
        super(pVar, qVar);
        if (pVar != null) {
            this.a = pVar.a;
        } else {
            this.a = new int[this.e.length][];
        }
    }

    public final Drawable newDrawable() {
        return new q();
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        Object obj = new int[i2][];
        System.arraycopy(this.a, 0, obj, 0, i);
        this.a = obj;
    }

    static /* synthetic */ int a(p pVar, int[] iArr) {
        int[][] iArr2 = pVar.a;
        int i = pVar.f;
        for (int i2 = 0; i2 < i; i2++) {
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                return i2;
            }
        }
        return -1;
    }
}
