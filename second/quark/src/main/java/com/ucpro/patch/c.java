package com.ucpro.patch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
final class c extends Handler {
    final /* synthetic */ PatchService a;

    c(PatchService patchService, Looper looper) {
        this.a = patchService;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 10000) {
            Toast.makeText(d.a(), (String) message.obj, 1).show();
        } else if (message.what == 10001) {
            Process.killProcess(Process.myPid());
        }
    }
}
