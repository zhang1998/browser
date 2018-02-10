package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* compiled from: ProGuard */
final class br extends bl {
    br() {
    }

    public final Notification a(cq cqVar) {
        boolean z;
        Context context = cqVar.a;
        Notification notification = cqVar.B;
        CharSequence charSequence = cqVar.b;
        CharSequence charSequence2 = cqVar.c;
        CharSequence charSequence3 = cqVar.h;
        RemoteViews remoteViews = cqVar.f;
        int i = cqVar.i;
        PendingIntent pendingIntent = cqVar.d;
        PendingIntent pendingIntent2 = cqVar.e;
        Bitmap bitmap = cqVar.g;
        Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights = lights.setOngoing(z);
        if ((notification.flags & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        lights = lights.setOnlyAlertOnce(z);
        if ((notification.flags & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        Builder deleteIntent = lights.setAutoCancel(z).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        return deleteIntent.setFullScreenIntent(pendingIntent2, z).setLargeIcon(bitmap).setNumber(i).getNotification();
    }
}
