package android.mini.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* compiled from: ProGuard */
final class f {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
