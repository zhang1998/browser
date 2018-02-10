package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class ga extends Resources {
    private final WeakReference<Context> a;

    public static boolean a() {
        return AppCompatDelegate.l() && VERSION.SDK_INT <= 20;
    }

    public ga(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) throws NotFoundException {
        Context context = (Context) this.a.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        fb a = fb.a();
        Drawable a2 = a.a(context, i);
        if (a2 == null) {
            a2 = super.getDrawable(i);
        }
        if (a2 != null) {
            return a.a(context, i, false, a2);
        }
        return null;
    }
}
