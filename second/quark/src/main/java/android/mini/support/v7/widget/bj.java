package android.mini.support.v7.widget;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;

/* compiled from: ProGuard */
public abstract class bj extends ItemAnimator {
    boolean m = true;

    public abstract boolean a(bf bfVar);

    public abstract boolean a(bf bfVar, int i, int i2, int i3, int i4);

    public abstract boolean a(bf bfVar, bf bfVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(bf bfVar);

    public final boolean g(@NonNull bf bfVar) {
        return !this.m || bfVar.j();
    }

    public final boolean a(@NonNull bf bfVar, @NonNull ar arVar, @Nullable ar arVar2) {
        int i = arVar.a;
        int i2 = arVar.b;
        View view = bfVar.a;
        int left = arVar2 == null ? view.getLeft() : arVar2.a;
        int top = arVar2 == null ? view.getTop() : arVar2.b;
        if (bfVar.m() || (i == left && i2 == top)) {
            return a(bfVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(bfVar, i, i2, left, top);
    }

    public final boolean b(@NonNull bf bfVar, @Nullable ar arVar, @NonNull ar arVar2) {
        if (arVar == null || (arVar.a == arVar2.a && arVar.b == arVar2.b)) {
            return b(bfVar);
        }
        return a(bfVar, arVar.a, arVar.b, arVar2.a, arVar2.b);
    }

    public final boolean c(@NonNull bf bfVar, @NonNull ar arVar, @NonNull ar arVar2) {
        if (arVar.a == arVar2.a && arVar.b == arVar2.b) {
            f(bfVar);
            return false;
        }
        return a(bfVar, arVar.a, arVar.b, arVar2.a, arVar2.b);
    }

    public final boolean a(@NonNull bf bfVar, @NonNull bf bfVar2, @NonNull ar arVar, @NonNull ar arVar2) {
        int i;
        int i2;
        int i3 = arVar.a;
        int i4 = arVar.b;
        if (bfVar2.b()) {
            i = arVar.a;
            i2 = arVar.b;
        } else {
            i = arVar2.a;
            i2 = arVar2.b;
        }
        return a(bfVar, bfVar2, i3, i4, i, i2);
    }
}
