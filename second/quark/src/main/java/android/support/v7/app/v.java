package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
final class v implements OnClickListener {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public v(@NonNull View view, @NonNull String str) {
        this.a = view;
        this.b = str;
    }

    public final void onClick(@NonNull View view) {
        if (this.c == null) {
            String str;
            Context context = this.a.getContext();
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        Method method = context.getClass().getMethod(this.b, new Class[]{View.class});
                        if (method != null) {
                            this.c = method;
                            this.d = context;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str);
        }
        try {
            this.c.invoke(this.d, new Object[]{view});
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Could not execute method for android:onClick", e22);
        }
    }
}
