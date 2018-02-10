package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* compiled from: ProGuard */
final class ao extends bl {
    ao() {
    }

    public final Notification a(cq cqVar) {
        Notification notification = cqVar.B;
        Context context = cqVar.a;
        CharSequence charSequence = cqVar.b;
        CharSequence charSequence2 = cqVar.c;
        PendingIntent pendingIntent = cqVar.d;
        PendingIntent pendingIntent2 = cqVar.e;
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        if (cqVar.j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
