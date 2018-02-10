package android.support.v4.app;

import android.app.Notification;

/* compiled from: ProGuard */
class bl implements av {
    bl() {
    }

    public Notification a(cq cqVar) {
        Notification notification = cqVar.B;
        notification.setLatestEventInfo(cqVar.a, cqVar.b, cqVar.c, cqVar.d);
        if (cqVar.j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
