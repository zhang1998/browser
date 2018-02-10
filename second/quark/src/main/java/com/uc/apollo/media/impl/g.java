package com.uc.apollo.media.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

/* compiled from: ProGuard */
public interface g {

    /* compiled from: ProGuard */
    public final class a {
        private final int a;
        private Surface b;
        private boolean c = true;

        public a(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public final void a(Surface surface) {
            this.b = surface;
        }

        public final Surface b() {
            return this.b;
        }

        public final void a(boolean z) {
            this.c = z;
        }

        public final boolean c() {
            return this.c;
        }
    }

    F a();

    String a(String str);

    void a(float f, float f2);

    void a(int i);

    void a(int i, Surface surface);

    void a(int i, g gVar, int i2);

    void a(int i, String str);

    void a(int i, boolean z);

    void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    void a(E e);

    void a(g gVar);

    void a(String str, String str2);

    void a(boolean z);

    O b();

    void b(int i);

    void b(E e);

    void b(boolean z);

    boolean b(String str, String str2);

    int c();

    void c(int i);

    int d();

    void d(int i);

    int e();

    a e(int i);

    int f();

    void f(int i);

    int g();

    boolean g(int i) throws IllegalStateException;

    Surface h(int i);

    boolean h() throws IllegalStateException;

    boolean i();

    boolean j();

    boolean k();

    DataSource l();

    void m() throws IllegalStateException;

    void n();

    void o();

    int p();

    void q();

    Bitmap r();

    int s();

    int t();

    int u();

    boolean v();

    boolean w();

    int x();

    String y();

    Map<String, String> z();
}
