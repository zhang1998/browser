package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;

/* compiled from: ProGuard */
public abstract class g extends ItemAnimator {
    boolean a = true;

    public abstract boolean a(bh bhVar, int i, int i2, int i3, int i4);

    public abstract boolean a(bh bhVar, bh bhVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(bh bhVar);

    public abstract boolean c(bh bhVar);

    public final boolean a(@NonNull bh bhVar) {
        return !this.a || bhVar.j();
    }

    public final boolean a(@NonNull bh bhVar, @NonNull m mVar, @Nullable m mVar2) {
        int i = mVar.a;
        int i2 = mVar.b;
        View view = bhVar.a;
        int left = mVar2 == null ? view.getLeft() : mVar2.a;
        int top = mVar2 == null ? view.getTop() : mVar2.b;
        if (bhVar.m() || (i == left && i2 == top)) {
            return b(bhVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(bhVar, i, i2, left, top);
    }

    public final boolean b(@NonNull bh bhVar, @Nullable m mVar, @NonNull m mVar2) {
        if (mVar == null || (mVar.a == mVar2.a && mVar.b == mVar2.b)) {
            return c(bhVar);
        }
        return a(bhVar, mVar.a, mVar.b, mVar2.a, mVar2.b);
    }

    public final boolean c(@NonNull bh bhVar, @NonNull m mVar, @NonNull m mVar2) {
        if (mVar.a == mVar2.a && mVar.b == mVar2.b) {
            g(bhVar);
            return false;
        }
        return a(bhVar, mVar.a, mVar.b, mVar2.a, mVar2.b);
    }

    public final boolean a(@NonNull bh bhVar, @NonNull bh bhVar2, @NonNull m mVar, @NonNull m mVar2) {
        int i;
        int i2;
        int i3 = mVar.a;
        int i4 = mVar.b;
        if (bhVar2.b()) {
            i = mVar.a;
            i2 = mVar.b;
        } else {
            i = mVar2.a;
            i2 = mVar2.b;
        }
        return a(bhVar, bhVar2, i3, i4, i, i2);
    }
}
