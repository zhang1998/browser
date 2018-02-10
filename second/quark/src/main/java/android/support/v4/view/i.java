package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class i {
    static void a(View view, int i) {
        view.offsetTopAndBottom(i);
        a(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent);
        }
    }

    static void b(View view, int i) {
        view.offsetLeftAndRight(i);
        a(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent);
        }
    }

    private static void a(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(IPictureView.DEFAULT_MIN_SCALE + translationY);
        view.setTranslationY(translationY);
    }
}
