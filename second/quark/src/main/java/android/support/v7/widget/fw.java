package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class fw extends ContextWrapper {
    private static final ArrayList<WeakReference<fw>> a = new ArrayList();
    private Resources b;
    private final Theme c;

    public static Context a(@NonNull Context context) {
        Object obj;
        if ((context instanceof fw) || (context.getResources() instanceof ez) || (context.getResources() instanceof ga)) {
            obj = null;
        } else if (!AppCompatDelegate.l() || VERSION.SDK_INT <= 20) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return context;
        }
        Context context2;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) a.get(i);
            context2 = weakReference != null ? (fw) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new fw(context);
        a.add(new WeakReference(context2));
        return context2;
    }

    private fw(@NonNull Context context) {
        super(context);
        if (ga.a()) {
            this.c = getResources().newTheme();
            this.c.setTo(context.getTheme());
            return;
        }
        this.c = null;
    }

    public final Theme getTheme() {
        return this.c == null ? super.getTheme() : this.c;
    }

    public final void setTheme(int i) {
        if (this.c == null) {
            super.setTheme(i);
        } else {
            this.c.applyStyle(i, true);
        }
    }

    public final Resources getResources() {
        if (this.b == null) {
            this.b = this.c == null ? new ez(this, super.getResources()) : new ga(this, super.getResources());
        }
        return this.b;
    }
}
