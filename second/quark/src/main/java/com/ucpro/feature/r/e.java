package com.ucpro.feature.r;

import android.content.Context;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.quark.n;
import com.uc.quark.x;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.m;
import com.ucweb.a.u;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class e {
    public static void a(u uVar, Context context) {
        if (uVar != null) {
            c.a((Object) context);
            if (com.ucweb.common.util.i.c.d()) {
                a(uVar);
                return;
            }
            m mVar = new m(context);
            mVar.a(1);
            mVar.a(a.d((int) R.string.download_continue_item), a.d((int) R.string.download_wait_wifi));
            mVar.a(a.d((int) R.string.download_dialog_tips));
            mVar.a(new c(uVar));
            mVar.show();
        }
    }

    static void a(u uVar) {
        if (uVar != null && !com.ucweb.common.util.n.a.a(uVar.c)) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.task_downloading), a.d((int) R.string.click_to_see), new g());
            n nVar = new n();
            nVar.a = uVar.d;
            nVar.d = a.d((int) R.string.app_name) + System.currentTimeMillis() + ShareConstants.PATCH_SUFFIX;
            nVar.c = "application/vnd.android.package-archive";
            nVar.i = true;
            nVar.j = uVar.b + "|" + uVar.n;
            nVar.l = true;
            x.a().a(nVar.a()).k();
        }
    }
}
