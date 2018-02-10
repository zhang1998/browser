package com.uc.aerie.updater;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class g {
    public long a;
    public long b;
    public long c;
    public HashMap<String, e> d = new HashMap();

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("totalCost:").append(this.a).append(", updateMaster cost:").append(this.b).append(", updateModule cost:").append(this.c).append("\n");
        if (!this.d.isEmpty()) {
            for (Entry entry : this.d.entrySet()) {
                String str = (String) entry.getKey();
                e eVar = (e) entry.getValue();
                stringBuilder.append("moduleName:").append(str).append(", mergeDex cost:").append(eVar.a).append(", optimizeDex cost:").append(eVar.b).append(", mergeRes cost:").append(eVar.d).append(", mergeSo cost:").append(eVar.c).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
