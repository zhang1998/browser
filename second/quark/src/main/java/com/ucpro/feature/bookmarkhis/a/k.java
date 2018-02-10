package com.ucpro.feature.bookmarkhis.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.business.stat.m;
import java.util.HashMap;

/* compiled from: ProGuard */
final class k implements OnDismissListener {
    final /* synthetic */ int a;
    final /* synthetic */ i b;

    k(i iVar, int i) {
        this.b = iVar;
        this.a = i;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        e.a;
        int i = this.a;
        boolean z = this.b.d;
        new StringBuilder("statHistoryDeleteAll: \ntotalCount: ").append(String.valueOf(i)).append("\nisDeleteAll: ").append(String.valueOf(z));
        HashMap hashMap = new HashMap();
        hashMap.put("click_delete_all", SettingsConst.TRUE);
        hashMap.put("count", String.valueOf(i));
        hashMap.put("click_delete_all_done", String.valueOf(z));
        m.a("histroy", "histroy_action", hashMap);
    }
}
