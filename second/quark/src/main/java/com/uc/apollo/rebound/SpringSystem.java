package com.uc.apollo.rebound;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Choreographer;
import com.uc.apollo.annotation.KeepForRuntime;

/* compiled from: ProGuard */
public class SpringSystem extends BaseSpringSystem {
    @KeepForRuntime
    public static SpringSystem create() {
        f aVar;
        if (VERSION.SDK_INT >= 16) {
            aVar = new a(Choreographer.getInstance());
        } else {
            aVar = new b(new Handler());
        }
        return new SpringSystem(aVar);
    }

    private SpringSystem(f fVar) {
        super(fVar);
    }
}
