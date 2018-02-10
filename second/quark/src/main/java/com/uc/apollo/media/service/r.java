package com.uc.apollo.media.service;

import java.util.HashMap;

/* compiled from: ProGuard */
interface r {
    public static final String[] a = new String[]{"w_x", "w_y", "w_w", "w_h", "v_w", "v_h", "v_l", "v_t", "m_t", "s_c", "s_sp", "s_ep", "s_wt"};

    /* compiled from: ProGuard */
    public final class a implements r {
        private boolean b;
        private int[] c = new int[a.length];

        public final boolean d() {
            return this.b;
        }

        public final HashMap<String, String> a() {
            HashMap<String, String> hashMap = new HashMap();
            for (int i = 0; i != this.c.length; i++) {
                hashMap.put(a[i], Integer.toString(this.c[i]));
            }
            return hashMap;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.c.length * 16);
            stringBuilder.append('{');
            for (int i = 0; i != this.c.length; i++) {
                stringBuilder.append(a[i]).append(": ").append(this.c[i]).append(", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final void b() {
            this.b = false;
            for (int i = 0; i != this.c.length; i++) {
                this.c[i] = 0;
            }
            this.c[10] = -1;
            this.c[11] = -1;
        }

        public final void c() {
            a(9, 1);
        }

        public final void a(int i, int i2) {
            this.c[i] = i2;
            this.b = true;
        }

        public final void a(int i) {
            this.b = true;
            if (this.c[10] == -1) {
                this.c[10] = i;
            } else {
                int i2 = this.c[11];
                if (i > i2 && i < i2 + 1200) {
                    int[] iArr = this.c;
                    iArr[12] = (i - i2) + iArr[12];
                }
            }
            this.c[11] = i;
        }
    }

    /* compiled from: ProGuard */
    public final class b {
        static r a;

        static r a() {
            if (a == null) {
                a = new a();
            }
            return a;
        }
    }

    HashMap<String, String> a();

    void a(int i);

    void a(int i, int i2);

    void b();

    void c();

    boolean d();
}
