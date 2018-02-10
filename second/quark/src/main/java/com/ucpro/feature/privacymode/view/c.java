package com.ucpro.feature.privacymode.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class c implements OnKeyListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        b bVar = this.a;
        if (bVar.b == 0) {
            bVar.b = 4;
            z = true;
        } else if (bVar.a.length() > 0) {
            bVar.a.delete(bVar.b - 1, bVar.b);
            bVar.b--;
            if (a.a(bVar.c) || bVar.c.length() != 4) {
                bVar.c = bVar.a.toString();
            } else {
                bVar.d = bVar.a.toString();
            }
            bVar.e[bVar.a.length()].setImageDrawable(null);
        }
        return z ? true : true;
    }
}
