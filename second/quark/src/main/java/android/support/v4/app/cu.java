package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class cu implements Iterable<Intent> {
    private static final cj c;
    public final ArrayList<Intent> a = new ArrayList();
    public final Context b;

    static {
        if (VERSION.SDK_INT >= 11) {
            c = new af();
        } else {
            c = new ch();
        }
    }

    private cu(Context context) {
        this.b = context;
    }

    public static cu a(Context context) {
        return new cu(context);
    }

    public final cu a(ComponentName componentName) {
        int size = this.a.size();
        try {
            Intent a = ax.a(this.b, componentName);
            while (a != null) {
                this.a.add(size, a);
                a = ax.a(this.b, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.a.iterator();
    }
}
