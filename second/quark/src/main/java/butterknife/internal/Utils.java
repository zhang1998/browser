package butterknife.internal;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.b.a.q;
import android.util.TypedValue;
import java.lang.reflect.Array;
import java.util.List;

/* compiled from: ProGuard */
public final class Utils {
    private static final boolean HAS_SUPPORT_V4 = hasSupportV4();

    /* compiled from: ProGuard */
    class SupportV4 {
        private static final TypedValue OUT_VALUE = new TypedValue();

        SupportV4() {
        }

        static Drawable getTintedDrawable(Resources resources, Theme theme, @DrawableRes int i, @AttrRes int i2) {
            if (theme.resolveAttribute(i2, OUT_VALUE, true)) {
                Drawable f = q.f(Utils.getDrawable(resources, theme, i).mutate());
                q.a(f, Utils.getColor(resources, theme, OUT_VALUE.resourceId));
                return f;
            }
            throw new NotFoundException("Required tint color attribute with name " + resources.getResourceEntryName(i2) + " and attribute ID " + i2 + " was not found.");
        }
    }

    private static boolean hasSupportV4() {
        try {
            Class.forName("android.support.v4.b.a.q");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (VerifyError e2) {
            return false;
        }
    }

    public static Drawable getTintedDrawable(Resources resources, Theme theme, @DrawableRes int i, @AttrRes int i2) {
        if (HAS_SUPPORT_V4) {
            return SupportV4.getTintedDrawable(resources, theme, i, i2);
        }
        throw new RuntimeException("Android support-v4 library is required for @BindDrawable with tint.");
    }

    public static int getColor(Resources resources, Theme theme, @ColorRes int i) {
        if (VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        return resources.getColor(i, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, Theme theme, @ColorRes int i) {
        if (VERSION.SDK_INT < 23) {
            return resources.getColorStateList(i);
        }
        return resources.getColorStateList(i, theme);
    }

    public static Drawable getDrawable(Resources resources, Theme theme, @DrawableRes int i) {
        if (VERSION.SDK_INT < 21) {
            return resources.getDrawable(i);
        }
        return resources.getDrawable(i, theme);
    }

    @SafeVarargs
    public static <T> T[] arrayOf(T... tArr) {
        return filterNull(tArr);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... tArr) {
        return new ImmutableList(filterNull(tArr));
    }

    private static <T> T[] filterNull(T[] tArr) {
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            T t = tArr[i];
            if (t != null) {
                i3 = i2 + 1;
                tArr[i2] = t;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 == length) {
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
        System.arraycopy(tArr, 0, tArr2, 0, i2);
        return tArr2;
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }
}
