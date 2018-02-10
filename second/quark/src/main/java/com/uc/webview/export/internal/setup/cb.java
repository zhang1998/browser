package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.utility.download.UpdateTask;

/* compiled from: ProGuard */
final class cb implements ValueCallback<UpdateTask> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "downloadException"));
    final /* synthetic */ bu b;

    cb(bu buVar) {
        this.b = buVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UpdateTask updateTask = (UpdateTask) obj;
        if (this.b.getExtraException() == null) {
            Object simpleName;
            Throwable exception = updateTask.getException();
            String str = "";
            String str2 = "";
            String str3 = "";
            Object obj2 = "";
            UCKnownException uCKnownException = exception instanceof UCKnownException ? (UCKnownException) exception : new UCKnownException(exception);
            str = str + uCKnownException.errCode();
            try {
                str3 = uCKnownException.getRootCause().getMessage();
            } catch (Throwable th) {
            }
            try {
                obj2 = String.valueOf(Integer.parseInt(str3.substring(str3.indexOf("httpcode:") + 9)));
            } catch (Throwable th2) {
            }
            try {
                simpleName = uCKnownException.getRootCause().getClass().getSimpleName();
            } catch (Throwable th3) {
                return;
            }
            this.b.callbackStat(new Pair(IWaStat.SETUP_TASK_UPDATE, new UCHashMap().set("cnt", SettingsConst.TRUE).set("code", obj2).set("err", str).set("cls", simpleName).set("msg", str3)));
        }
        if (updateTask.getException() != null) {
            if (updateTask.getException() instanceof UCSetupException) {
                this.b.setExtraException((UCSetupException) updateTask.getException());
            } else {
                this.b.setExtraException(new UCSetupException(updateTask.getException()));
            }
        }
        if (this.a != null) {
            this.a.onReceiveValue(this.b);
        }
    }
}
