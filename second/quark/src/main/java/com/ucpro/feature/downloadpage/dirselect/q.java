package com.ucpro.feature.downloadpage.dirselect;

import java.io.File;
import java.io.FileFilter;

/* compiled from: ProGuard */
final class q implements FileFilter {
    q() {
    }

    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
