package com.ucpro.services.download.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.quark.browser.R;
import com.uc.quark.x;
import com.ucpro.c.b;
import com.ucpro.services.download.b.d;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
public class DonwloadBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (b.b()) {
                Log.e("vanda", "type: " + intent.getStringExtra("open_type"));
            }
            String stringExtra = intent.getStringExtra("open_type");
            if ("clear_notification".equals(stringExtra)) {
                d.b().c().cancel(4627);
            } else if ("start_all".equals(stringExtra)) {
                if (c.d()) {
                    x.a().n();
                } else {
                    e.a().a(context.getString(R.string.download_notification_wifi_change_tips), 1);
                }
            } else if ("pause_all".equals(stringExtra)) {
                x.a().j();
            }
        }
    }
}
