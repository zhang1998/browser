package com.loc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amap.api.fence.Fence;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class do {
    Context a;
    Hashtable<PendingIntent, ArrayList<Fence>> b = new Hashtable();

    public do(Context context) {
        this.a = context;
    }

    static boolean a(Fence fence) {
        return fence.b() != -1 && fence.b() <= dm.b();
    }

    final void a(PendingIntent pendingIntent, Fence fence, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("fenceid", fence.b);
        bundle.putInt("event", i);
        intent.putExtras(bundle);
        try {
            pendingIntent.send(this.a, 0, intent);
        } catch (Throwable th) {
            cq.a(th, "FenceManager", "fcIntent");
        }
    }

    final boolean a(PendingIntent pendingIntent, List<String> list) {
        boolean z = false;
        if (!(this.b.isEmpty() || list.isEmpty() || !this.b.containsKey(pendingIntent))) {
            Iterator it = ((ArrayList) this.b.get(pendingIntent)).iterator();
            while (it != null && it.hasNext()) {
                boolean z2;
                Fence fence = (Fence) it.next();
                if (list.contains(fence.b) || a(fence)) {
                    it.remove();
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
        }
        return z;
    }
}
