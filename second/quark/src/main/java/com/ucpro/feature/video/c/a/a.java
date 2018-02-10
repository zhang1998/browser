package com.ucpro.feature.video.c.a;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ucpro.business.stat.m;
import com.ucpro.feature.video.c.e.c.b;
import com.ucpro.feature.video.c.e.c.c;
import com.ucpro.feature.video.c.e.c.d;
import com.ucweb.common.util.i.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a {
    @Nullable
    public static ArrayList<String> a(@NonNull c cVar, String str) {
        Collection collection = cVar.c;
        com.ucweb.common.util.c.a(collection);
        ArrayList<String> arrayList = new ArrayList(1);
        if (collection != null && collection.size() > 0) {
            for (int i = 0; i < collection.size(); i++) {
                b bVar = (b) collection.get(i);
                if (bVar != null) {
                    Object obj;
                    if (bVar.a == null) {
                        obj = null;
                    } else {
                        obj = bVar.a.toString();
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str)) {
                        ArrayList arrayList2 = bVar.b;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                d dVar = (d) it.next();
                                if (dVar != null) {
                                    Object obj2;
                                    if (dVar.a == null) {
                                        obj2 = null;
                                    } else {
                                        obj2 = dVar.a.toString();
                                    }
                                    arrayList.add(obj2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static void a(Handler handler, String str, ArrayList<String> arrayList, com.ucpro.feature.video.c.a aVar) {
        com.ucweb.common.util.c.a((Object) arrayList);
        com.ucweb.common.util.c.a((Object) aVar);
        com.ucweb.common.util.c.a((Object) handler);
        handler.post(new d(aVar, str, arrayList));
        m.a("video", "video_url_responed_succ", "resolution", str);
    }

    public static void a(Handler handler, String str, String str2, com.ucpro.feature.video.c.a aVar, com.ucpro.feature.video.c.d.a aVar2) {
        com.ucweb.common.util.c.a((Object) aVar);
        com.ucweb.common.util.c.a((Object) handler);
        com.ucweb.common.util.c.a((Object) aVar2);
        handler.post(new c(aVar, str2, aVar2));
        String aVar3 = aVar2.toString();
        CharSequence c = f.c(str);
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        m.a("video", "video_url_responed_fail", "host", c, "resolution", str2, "reason", aVar3);
    }

    public static void a(Handler handler, String str, ArrayList<String> arrayList, com.ucpro.feature.video.c.d dVar) {
        com.ucweb.common.util.c.a((Object) handler);
        com.ucweb.common.util.c.a((Object) arrayList);
        com.ucweb.common.util.c.a((Object) dVar);
        handler.post(new b(dVar, arrayList));
        int size = arrayList.size();
        TextUtils.isEmpty(f.c(str));
        m.a("video", "resolution_responed_succ", "resolution_size", String.valueOf(size));
    }

    public static void a(Handler handler, String str, com.ucpro.feature.video.c.d dVar, com.ucpro.feature.video.c.d.a aVar) {
        com.ucweb.common.util.c.a((Object) dVar);
        com.ucweb.common.util.c.a((Object) aVar);
        com.ucweb.common.util.c.a((Object) handler);
        handler.post(new e(dVar, aVar));
        String aVar2 = aVar.toString();
        CharSequence c = f.c(str);
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        m.a("video", "resolution_responed_fail", "host", c, "reason", aVar2);
    }

    public static com.ucpro.feature.video.c.d.a a(@NonNull c cVar) {
        switch (cVar.a) {
            case 1:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_UNKNOW_ERROR;
            case 2:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_UNSUPPORT_ERROR;
            case 3:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_PAY_NEED_ERROR;
            case 4:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_ENCODED_VIDEO_ERROR;
            case 5:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_FRIEND_VIDEO_ERROR;
            case 6:
                return com.ucpro.feature.video.c.d.a.VPS_RESPONSE_DELETED_VIDEO_ERROR;
            default:
                return com.ucpro.feature.video.c.d.a.VPS_UNKNOWN;
        }
    }
}
