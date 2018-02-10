package com.a.a.a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
final class ex implements FilenameFilter {
    final /* synthetic */ fy a;

    ex(fy fyVar) {
        this.a = fyVar;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith("um");
    }
}
