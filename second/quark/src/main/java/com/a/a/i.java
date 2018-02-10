package com.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.a.a.a.ef;
import com.a.a.a.em;
import com.a.a.a.ey;
import com.a.a.a.fa;
import com.a.a.a.fw;

/* compiled from: ProGuard */
public final class i extends fa {
    final /* synthetic */ Context a;
    final /* synthetic */ e b;

    public i(e eVar, Context context) {
        this.b = eVar;
        this.a = context;
    }

    public final void a() {
        e eVar = this.b;
        Context applicationContext = this.a.getApplicationContext();
        try {
            if (eVar.a == null && applicationContext != null) {
                eVar.a = applicationContext.getApplicationContext();
            }
            if (eVar.c != null) {
                Context applicationContext2;
                if (eVar.a == null) {
                    applicationContext2 = applicationContext.getApplicationContext();
                } else {
                    applicationContext2 = eVar.a;
                }
                em.a = applicationContext2;
                SharedPreferences sharedPreferences = applicationContext2.getSharedPreferences("umeng_general_config", 0);
                if (sharedPreferences != null) {
                    Editor edit = sharedPreferences.edit();
                    int i = sharedPreferences.getInt("versioncode", 0);
                    int parseInt = Integer.parseInt(ey.a(em.a));
                    if (i != 0 && parseInt != i) {
                        try {
                            edit.putInt("vers_code", i);
                            edit.putString("vers_name", sharedPreferences.getString("versionname", ""));
                            edit.commit();
                        } catch (Throwable th) {
                        }
                        if (em.d(applicationContext2) == null) {
                            em.a(applicationContext2, sharedPreferences);
                        }
                        em.b(em.a);
                        ef.a(em.a).b();
                        em.c(em.a);
                        ef.a(em.a).a();
                    } else if (em.a(sharedPreferences)) {
                        fw.b("Start new session: " + em.a(applicationContext2, sharedPreferences));
                    } else {
                        String string = sharedPreferences.getString("session_id", null);
                        edit.putLong("a_start_time", System.currentTimeMillis());
                        edit.putLong("a_end_time", 0);
                        edit.commit();
                        fw.b("Extend current session: " + string);
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }
}
