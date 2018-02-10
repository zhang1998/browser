package android.support.v4.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: ProGuard */
final class i extends d {
    private i() {
        super();
    }

    public final int a(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
