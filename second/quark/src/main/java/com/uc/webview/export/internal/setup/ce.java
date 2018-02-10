package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.utility.download.UpdateTask;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class ce implements ValueCallback<UpdateTask> {
    final /* synthetic */ Context a;
    final /* synthetic */ Callable b;
    final /* synthetic */ bu c;

    ce(bu buVar, Context context, Callable callable) {
        this.c = buVar;
        this.a = context;
        this.b = callable;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Object obj2 = null;
        try {
            File file = (File) UCMPackageInfo.invoke(10002, this.a);
            UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
            if (totalLoadedUCM.ucmPackageInfo != null) {
                String str = totalLoadedUCM.ucmPackageInfo.dataDir;
                if (str != null) {
                    File file2 = new File(str);
                    if (file2.getAbsolutePath().startsWith(file.getAbsolutePath())) {
                        File file3 = file2;
                    }
                }
            }
            if (obj2 == null) {
                obj2 = this.c.a.getUpdateDir();
            }
            UCCyclone.recursiveDelete(file, true, obj2);
        } catch (Throwable th) {
        }
        try {
            if (this.b == null || ((Boolean) this.b.call()).booleanValue()) {
                this.c.callbackStat(new Pair(IWaStat.UCM_WIFI, null));
                return;
            }
            throw new RuntimeException("Update should be in wifi network.");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
