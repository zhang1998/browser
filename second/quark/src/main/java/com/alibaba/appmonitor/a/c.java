package com.alibaba.appmonitor.a;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import java.util.ArrayList;

@TableName("ap_stat")
/* compiled from: ProGuard */
public final class c extends a {
    @Column("detail")
    public int d;

    private boolean a() {
        if (this.d == 1) {
            return true;
        }
        return false;
    }

    public final boolean b(ArrayList<String> arrayList) {
        while (arrayList.size() != 0) {
            String str = (String) arrayList.remove(0);
            if (!a(str)) {
                return a();
            }
            this = (c) c(str);
        }
        return a();
    }
}
