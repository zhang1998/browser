package com.ucpro.business.b;

import com.uc.crashsdk.export.ICrashClient;
import java.io.File;

/* compiled from: ProGuard */
final class b implements ICrashClient {
    private b() {
    }

    public final void onLogGenerated(File file, String str) {
    }

    public final void onCrashRestarting(boolean z) {
    }

    public final boolean onAddCrashStats(String str, int i, int i2) {
        return false;
    }

    public final String onGetCallbackInfo(String str) {
        if ("All Thread list:".equals(str)) {
            return a.d();
        }
        return "";
    }

    public final File onBeforeUploadLog(File file) {
        return file;
    }
}
