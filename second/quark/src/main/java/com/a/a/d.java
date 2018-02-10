package com.a.a;

import android.content.Context;

/* compiled from: ProGuard */
public final class d {
    public String a = null;
    public String b = null;
    public boolean c = true;
    public a d = a.E_UM_NORMAL;
    public Context e = null;

    private d() {
    }

    public d(Context context, String str, String str2) {
        this.e = context;
        this.a = str;
        this.b = str2;
        this.c = false;
        switch (b.d(context)) {
            case 0:
                this.d = a.E_UM_NORMAL;
                return;
            case 1:
                this.d = a.E_UM_GAME;
                return;
            case 224:
                this.d = a.E_UM_ANALYTICS_OEM;
                return;
            case 225:
                this.d = a.E_UM_GAME_OEM;
                return;
            default:
                return;
        }
    }
}
