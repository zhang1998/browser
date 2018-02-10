package com.uc.crashsdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.i;
import java.io.File;

/* compiled from: ProGuard */
public class CrashLogFilesUploader extends Service {
    private final Handler a = new i(this);
    private boolean b = false;

    static /* synthetic */ void a() {
        c.b("Service uploading logs ...");
        f.a(f.f(), true, true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (p.a()) {
            if (!this.b) {
                this.b = true;
                i.a(1, new j(this));
            }
            return 2;
        }
        throw new RuntimeException("Must initialize crashsdk for current process (" + f.d() + ", " + Process.myPid() + "), or set CustomInfo.mUploadUcebuCrashLog as false!");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(Context context) {
        String O = p.O();
        File file = new File(O);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                c.c("Ucebu can not list folder: " + O);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    try {
                        context.startService(new Intent(context, CrashLogFilesUploader.class));
                        return;
                    } catch (Throwable e) {
                        a.a(e, false);
                        return;
                    }
                }
            }
        }
    }
}
