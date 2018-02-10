package butterknife.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;

/* compiled from: ProGuard */
public enum Finder {
    VIEW {
        protected final View findView(Object obj, int i) {
            return ((View) obj).findViewById(i);
        }

        public final Context getContext(Object obj) {
            return ((View) obj).getContext();
        }

        protected final String getResourceEntryName(Object obj, int i) {
            if (((View) obj).isInEditMode()) {
                return "<unavailable while editing>";
            }
            return super.getResourceEntryName(obj, i);
        }
    },
    ACTIVITY {
        protected final View findView(Object obj, int i) {
            return ((Activity) obj).findViewById(i);
        }

        public final Context getContext(Object obj) {
            return (Activity) obj;
        }
    },
    DIALOG {
        protected final View findView(Object obj, int i) {
            return ((Dialog) obj).findViewById(i);
        }

        public final Context getContext(Object obj) {
            return ((Dialog) obj).getContext();
        }
    };

    protected abstract View findView(Object obj, int i);

    public abstract Context getContext(Object obj);

    public <T> T findRequiredView(Object obj, int i, String str) {
        T findOptionalView = findOptionalView(obj, i, str);
        if (findOptionalView != null) {
            return findOptionalView;
        }
        throw new IllegalStateException("Required view '" + getResourceEntryName(obj, i) + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public <T> T findOptionalView(Object obj, int i, String str) {
        return castView(findView(obj, i), i, str);
    }

    public <T> T castView(View view, int i, String str) {
        return view;
    }

    public <T> T castParam(Object obj, String str, int i, String str2, int i2) {
        return obj;
    }

    protected String getResourceEntryName(Object obj, int i) {
        return getContext(obj).getResources().getResourceEntryName(i);
    }
}
