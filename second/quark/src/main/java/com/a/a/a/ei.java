package com.a.a.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: ProGuard */
final class ei implements ActivityLifecycleCallbacks {
    final /* synthetic */ eo a;

    ei(eo eoVar) {
        this.a = eoVar;
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityResumed(Activity activity) {
        this.a.a(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.a.a();
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }
}
