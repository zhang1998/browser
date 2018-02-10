package com.uc.apollo.media.base;

import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.ReflectUtil;
import com.uc.apollo.util.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public final class Statistic extends h {
    private static ArrayList<Outputter> sOutputters = new ArrayList();

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface Outputter {

        /* compiled from: ProGuard */
        public final class a implements Outputter {
            private Object a;
            private Method b;

            public static Outputter a(Object obj) {
                Outputter aVar = new a(obj);
                if (aVar.a()) {
                    return aVar;
                }
                return null;
            }

            private a(Object obj) {
                this.a = obj;
            }

            private boolean a() {
                try {
                    this.b = ReflectUtil.getMethod2(this.a.getClass(), "write", Integer.TYPE, Map.class);
                    return true;
                } catch (NoSuchMethodException e) {
                    return false;
                }
            }

            public final void write(int i, Map<String, String> map) {
                ReflectUtil.call(Void.class, this.a, this.b, Integer.valueOf(i), map);
            }
        }

        void write(int i, Map<String, String> map);
    }

    public static void addOutputter(Outputter outputter) {
        sOutputters.add(outputter);
    }

    public static void removeOutputter(Outputter outputter) {
        sOutputters.remove(outputter);
    }

    private static void addOutputter(Object obj) {
        if (obj != null) {
            addOutputter(obj instanceof Outputter ? (Outputter) obj : a.a(obj));
        }
    }

    private static void removeOutputter(Object obj) {
        if (obj != null) {
            if (obj instanceof Outputter) {
                removeOutputter((Outputter) obj);
                return;
            }
            Iterator it = sOutputters.iterator();
            while (it.hasNext()) {
                Outputter outputter = (Outputter) it.next();
                if ((outputter instanceof a) && ((a) outputter).a.equals(obj)) {
                    sOutputters.remove(outputter);
                    return;
                }
            }
        }
    }

    public static void onStatisticUpdate(int i, HashMap<String, String> hashMap) {
        switch (i) {
            case 1:
                hashMap.put("ev_ac", "apollo_sdk");
                break;
            case 2:
                hashMap.put("ev_ac", "exit_video");
                break;
            case 3:
                hashMap.put("ev_ac", "click_video");
                break;
            case 4:
                if (f.a((String) hashMap.get("ev_ac"))) {
                    hashMap.put("ev_ac", "apollo");
                    break;
                }
                break;
            default:
                return;
        }
        Iterator it = sOutputters.iterator();
        while (it.hasNext()) {
            ((Outputter) it.next()).write(i, hashMap);
        }
    }
}
