package com.bumptech.glide.b.b.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class a implements FilenameFilter {
    final /* synthetic */ Pattern a;

    a(Pattern pattern) {
        this.a = pattern;
    }

    public final boolean accept(File file, String str) {
        return this.a.matcher(str).matches();
    }
}
