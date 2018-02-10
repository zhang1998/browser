package com.ucpro.feature.video;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.uc.apollo.android.GuideDialog;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.feature.video.player.a.g;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class a extends e implements com.ucpro.base.c.a.a, ag, g, u {
    private SparseArray<ax> c;
    private ao d = null;

    static {
        m.a(0, new z());
    }

    protected final void a(b bVar) {
        super.a(bVar);
        this.c = new SparseArray();
        t_().a((com.ucpro.base.c.a.a) this);
    }

    public final void a(int i, Message message) {
        f fVar = null;
        boolean z = true;
        Object[] objArr;
        if (com.ucpro.base.a.e.bn == i) {
            c.a((Object) message);
            if (message != null) {
                c.b(message.obj instanceof Object[]);
                if (message.obj instanceof Object[]) {
                    objArr = (Object[]) message.obj;
                    c.b(objArr.length == 3);
                    if (objArr.length == 3) {
                        c.b(objArr[0] instanceof Integer);
                        if (objArr[0] instanceof Integer) {
                            c.b(objArr[1] instanceof Integer);
                            if (objArr[1] instanceof Integer) {
                                ax axVar = new ax(this.b);
                                t avVar = new av(this.b, axVar, (Integer) objArr[1], false);
                                axVar.a(avVar);
                                axVar.m = this;
                                int intValue = ((Integer) objArr[0]).intValue();
                                a(intValue);
                                this.c.put(intValue, axVar);
                                objArr[2] = avVar;
                                com.ucpro.feature.video.g.a.a();
                            }
                        }
                    }
                }
            }
        } else if (com.ucpro.base.a.e.bo == i) {
            c.a((Object) message);
            if (message != null) {
                c.b(message.obj instanceof boolean[]);
                if (message.obj instanceof boolean[]) {
                    t tVar;
                    if (this.d != null) {
                        com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a();
                        this.d.a.a(UCMPackageInfo.expectDirFile1F, null, a);
                        Boolean bool = (Boolean) a.a(26);
                        if (bool == null || bool.booleanValue()) {
                            f fVar2 = this.d;
                            if (fVar2.n != 3) {
                                ((Activity) fVar2.b).setRequestedOrientation(fVar2.j);
                                fVar2.d();
                                fVar2.a(false);
                                if (fVar2.m != null) {
                                    fVar2.m.d();
                                }
                            } else if (fVar2.m != null) {
                                fVar2.a(false);
                                fVar2.m.i();
                                if (fVar2.p != null && fVar2.a.r().getParent() == null) {
                                    fVar2.p.addView(fVar2.a.r());
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    r0 = message.arg1 == -1 ? s_().a().getID() : message.arg1;
                    if (this.c.get(r0) == null) {
                        tVar = null;
                    } else {
                        tVar = ((ax) this.c.get(r0)).a;
                    }
                    if (tVar != null) {
                        ((boolean[]) message.obj)[0] = tVar.a(UCMPackageInfo.expectDirFile1F, null, null);
                    }
                    com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bw);
                }
            }
        } else if (com.ucpro.base.a.e.bp == i) {
            c.a((Object) message);
            if (this.d == null && message != null) {
                c.b(message.obj instanceof com.ucpro.feature.video.player.a.b);
                if (message.obj instanceof com.ucpro.feature.video.player.a.b) {
                    a((com.ucpro.feature.video.player.a.b) message.obj, 2);
                }
            }
        } else if (com.ucpro.base.a.e.br == i) {
            ValueCallback valueCallback = (ValueCallback) message.obj;
            Context context = this.b;
            if (!com.ucpro.feature.video.b.b.a(context)) {
                com.ucpro.feature.video.b.b.b(context);
                z = false;
            }
            valueCallback.onReceiveValue(Boolean.valueOf(z));
        } else if (com.ucpro.base.a.e.bs == i) {
            String str;
            String str2;
            Object obj;
            if (message.obj instanceof String[]) {
                String[] strArr = (String[]) message.obj;
                str = strArr[0];
                str2 = strArr[1];
                obj = strArr[2];
                r0 = strArr[3];
            } else {
                r0 = null;
                str2 = null;
                str = null;
            }
            if (!com.ucweb.common.util.n.a.a(str)) {
                Uri parse = Uri.parse(str);
                if (parse != null && "content".equalsIgnoreCase(parse.getScheme())) {
                    parse = com.ucpro.feature.video.b.e.a(parse);
                    if (parse != null) {
                        str = parse.toString();
                    }
                }
                if (r0 == null) {
                    str = com.ucpro.feature.video.b.e.a(str);
                }
                if (!com.ucweb.common.util.n.a.a(str)) {
                    com.ucpro.feature.video.player.a.b a2 = h.a(str2);
                    if (a2 == null) {
                        a2 = com.ucpro.feature.video.player.a.b.a();
                        a2.a(19, obj);
                        a2.a(20, str2);
                        a2.a(18, str);
                    }
                    com.ucpro.feature.video.player.a.b bVar = a2;
                    bVar.a(23, r0);
                    a(bVar, 1);
                    if (r0 != null) {
                        com.ucpro.feature.video.g.a.b();
                    }
                }
            }
        } else if (com.ucpro.base.a.e.bt == i) {
            if (this.d != null) {
                this.d.a.a((Bundle) message.obj);
            }
            r0 = s_().a().getID();
            if (this.c.get(r0) != null) {
                fVar = (ax) this.c.get(r0);
            }
            if (fVar != null) {
                fVar.a.a((Bundle) message.obj);
            }
        } else if (com.ucpro.base.a.e.bu == i) {
            c.a((Object) message);
            if (message != null) {
                objArr = (Object[]) message.obj;
                c.b(objArr.length == 3);
                if (objArr.length == 3) {
                    c.b(objArr[0] instanceof com.ucpro.feature.video.player.a.b);
                    if (objArr[0] instanceof com.ucpro.feature.video.player.a.b) {
                        objArr[2] = a((com.ucpro.feature.video.player.a.b) objArr[0], (ViewGroup) objArr[1]);
                    }
                }
            }
        } else if (com.ucpro.base.a.e.bv == i) {
            c.a((Object) message);
            if (message != null) {
                objArr = (Object[]) message.obj;
                c.b(objArr.length == 1);
                if (objArr.length == 1) {
                    c.b(objArr[0] instanceof ae);
                    if (objArr[0] instanceof ae) {
                        r0 = (ae) objArr[0];
                        if (this.d != null && this.d.a == r0) {
                            d();
                        }
                    }
                }
            }
        }
    }

    public final void v_() {
        super.v_();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            t tVar;
            if (this.c.valueAt(i) == null) {
                tVar = null;
            } else {
                tVar = ((ax) this.c.valueAt(i)).a;
            }
            tVar.m();
        }
    }

    public final void b(int i, Message message) {
        ao aoVar;
        if (i == j.p) {
            if (this.d != null) {
                aoVar = this.d;
                if (aoVar.a.n()) {
                    aoVar.a.m();
                    aoVar.o = true;
                }
            }
        } else if (i == j.o && this.d != null) {
            aoVar = this.d;
            if (aoVar.o) {
                aoVar.a.l();
            }
            aoVar.o = false;
        }
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return false;
    }

    public final void a() {
    }

    public final void a(com.ucpro.base.c.b.g gVar) {
        if (gVar != null) {
            a(gVar.getID());
        }
    }

    private void a(int i) {
        t tVar;
        if (this.c.get(i) == null) {
            tVar = null;
        } else {
            tVar = ((ax) this.c.get(i)).a;
        }
        if (tVar != null) {
            this.c.remove(i);
            tVar.o();
        }
    }

    public final void a(com.ucpro.feature.video.player.a.b bVar, int i) {
        if (bVar != null) {
            int i2;
            List list;
            Integer valueOf;
            String str = (String) bVar.a(18);
            String str2 = (String) bVar.a(19);
            String str3 = (String) bVar.a(20);
            String str4 = (String) bVar.a(22);
            if (bVar.a(24) == null || !(bVar.a(24) instanceof Integer)) {
                i2 = -1;
            } else {
                i2 = ((Integer) bVar.a(24)).intValue();
            }
            Object a = bVar.a(21);
            if (a == null || !(a instanceof ArrayList)) {
                list = null;
            } else {
                list = (ArrayList) a;
            }
            Bundle bundle = new Bundle();
            bundle.putString(GuideDialog.TITLE, str2);
            bundle.putString(IProxyHandler.KEY_PAGE_URL, str3);
            bundle.putString(IProxyHandler.KEY_VIDEO_URL, str);
            this.d = new ao(this.b, i);
            Integer valueOf2 = Integer.valueOf(0);
            try {
                valueOf = Integer.valueOf((String) bVar.a(23));
            } catch (Exception e) {
                valueOf = valueOf2;
            }
            t avVar = new av(this.b, this.d, valueOf, true);
            avVar.a(bundle);
            avVar.a();
            if (list != null) {
                avVar.a(list);
                f fVar = this.d;
                fVar.g.put(str3, list);
                fVar.i = 2;
            }
            this.d.a(avVar);
            this.d.m = this;
            if (i == 0) {
                this.d.a(str, str4);
            } else if (i == 1) {
                this.d.a();
                this.d.a(str, str4, true, i2);
                this.d.a(true);
            } else if (i == 2) {
                this.d.a();
                this.d.a(str);
                this.d.a(true);
            }
        }
        e();
        com.ucpro.feature.video.g.a.a(i);
    }

    private ae a(com.ucpro.feature.video.player.a.b bVar, ViewGroup viewGroup) {
        if (bVar == null) {
            return null;
        }
        ae avVar;
        String str = (String) bVar.a(18);
        String str2 = (String) bVar.a(19);
        String str3 = (String) bVar.a(20);
        int intValue = ((Integer) bVar.a(25)).intValue();
        if (this.d != null) {
            this.d.e();
            this.d = null;
        }
        if (this.d == null) {
            Bundle bundle = new Bundle();
            bundle.putString(GuideDialog.TITLE, str2);
            bundle.putString(IProxyHandler.KEY_PAGE_URL, str3);
            bundle.putString(IProxyHandler.KEY_VIDEO_URL, str);
            this.d = new ao(this.b, 3);
            Integer valueOf = Integer.valueOf(0);
            try {
                valueOf = Integer.valueOf((String) bVar.a(23));
            } catch (Exception e) {
            }
            avVar = new av(this.b, this.d, valueOf, true, intValue);
            avVar.a(bundle);
            this.d.p = viewGroup;
            this.d.a((t) avVar);
            this.d.m = this;
        } else {
            avVar = null;
        }
        this.d.a(str);
        com.ucpro.feature.video.g.a.a(3);
        return avVar;
    }

    public final void d() {
        if (this.d != null) {
            i();
            this.d.e();
            this.d = null;
        }
    }

    public final void e() {
        if (this.d != null && this.d.a != null && this.d.a.r().getParent() == null) {
            this.a.b().a(this.d.a.r());
        }
    }

    public final void i() {
        if (this.d != null && this.d.a != null && this.d.a.r().getParent() != null) {
            this.a.b().b(this.d.a.r());
        }
    }

    public final void g() {
        com.ucpro.feature.video.b.e.a(new File(com.ucpro.c.c.f()), 1800000);
    }
}
