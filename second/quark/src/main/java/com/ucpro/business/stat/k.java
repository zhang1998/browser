package com.ucpro.business.stat;

import android.content.SharedPreferences;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class k {
    public static n a() {
        String string = b().getString("state", n.NIL.toString());
        try {
            return n.valueOf(string);
        } catch (Exception e) {
            c.a("convert " + string + " to StateType fail");
            return n.NIL;
        }
    }

    static SharedPreferences b() {
        return d.a().getSharedPreferences("__cf", 0);
    }
}
