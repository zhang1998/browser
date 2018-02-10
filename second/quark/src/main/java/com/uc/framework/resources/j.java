package com.uc.framework.resources;

import java.lang.ref.ReferenceQueue;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class j extends LinkedHashMap<String, Object> {
    private static boolean a = true;
    private static boolean b;
    private static long c;
    private static long d;
    private static j e;
    private static ReferenceQueue<Object> f;
    private static Thread g;
    private static h h;
    private static h i;

    j() {
    }

    static Object a(String str, Object obj, long j) {
        if (!a || e == null || str == null || obj == null) {
            return null;
        }
        Object iVar = new i(str, obj, j);
        e.put(str, iVar);
        return iVar;
    }

    static Object a(String str) {
        if (!a || e == null || str == null) {
            return null;
        }
        return (i) e.get(str);
    }

    private static boolean h() throws InterruptedException {
        while (true) {
            h hVar = (h) f.remove();
            if (!(hVar == null || e == null)) {
                String str = hVar.a;
                if (b) {
                    int i = 0;
                    for (h hVar2 = h; hVar2.d != null; hVar2 = hVar2.d) {
                        i++;
                    }
                    new StringBuilder("will gc:").append(str).append(" clones count:").append(i);
                    new StringBuilder("pool size:").append(e.size()).append(" total size:").append(d);
                }
                i iVar = (i) e.get(str);
                if (iVar != null) {
                    iVar.c--;
                    if (iVar.c == 0) {
                        if (b) {
                            new StringBuilder("one ref will clear:").append(str).append(" size:").append(iVar.b);
                        }
                        if (d > c || ((double) iVar.b) > ((double) c) * 0.25d) {
                            if (iVar.e) {
                                d -= iVar.b;
                            }
                            e.remove(iVar.a);
                            iVar.d = null;
                        } else {
                            d += iVar.b;
                            iVar.e = true;
                        }
                    }
                }
                if (hVar != null) {
                    if (hVar == i) {
                        synchronized (i) {
                            if (hVar == i) {
                                i = hVar.c;
                            } else if (!(hVar.c == null || hVar.d == null)) {
                                hVar.c.d = hVar.d;
                                hVar.d.c = hVar.c;
                            }
                        }
                        if (b) {
                        }
                    } else if (!(hVar.c == null || hVar.d == null)) {
                        hVar.c.d = hVar.d;
                        hVar.d.c = hVar.c;
                    }
                }
            }
        }
        return false;
    }

    static void a() {
        f = new ReferenceQueue();
        e = new j();
        h hVar = new h("", "", 0);
        h = hVar;
        i = hVar;
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = (long) (((float) maxMemory) * 0.05f);
        c = j;
        if (j > 20971520) {
            c = 20971520;
        }
        d = 0;
        if (g == null) {
            Thread thread = new Thread(new g());
            g = thread;
            thread.setName("ResourceCache");
            g.setDaemon(true);
            g.setPriority(1);
            g.start();
        }
        if (b) {
            new StringBuilder("max cache size:").append(c).append(" free memory:").append(maxMemory);
        }
    }

    static void b() {
        b = false;
    }

    protected final boolean removeEldestEntry(Entry<String, Object> entry) {
        i iVar = (i) entry.getValue();
        if (iVar != null && iVar.c == 0 && (d > c || ((double) iVar.b) > ((double) c) * 0.25d)) {
            if (iVar.e) {
                d -= iVar.b;
            }
            if (b) {
                new StringBuilder("remove resource:").append((String) entry.getKey()).append(" size is:").append(iVar.b);
            }
            e.remove(iVar.a);
            iVar.d = null;
        }
        return false;
    }
}
