package com.ucpro.services.location;

import com.ucpro.model.a;
import com.ucpro.services.b.i;

/* compiled from: ProGuard */
final class m implements i {
    final /* synthetic */ boolean a;
    final /* synthetic */ LocationDex b;

    m(LocationDex locationDex, boolean z) {
        this.b = locationDex;
        this.a = z;
    }

    public final void b() {
        a.a("E5CBFD4E367C106B16211054C57997A2", -1);
        a.a("90A8FF3E62E9450FE8F82522FB6558E6", 0);
        if (!this.b.mIsLocationRequestStarted) {
            this.b.mIsLocationRequestStarted = true;
            this.b.mStartLocationRequestTime = System.currentTimeMillis();
            this.b.mLocationClient.a(this.a);
        }
    }
}
