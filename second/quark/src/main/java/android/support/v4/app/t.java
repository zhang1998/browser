package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

/* compiled from: ProGuard */
final class t {
    public static void a(Builder builder, b bVar) {
        Action.Builder builder2 = new Action.Builder(bVar.a(), bVar.b(), bVar.c());
        if (bVar.e() != null) {
            for (RemoteInput addRemoteInput : u.a(bVar.e())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (bVar.d() != null) {
            builder2.addExtras(bVar.d());
        }
        builder.addAction(builder2.build());
    }
}
