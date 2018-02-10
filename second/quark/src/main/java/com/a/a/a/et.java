package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.UCMobile.Apollo.ApolloMetaData;
import com.a.a.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class et {
    private static Context i;
    ec a;
    er b;
    JSONObject c;
    boolean d = false;
    boolean e;
    private bc f;
    private bb g;
    private final int h = 1;

    public et(Context context, ec ecVar) {
        this.f = bc.a(context);
        this.g = bb.a(context);
        i = context;
        this.a = ecVar;
        this.b = new er(context);
        this.b.a = this.a;
    }

    public final void a(ed edVar) {
        this.g.b = edVar;
    }

    public final void a() {
        int i = 0;
        File[] listFiles;
        try {
            if (this.c != null) {
                try {
                    this.f.a();
                    try {
                        CharSequence encodeToString = Base64.encodeToString(new e().a(this.f.a), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject = this.c.getJSONObject(ApolloMetaData.KEY_HEADER);
                            jSONObject.put("id_tracking", encodeToString);
                            this.c.put(ApolloMetaData.KEY_HEADER, jSONObject);
                        }
                    } catch (Exception e) {
                    }
                    byte[] bytes = String.valueOf(this.c).getBytes();
                    if (bytes != null && !fg.a(i, bytes)) {
                        bd b;
                        if (this.d) {
                            b = bd.b(i, b.a(i), bytes);
                        } else {
                            b = bd.a(i, b.a(i), bytes);
                        }
                        byte[] a = b.a();
                        fi.a(i).d();
                        bytes = this.b.a(a);
                        if (bytes == null) {
                            i = 1;
                        } else {
                            i = a(bytes);
                        }
                        switch (i) {
                            case 1:
                                if (!this.e) {
                                    fi.a(i).a(a);
                                    return;
                                }
                                return;
                            case 2:
                                this.f.b();
                                this.a.b();
                                return;
                            case 3:
                                this.a.b();
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            int i2;
            fy fyVar = fi.a(i).a;
            ez elVar = new el(this);
            listFiles = fyVar.a.listFiles(fyVar.b);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                fj.b(new fx(fyVar, length));
                for (i2 = 0; i2 < length; i2++) {
                    listFiles[i2].delete();
                }
            }
            if (listFiles != null && listFiles.length > 0) {
                i2 = listFiles.length;
                while (i < i2) {
                    if (elVar.a(listFiles[i])) {
                        listFiles[i].delete();
                    } else {
                        continue;
                    }
                    i++;
                }
                elVar.a();
            }
        } catch (Throwable th2) {
        }
    }

    final int a(byte[] bArr) {
        dg dgVar = new dg();
        try {
            new b(new r()).a(dgVar, bArr);
            if (dgVar.a == 1) {
                bb bbVar = this.g;
                dx dxVar = dgVar.c;
                if (dxVar != null) {
                    Object obj;
                    if (dxVar.c.equals(bb.a(dxVar))) {
                        loop1:
                        for (dr drVar : dxVar.a.values()) {
                            int i;
                            byte[] a = fg.a(drVar.c);
                            ByteBuffer allocate = ByteBuffer.allocate(8);
                            allocate.order(null);
                            allocate.putLong(drVar.b);
                            byte[] array = allocate.array();
                            byte[] bArr2 = bb.a;
                            byte[] bArr3 = new byte[4];
                            for (i = 0; i < 4; i++) {
                                bArr3[i] = (byte) (array[i] ^ bArr2[i]);
                            }
                            for (i = 0; i < 4; i++) {
                                if (a[i] != bArr3[i]) {
                                    obj = null;
                                    break loop1;
                                }
                            }
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        synchronized (bbVar) {
                            String str;
                            dx dxVar2;
                            boolean equals;
                            dx dxVar3 = bbVar.d;
                            if (dxVar3 == null) {
                                str = null;
                            } else {
                                str = dxVar3.c;
                            }
                            if (dxVar3 == null) {
                                Map map = dxVar.a;
                                List<String> arrayList = new ArrayList(map.size() / 2);
                                for (Entry entry : map.entrySet()) {
                                    if (!((dr) entry.getValue()).a()) {
                                        arrayList.add(entry.getKey());
                                    }
                                }
                                for (String remove : arrayList) {
                                    map.remove(remove);
                                }
                                dxVar2 = dxVar;
                            } else {
                                dxVar2 = bb.a(dxVar3, dxVar);
                            }
                            bbVar.d = dxVar2;
                            if (dxVar2 == null) {
                                obj = null;
                            } else {
                                obj = dxVar2.c;
                            }
                            if (str != null) {
                                equals = str.equals(obj);
                            } else if (obj != null) {
                                equals = false;
                            } else {
                                equals = true;
                            }
                            if (equals) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                        }
                        if (!(bbVar.d == null || r0 == null)) {
                            bbVar.c.a(bbVar.d);
                            if (bbVar.b != null) {
                                bbVar.b.a(bbVar.c);
                            }
                        }
                    }
                }
                bb bbVar2 = this.g;
                if (bbVar2.d != null) {
                    try {
                        fu.a(new File(bbVar2.e.getFilesDir(), ".imprint"), new e().a(bbVar2.d));
                    } catch (Exception e) {
                    }
                }
            }
            fw.b("send log:" + dgVar.b);
        } catch (Throwable th) {
        }
        if (dgVar.a == 1) {
            return 2;
        }
        return 3;
    }
}
