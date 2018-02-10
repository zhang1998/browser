package com.ucpro.feature.video.player.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.ucpro.feature.video.player.view.am;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class c extends AsyncTask<String, Integer, Integer> {
    private Context a;
    private WeakReference<p> b;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            int i;
            if (num.intValue() > 70) {
                i = am.c;
            } else if (num.intValue() > 30) {
                i = am.b;
            } else if (num.intValue() > 0) {
                i = am.a;
            } else {
                i = am.d;
            }
            p pVar = (p) this.b.get();
            if (pVar != null) {
                pVar.b.setBatteryStatus$1bf19a6c(i);
                pVar.d.setBatteryStatus$1bf19a6c(i);
            }
        }
    }

    public c(Context context, p pVar) {
        this.a = context;
        this.b = new WeakReference(pVar);
    }

    private Integer a() {
        try {
            Intent registerReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver.getIntExtra(INoCaptchaComponent.status, -1) == 2) {
                return Integer.valueOf(-1);
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return Integer.valueOf(50);
            }
            return Integer.valueOf((int) ((((float) intExtra) * 100.0f) / ((float) intExtra2)));
        } catch (Exception e) {
            return Integer.valueOf(50);
        }
    }
}
