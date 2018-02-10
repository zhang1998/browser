package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: ProGuard */
final class a extends Handler {
    final /* synthetic */ MediaBrowserServiceCompat a;
    private final h b;

    private a(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.a = mediaBrowserServiceCompat;
        this.b = new h(this.a);
    }

    public final void handleMessage(Message message) {
        Bundle data = message.getData();
        h hVar;
        h hVar2;
        String string;
        switch (message.what) {
            case 1:
                hVar = this.b;
                String string2 = data.getString("data_package_name");
                int i = data.getInt("data_calling_uid");
                Bundle bundle = data.getBundle("data_root_hints");
                n jVar = new j(this.a, message.replyTo);
                if (MediaBrowserServiceCompat.a(hVar.a, string2, i)) {
                    hVar.a.c.a(new x(hVar, jVar, string2, bundle, i));
                    return;
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string2);
            case 2:
                hVar2 = this.b;
                hVar2.a.c.a(new m(hVar2, new j(this.a, message.replyTo)));
                return;
            case 3:
                hVar = this.b;
                string = data.getString("data_media_item_id");
                data = data.getBundle("data_options");
                hVar.a.c.a(new w(hVar, new j(this.a, message.replyTo), string, data));
                return;
            case 4:
                hVar = this.b;
                string = data.getString("data_media_item_id");
                data = data.getBundle("data_options");
                hVar.a.c.a(new k(hVar, new j(this.a, message.replyTo), string, data));
                return;
            case 5:
                hVar = this.b;
                Object string3 = data.getString("data_media_item_id");
                ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                    hVar.a.c.a(new q(hVar, string3, resultReceiver));
                    return;
                }
                return;
            case 6:
                hVar2 = this.b;
                hVar2.a.c.a(new t(hVar2, new j(this.a, message.replyTo)));
                return;
            case 7:
                hVar2 = this.b;
                hVar2.a.c.a(new o(hVar2, new j(this.a, message.replyTo)));
                return;
            default:
                Log.w("MediaBrowserServiceCompat", "Unhandled message: " + message + "\n  Service version: 1\n  Client version: " + message.arg1);
                return;
        }
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        return super.sendMessageAtTime(message, j);
    }

    private void a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
