package com.ucpro.feature.setting.b.f;

import android.content.Context;
import android.content.Intent;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.patch.PatchService;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class co implements i {
    public final void a() {
        Context a = d.a();
        Intent intent = new Intent(a, PatchService.class);
        intent.setPackage(a.getPackageName());
        a.startService(intent);
    }
}
