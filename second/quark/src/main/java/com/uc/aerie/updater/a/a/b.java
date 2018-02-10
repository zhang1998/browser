package com.uc.aerie.updater.a.a;

import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class b implements ResultCallback {
    long a;
    final /* synthetic */ List b;
    final /* synthetic */ Throwable[] c;

    b(List list, Throwable[] thArr) {
        this.b = list;
        this.c = thArr;
    }

    public final void onStart(File file, File file2) {
        this.a = System.currentTimeMillis();
        String.format("start to parallel optimize dex %s, size: %d", new Object[]{file.getPath(), Long.valueOf(file.length())});
    }

    public final void onSuccess(File file, File file2, File file3) {
        String.format("success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[]{file.getPath(), file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - this.a)});
    }

    public final void onFailed(File file, File file2, Throwable th) {
        String.format("fail to parallel optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.a)});
        this.b.add(file);
        this.c[0] = th;
    }
}
