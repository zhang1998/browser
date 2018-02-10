package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.util.Property;
import android.view.View;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class ButterKnife {
    static final Map<Class<?>, ViewBinder<Object>> BINDERS = new LinkedHashMap();
    static final ViewBinder<Object> NOP_VIEW_BINDER = new ViewBinder<Object>() {
        public final Unbinder bind(Finder finder, Object obj, Object obj2) {
            return Unbinder.EMPTY;
        }
    };
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    /* compiled from: ProGuard */
    public interface Action<T extends View> {
        void apply(@NonNull T t, int i);
    }

    /* compiled from: ProGuard */
    public interface Setter<T extends View, V> {
        void set(@NonNull T t, V v, int i);
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static Unbinder bind(@NonNull Activity activity) {
        return bind(activity, activity, Finder.ACTIVITY);
    }

    @NonNull
    public static Unbinder bind(@NonNull View view) {
        return bind(view, view, Finder.VIEW);
    }

    public static Unbinder bind(@NonNull Dialog dialog) {
        return bind(dialog, dialog, Finder.DIALOG);
    }

    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return bind(obj, activity, Finder.ACTIVITY);
    }

    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        return bind(obj, view, Finder.VIEW);
    }

    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return bind(obj, dialog, Finder.DIALOG);
    }

    static Unbinder bind(@NonNull Object obj, @NonNull Object obj2, @NonNull Finder finder) {
        Class cls = obj.getClass();
        try {
            if (debug) {
                new StringBuilder("Looking up view binder for ").append(cls.getName());
            }
            return findViewBinderForClass(cls).bind(finder, obj, obj2);
        } catch (Throwable e) {
            throw new RuntimeException("Unable to bind views for " + cls.getName(), e);
        }
    }

    @NonNull
    private static ViewBinder<Object> findViewBinderForClass(Class<?> cls) throws IllegalAccessException, InstantiationException {
        ViewBinder<Object> viewBinder = (ViewBinder) BINDERS.get(cls);
        if (viewBinder != null) {
            return viewBinder;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            return NOP_VIEW_BINDER;
        }
        try {
            viewBinder = (ViewBinder) Class.forName(name + "$$ViewBinder").newInstance();
        } catch (ClassNotFoundException e) {
            if (debug) {
                new StringBuilder("Not found. Trying superclass ").append(cls.getSuperclass().getName());
            }
            viewBinder = findViewBinderForClass(cls.getSuperclass());
        }
        BINDERS.put(cls, viewBinder);
        return viewBinder;
    }

    @SafeVarargs
    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T>... actionArr) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (Action apply : actionArr) {
                apply.apply((View) list.get(i), i);
            }
        }
    }

    @SafeVarargs
    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            for (Action apply : actionArr) {
                apply.apply(tArr[i], i);
            }
        }
    }

    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T> action) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.apply((View) list.get(i), i);
        }
    }

    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T> action) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            action.apply(tArr[i], i);
        }
    }

    @SafeVarargs
    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T>... actionArr) {
        for (Action apply : actionArr) {
            apply.apply(t, 0);
        }
    }

    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T> action) {
        action.apply(t, 0);
    }

    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Setter<? super T, V> setter, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            setter.set((View) list.get(i), v, i);
        }
    }

    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Setter<? super T, V> setter, V v) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            setter.set(tArr[i], v, i);
        }
    }

    public static <T extends View, V> void apply(@NonNull T t, @NonNull Setter<? super T, V> setter, V v) {
        setter.set(t, v, 0);
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Property<? super T, V> property, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            property.set(list.get(i), v);
        }
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Property<? super T, V> property, V v) {
        for (Object obj : tArr) {
            property.set(obj, v);
        }
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T t, @NonNull Property<? super T, V> property, V v) {
        property.set(t, v);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull View view, @IdRes int i) {
        return view.findViewById(i);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull Activity activity, @IdRes int i) {
        return activity.findViewById(i);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull Dialog dialog, @IdRes int i) {
        return dialog.findViewById(i);
    }
}
