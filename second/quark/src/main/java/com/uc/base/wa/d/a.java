package com.uc.base.wa.d;

import android.util.Log;
import java.io.File;
import java.util.Comparator;

/* compiled from: ProGuard */
final class a implements Comparator<File> {
    a() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }

    private static int a(File file, File file2) {
        int i = -1;
        if (file == null || file2 == null) {
            return i;
        }
        if (file.equals(file2)) {
            return 0;
        }
        String name = file.getName();
        String name2 = file2.getName();
        if (name == null || name2 == null || name.length() < 2 || name2.length() < 2) {
            return i;
        }
        try {
            return name.substring(name.indexOf("_") + 1, name.indexOf(".wa")).compareTo(name2.substring(name2.indexOf("_") + 1, name2.indexOf(".wa")));
        } catch (Throwable e) {
            Log.e("gzm_wa_WaNet", name, e);
            return i;
        }
    }
}
