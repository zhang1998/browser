package com.ucweb.common.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class k implements FileFilter {
    k() {
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
