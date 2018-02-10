package android.support.a.a;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.d.b;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class o extends ConstantState {
    int a;
    c b;
    ArrayList<Animator> c;
    b<Animator, String> d;

    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public final int getChangingConfigurations() {
        return this.a;
    }
}
