package com.ucweb.common.util.d;

import com.ucweb.common.util.c;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class a implements FileFilter {
    a() {
    }

    public final boolean accept(File file) {
        try {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
        } catch (Throwable th) {
            c.a(th.toString());
        }
        return false;
    }
}
