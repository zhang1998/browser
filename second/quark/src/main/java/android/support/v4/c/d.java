package android.support.v4.c;

import android.support.annotation.Nullable;
import java.util.Locale;

/* compiled from: ProGuard */
class d {
    private d() {
    }

    public int a(@Nullable Locale locale) {
        if (!(locale == null || locale.equals(c.a))) {
            String a = j.a(locale);
            if (a == null) {
                switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                    case (byte) 1:
                    case (byte) 2:
                        return 1;
                    default:
                        return 0;
                }
            } else if (a.equalsIgnoreCase(c.c) || a.equalsIgnoreCase(c.d)) {
                return 1;
            }
        }
        return 0;
    }
}
