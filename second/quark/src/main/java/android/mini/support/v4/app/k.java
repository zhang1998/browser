package android.mini.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.mini.support.annotation.Nullable;
import android.os.Bundle;

/* compiled from: ProGuard */
abstract class k extends j {
    boolean b;

    k() {
    }

    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        if (!(this.b || i == -1)) {
            i.a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (!(this.a || i == -1)) {
            i.a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
