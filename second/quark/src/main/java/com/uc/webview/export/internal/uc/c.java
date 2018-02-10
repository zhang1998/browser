package com.uc.webview.export.internal.uc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.b;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;

/* compiled from: ProGuard */
public final class c extends b {
    static Runnable f = new d();
    private static com.uc.webview.export.internal.utility.b g;

    /* compiled from: ProGuard */
    public final class a implements com.uc.webview.export.internal.utility.b.a {
        final /* synthetic */ c a;
        private Context b;

        public a(c cVar, Context context) {
            this.a = cVar;
            this.b = context.getApplicationContext();
        }

        public final void a() {
            Log.d("WebViewDetector", "onScreenOn: onScreenOn");
            c.g;
            if (!com.uc.webview.export.internal.utility.b.a(this.b) && SDKFactory.d != null) {
                SDKFactory.d.onScreenUnLock();
                SDKFactory.d.onResume();
                Log.d("WebViewDetector", "onScreenOn: onScreenUnLock");
            }
        }

        public final void b() {
            Log.d("WebViewDetector", "onScreenOff: onScreenOff");
            if (SDKFactory.d != null) {
                SDKFactory.d.onScreenLock();
                SDKFactory.d.onPause();
                Log.d("WebViewDetector", "onScreenOff: onScreenLock");
            }
        }

        public final void c() {
            Log.d("WebViewDetector", "onUserPresent: onUserPresent");
            if (SDKFactory.d != null) {
                SDKFactory.d.onScreenUnLock();
                SDKFactory.d.onResume();
                Log.d("WebViewDetector", "onUserPresent: onScreenUnLock");
            }
        }
    }

    public c(Context context) {
        if (!SDKFactory.f && g == null) {
            BroadcastReceiver bVar = new com.uc.webview.export.internal.utility.b(context);
            g = bVar;
            bVar.b = new a(this, context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            bVar.a.registerReceiver(bVar, intentFilter);
            if (com.uc.webview.export.internal.utility.b.a((PowerManager) bVar.a.getSystemService("power"))) {
                if (bVar.b != null) {
                    bVar.b.a();
                }
            } else if (bVar.b != null) {
                bVar.b.b();
            }
        }
    }

    public final void a(int i, int i2) {
        if (b != i || c != i2) {
            if (!(SDKFactory.f || SDKFactory.d == null)) {
                SDKFactory.d.onWindowSizeChanged();
            }
            b = i;
            c = i2;
        }
    }

    public final void a(IWebView iWebView, int i) {
        Log.d("WebViewDetector", "onWindowVisibilityChanged: " + i);
        iWebView.notifyForegroundChanged(i == 0);
        if (i == 0) {
            if (d != 1) {
                if (!(SDKFactory.f || SDKFactory.d == null)) {
                    SDKFactory.d.onResume();
                }
                Log.d("WebViewDetector", "WebViewDetector:onResume");
                d = 1;
            }
        } else if (d == 1) {
            e.removeCallbacks(f);
            e.post(f);
        }
    }

    public final void b(IWebView iWebView) {
        a.remove(iWebView);
        if (a.isEmpty()) {
            if (Utils.sWAPrintLog) {
                Log.d("SDKWaStat", "WebViewDetector:destroy");
            }
            WaStat.saveData(true);
        }
    }
}
