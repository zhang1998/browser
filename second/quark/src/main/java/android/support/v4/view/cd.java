package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ProGuard */
final class cd extends cs {
    cd() {
    }

    public final boolean a(ViewParent viewParent, View view, View view2, int i) {
        return ab.a(viewParent, view, view2, i);
    }

    public final boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return ab.a(viewParent, view, f, f2, z);
    }

    public final boolean a(ViewParent viewParent, View view, float f, float f2) {
        return ab.a(viewParent, view, f, f2);
    }

    public final void b(ViewParent viewParent, View view, View view2, int i) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
        }
    }

    public final void a(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
        }
    }

    public final void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
        }
    }

    public final void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view, i, i2, iArr);
        } catch (Throwable e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
        }
    }
}
