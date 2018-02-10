package com.ucweb.common.util.o;

import java.io.File;

/* compiled from: ProGuard */
public final class c {
    public static final String a = Character.toString('.');
    private static final char b = File.separatorChar;
    private static final char c;

    static {
        if (a()) {
            c = '/';
        } else {
            c = '\\';
        }
    }

    public static boolean a() {
        return b == '\\';
    }
}
