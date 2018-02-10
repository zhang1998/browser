package com.uc.apollo.media.base;

import com.uc.apollo.android.SystemProperties;
import java.util.Locale;

/* compiled from: ProGuard */
public final class d {
    public static final String a = SystemProperties.get("ro.board.platform", "").toUpperCase(Locale.getDefault());
}
