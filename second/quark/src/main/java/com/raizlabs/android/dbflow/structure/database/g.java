package com.raizlabs.android.dbflow.structure.database;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.c;
import com.raizlabs.android.dbflow.config.l;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import com.raizlabs.android.dbflow.structure.a;
import com.raizlabs.android.dbflow.structure.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class g {
    final c a;

    public g(@NonNull c cVar) {
        this.a = cVar;
    }

    public void a(@NonNull b bVar) {
        b(bVar);
        b(bVar, -1, bVar.d());
    }

    public void a(@NonNull b bVar, int i, int i2) {
        b(bVar);
        b(bVar, i, i2);
    }

    private void b(@NonNull b bVar) {
        try {
            bVar.a();
            for (a c : new ArrayList(this.a.b.values())) {
                bVar.a(c.c());
            }
            for (h hVar : new ArrayList(this.a.c.values())) {
                try {
                    bVar.a(new e().b((Object) "CREATE VIEW IF NOT EXISTS").a(hVar.b()).b((Object) "AS ").b(hVar.a()).a());
                } catch (Throwable e) {
                    t.a(e);
                }
            }
            bVar.b();
            bVar.c();
        } catch (Throwable e2) {
            t.a(e2);
        } catch (Throwable th) {
            bVar.c();
        }
    }

    private void b(@NonNull b bVar, int i, int i2) {
        try {
            List<String> asList = Arrays.asList(FlowManager.b().getAssets().list("migrations/" + this.a.b()));
            Collections.sort(asList, new l());
            Map hashMap = new HashMap();
            for (String str : asList) {
                try {
                    Integer valueOf = Integer.valueOf(str.replace(".sql", ""));
                    List list = (List) hashMap.get(valueOf);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(valueOf, list);
                    }
                    list.add(str);
                } catch (Throwable e) {
                    t.a(s.d, "Skipping invalidly named file: " + str, e);
                }
            }
            Map map = this.a.a;
            int i3 = i + 1;
            bVar.a();
            for (int i4 = i3; i4 <= i2; i4++) {
                asList = (List) hashMap.get(Integer.valueOf(i4));
                if (asList != null) {
                    for (String str2 : asList) {
                        a(bVar, str2);
                        t.a(s.c, str2 + " executed successfully.");
                    }
                }
                List<com.raizlabs.android.dbflow.a.c.a> list2 = (List) map.get(Integer.valueOf(i4));
                if (list2 != null) {
                    for (com.raizlabs.android.dbflow.a.c.a aVar : list2) {
                        aVar.a();
                        aVar.a(bVar);
                        aVar.b();
                        t.a(s.c, aVar.getClass() + " executed successfully.");
                    }
                }
            }
            bVar.b();
            bVar.c();
        } catch (Throwable e2) {
            t.a(s.e, "Failed to execute migrations.", e2);
        } catch (Throwable th) {
            bVar.c();
        }
    }

    private void a(@NonNull b bVar, @NonNull String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FlowManager.b().getAssets().open("migrations/" + this.a.b() + "/" + str)));
            String str2 = ";";
            String str3 = "--";
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                readLine = readLine.trim();
                boolean endsWith = readLine.endsWith(str2);
                if (!readLine.startsWith(str3)) {
                    if (endsWith) {
                        readLine = readLine.substring(0, readLine.length() - str2.length());
                    }
                    stringBuffer.append(" ").append(readLine);
                    if (endsWith) {
                        bVar.a(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.trim().length() > 0) {
                bVar.a(stringBuffer2);
            }
        } catch (Throwable e) {
            t.a(s.e, "Failed to execute " + str, e);
        }
    }
}
