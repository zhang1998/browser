package com.alibaba.analytics.core.db;

import android.content.Context;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.b;
import java.io.File;

/* compiled from: ProGuard */
public final class f {
    private static String a = "usertrack.db";

    public static void a() {
        Context context = b.a().b;
        if (context != null) {
            File databasePath = context.getDatabasePath(a);
            if (databasePath.exists()) {
                i.a();
                i.a(new e(context, databasePath));
            }
        }
    }
}
