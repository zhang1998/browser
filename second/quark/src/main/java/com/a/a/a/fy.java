package com.a.a.a;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
public final class fy {
    File a;
    FilenameFilter b;
    private final int c;

    public fy(Context context) {
        this(context, ".um");
    }

    private fy(Context context, String str) {
        this.c = 10;
        this.b = new ex(this);
        this.a = new File(context.getFilesDir(), str);
        if (!this.a.exists() || !this.a.isDirectory()) {
            this.a.mkdir();
        }
    }
}
