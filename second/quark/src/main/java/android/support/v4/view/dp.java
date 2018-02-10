package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ProGuard */
class dp extends da {
    dp() {
    }

    public final boolean A(View view) {
        return view.isOpaque();
    }

    public final void a(ViewGroup viewGroup) {
        if (h.a == null) {
            try {
                h.a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            h.a.setAccessible(true);
        }
        try {
            h.a.invoke(viewGroup, new Object[]{Boolean.valueOf(true)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
