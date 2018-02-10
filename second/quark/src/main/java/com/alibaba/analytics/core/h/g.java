package com.alibaba.analytics.core.h;

import com.taobao.orange.OrangeConfig;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ c a;
    private final int[] b = new int[]{1, 1, 2, 2, 4, 4, 8};

    g(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        int i = 0;
        String[] b = c.c;
        super.d();
        super.a(super.c());
        int i2 = 0;
        int i3 = 0;
        do {
            int i4 = 0;
            while (i4 < b.length) {
                int i5;
                if (b[i4] == null || OrangeConfig.getInstance().getConfigs(c.c[i4]) == null) {
                    i5 = i3;
                } else {
                    b[i4] = null;
                    i5 = i3 + 1;
                }
                i4++;
                i3 = i5;
            }
            if (i3 == b.length) {
                break;
            }
            try {
                Thread.sleep((long) (this.b[i2] * 1000));
            } catch (InterruptedException e) {
            }
            i2++;
        } while (i2 <= this.b.length);
        i2 = b.length;
        while (i < i2) {
            String str = b[i];
            if (str != null) {
                super.a(str);
            }
            i++;
        }
    }
}
