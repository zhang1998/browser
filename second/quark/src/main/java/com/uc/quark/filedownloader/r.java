package com.uc.quark.filedownloader;

import android.text.TextUtils;
import com.uc.quark.filedownloader.model.FileDownloadHeader;

/* compiled from: ProGuard */
public final class r {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public FileDownloadHeader h;
    private volatile Object i = new Object();

    public final r a(String str, String str2) {
        synchronized (this.i) {
            if (this.h == null) {
                this.h = new FileDownloadHeader();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            this.h.a(str, str2);
        }
        return this;
    }
}
