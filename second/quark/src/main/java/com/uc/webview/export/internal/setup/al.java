package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.SetupTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ProGuard */
final class al implements ValueCallback<SetupTask> {
    LinkedList<Pair<String, HashMap<String, String>>> a = new LinkedList();
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ ae c;

    al(ae aeVar, ValueCallback valueCallback) {
        this.c = aeVar;
        this.b = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Object obj2 = null;
        SetupTask setupTask = (SetupTask) obj;
        if (setupTask.getStat().second == null) {
            WaStat.stat((String) setupTask.getStat().first);
            return;
        }
        this.a.add(setupTask.getStat());
        Object obj3 = UCSetupTask.getTotalLoadedUCM() != null ? 1 : null;
        Object obj4 = (obj3 == null || UCSetupTask.getTotalLoadedUCM().coreType != 2) ? null : 1;
        if (!(obj3 == null || UCSetupTask.getTotalLoadedUCM().coreType == 2)) {
            obj2 = 1;
        }
        if (((String) setupTask.getStat().first).equals(IWaStat.SETUP_TOTAL_EXCEPTION) || obj4 != null || Log.sPrintLog) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (this.b == null) {
                    WaStat.statAKV(pair);
                } else {
                    setupTask.mStat = pair;
                    this.b.onReceiveValue(setupTask);
                }
            }
            this.a.clear();
        } else if (obj2 != null) {
            this.a.clear();
        }
    }
}
