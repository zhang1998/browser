package com.uc.quark;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.uc.quark.a.i;
import com.uc.quark.filedownloader.p;
import java.util.List;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ m a;
    final /* synthetic */ Context b;

    q(m mVar, Context context) {
        this.a = mVar;
        this.b = context;
    }

    public final void run() {
        Object obj;
        x.a(this.a.a());
        p.a.a = k.b().c();
        Context context = this.b;
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    obj = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        obj = null;
        if (i.a(this.b, this.b.getPackageName() + ":filedownloader") && !TextUtils.isEmpty(r0) && r0.equals(this.b.getPackageName())) {
            x.c();
        }
    }
}
