package com.ucpro.feature.d.a;

import java.io.File;
import java.io.FileFilter;

/* compiled from: ProGuard */
final class c implements FileFilter {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    public final boolean accept(File file) {
        String name = file.getName();
        if (name == null || !name.startsWith("TMPSNAPSHOT") || name.equalsIgnoreCase(this.a.a)) {
            return false;
        }
        return true;
    }
}
