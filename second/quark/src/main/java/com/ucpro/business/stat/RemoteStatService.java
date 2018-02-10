package com.ucpro.business.stat;

import android.os.Process;
import com.uc.base.wa.component.WaStatService;

/* compiled from: ProGuard */
public class RemoteStatService extends WaStatService {
    protected final void a() {
        super.a();
        Process.killProcess(Process.myPid());
    }
}
