package com.bumptech.glide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.a.n;
import com.bumptech.glide.b.b.af;
import com.bumptech.glide.b.b.b.l;
import com.bumptech.glide.b.b.b.m;
import com.bumptech.glide.b.b.b.o;
import com.bumptech.glide.b.b.b.s;
import com.bumptech.glide.b.b.d.a;
import com.bumptech.glide.b.c.a.i;
import com.bumptech.glide.b.c.aa;
import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.b.c.aj;
import com.bumptech.glide.b.c.bb;
import com.bumptech.glide.b.c.bc;
import com.bumptech.glide.b.c.be;
import com.bumptech.glide.b.c.bf;
import com.bumptech.glide.b.c.bg;
import com.bumptech.glide.b.c.bi;
import com.bumptech.glide.b.c.bl;
import com.bumptech.glide.b.c.bn;
import com.bumptech.glide.b.c.bp;
import com.bumptech.glide.b.c.j;
import com.bumptech.glide.b.c.w;
import com.bumptech.glide.b.d.a.al;
import com.bumptech.glide.b.d.a.d;
import com.bumptech.glide.b.d.a.r;
import com.bumptech.glide.b.d.e.f;
import com.bumptech.glide.c.e;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.p;
import com.bumptech.glide.c.q;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TargetApi(14)
/* compiled from: ProGuard */
public class c implements ComponentCallbacks2 {
    private static volatile c i;
    private static volatile boolean j;
    public final af a;
    public final g b;
    public final e c;
    public final m d;
    public final b e;
    public final q f;
    final e g;
    final List<u> h = new ArrayList();
    private final o k;
    private final a l;
    private f m = f.NORMAL;

    public static c a(Context context) {
        if (i == null) {
            synchronized (c.class) {
                if (i == null) {
                    if (j) {
                        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                    }
                    j = true;
                    c(context);
                    j = false;
                }
            }
        }
        return i;
    }

    private static void c(Context context) {
        Iterator it;
        com.bumptech.glide.d.c cVar;
        Context applicationContext = context.getApplicationContext();
        a a = a();
        List emptyList = Collections.emptyList();
        List a2;
        if (a == null || a.c()) {
            a2 = new com.bumptech.glide.d.e(applicationContext).a();
        } else {
            a2 = emptyList;
        }
        if (!(a == null || a.a().isEmpty())) {
            Set a3 = a.a();
            it = r10.iterator();
            while (it.hasNext()) {
                cVar = (com.bumptech.glide.d.c) it.next();
                if (a3.contains(cVar.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(cVar);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.bumptech.glide.d.c cVar2 : r10) {
                new StringBuilder("Discovered GlideModule from manifest: ").append(cVar2.getClass());
            }
        }
        p b = a != null ? a.b() : null;
        d dVar = new d();
        dVar.l = b;
        for (com.bumptech.glide.d.c cVar22 : r10) {
            cVar22.a(applicationContext, dVar);
        }
        if (a != null) {
            a.a(applicationContext, dVar);
        }
        if (dVar.e == null) {
            dVar.e = com.bumptech.glide.b.b.c.g.b();
        }
        if (dVar.f == null) {
            dVar.f = com.bumptech.glide.b.b.c.g.a();
        }
        if (dVar.h == null) {
            com.bumptech.glide.b.b.b.p pVar = new com.bumptech.glide.b.b.b.p(applicationContext);
            dVar.h = new s(pVar.a, pVar.b, pVar.c, pVar.d, pVar.e, pVar.h, pVar.f, pVar.g);
        }
        if (dVar.i == null) {
            dVar.i = new h();
        }
        if (dVar.b == null) {
            dVar.b = new com.bumptech.glide.b.b.a.q(dVar.h.a);
        }
        if (dVar.c == null) {
            dVar.c = new n(dVar.h.c);
        }
        if (dVar.d == null) {
            dVar.d = new m(dVar.h.b);
        }
        if (dVar.g == null) {
            dVar.g = new l(applicationContext);
        }
        if (dVar.a == null) {
            dVar.a = new af(dVar.d, dVar.g, dVar.f, dVar.e, com.bumptech.glide.b.b.c.g.c());
        }
        c cVar3 = new c(applicationContext, dVar.a, dVar.d, dVar.b, dVar.c, new q(dVar.l), dVar.i, dVar.j, dVar.k.f());
        for (com.bumptech.glide.d.c a4 : r10) {
            a4.a(applicationContext, cVar3, cVar3.d);
        }
        if (a != null) {
            a.a(applicationContext, cVar3, cVar3.d);
        }
        i = cVar3;
    }

    @Nullable
    private static a a() {
        try {
            return (a) Class.forName("com.bumptech.glide.x").newInstance();
        } catch (ClassNotFoundException e) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (Throwable e2) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e22);
        }
    }

    @TargetApi(14)
    private c(Context context, af afVar, o oVar, g gVar, b bVar, q qVar, e eVar, int i, com.bumptech.glide.f.g gVar2) {
        this.a = afVar;
        this.b = gVar;
        this.e = bVar;
        this.k = oVar;
        this.f = qVar;
        this.g = eVar;
        this.l = new a(oVar, gVar, (com.bumptech.glide.b.b) gVar2.p.a(r.a));
        Resources resources = context.getResources();
        this.d = new m();
        m mVar = this.d;
        mVar.g.a(new com.bumptech.glide.b.d.a.o());
        r rVar = new r(this.d.a(), resources.getDisplayMetrics(), gVar, bVar);
        com.bumptech.glide.b.n cVar = new com.bumptech.glide.b.d.e.c(context, this.d.a(), gVar, bVar);
        this.d.a(ByteBuffer.class, new com.bumptech.glide.b.c.l()).a(InputStream.class, new be(bVar)).a(ByteBuffer.class, Bitmap.class, new com.bumptech.glide.b.d.a.g(rVar)).a(InputStream.class, Bitmap.class, new com.bumptech.glide.b.d.a.af(rVar, bVar)).a(ParcelFileDescriptor.class, Bitmap.class, new al(gVar)).a(Bitmap.class, new d()).a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.b.d.a.a(resources, gVar, new com.bumptech.glide.b.d.a.g(rVar))).a(InputStream.class, BitmapDrawable.class, new com.bumptech.glide.b.d.a.a(resources, gVar, new com.bumptech.glide.b.d.a.af(rVar, bVar))).a(ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.b.d.a.a(resources, gVar, new al(gVar))).a(BitmapDrawable.class, new com.bumptech.glide.b.d.a.b(gVar, new d())).b(InputStream.class, f.class, new com.bumptech.glide.b.d.e.p(this.d.a(), cVar, bVar)).b(ByteBuffer.class, f.class, cVar).a(f.class, new com.bumptech.glide.b.d.e.g()).a(GifDecoder.class, GifDecoder.class, new bi()).a(GifDecoder.class, Bitmap.class, new com.bumptech.glide.b.d.e.o(gVar)).a(new com.bumptech.glide.b.d.b.a()).a(File.class, ByteBuffer.class, new com.bumptech.glide.b.c.n()).a(File.class, InputStream.class, new aa()).a(File.class, File.class, new com.bumptech.glide.b.d.d.a()).a(File.class, ParcelFileDescriptor.class, new w()).a(File.class, File.class, new bi()).a(new com.bumptech.glide.b.a.o(bVar)).a(Integer.TYPE, InputStream.class, new bc(resources)).a(Integer.TYPE, ParcelFileDescriptor.class, new bb(resources)).a(Integer.class, InputStream.class, new bc(resources)).a(Integer.class, ParcelFileDescriptor.class, new bb(resources)).a(String.class, InputStream.class, new com.bumptech.glide.b.c.s()).a(String.class, InputStream.class, new bg()).a(String.class, ParcelFileDescriptor.class, new bf()).a(Uri.class, InputStream.class, new com.bumptech.glide.b.c.a.c()).a(Uri.class, InputStream.class, new com.bumptech.glide.b.c.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.b.c.b(context.getAssets())).a(Uri.class, InputStream.class, new com.bumptech.glide.b.c.a.e(context)).a(Uri.class, InputStream.class, new com.bumptech.glide.b.c.a.g(context)).a(Uri.class, InputStream.class, new bn(context.getContentResolver())).a(Uri.class, ParcelFileDescriptor.class, new bl(context.getContentResolver())).a(Uri.class, InputStream.class, new bp()).a(URL.class, InputStream.class, new i()).a(Uri.class, File.class, new aj(context)).a(ac.class, InputStream.class, new com.bumptech.glide.b.c.a.a()).a(byte[].class, ByteBuffer.class, new com.bumptech.glide.b.c.f()).a(byte[].class, InputStream.class, new j()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.b.d.f.b(resources, gVar)).a(Bitmap.class, byte[].class, new com.bumptech.glide.b.d.f.a()).a(f.class, byte[].class, new com.bumptech.glide.b.d.f.c());
        Context context2 = context;
        this.c = new e(context2, this.d, new com.bumptech.glide.f.a.e(), gVar2, afVar, this, i);
    }

    private static q d(@Nullable Context context) {
        com.bumptech.glide.util.j.a((Object) context, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).f;
    }

    public static u b(Context context) {
        return d(context).a(context);
    }

    public static u a(Activity activity) {
        return d(activity).a(activity);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onTrimMemory(int i) {
        com.bumptech.glide.util.l.a();
        this.k.a(i);
        this.b.a(i);
        this.e.a(i);
    }

    public void onLowMemory() {
        com.bumptech.glide.util.l.a();
        this.k.a();
        this.b.a();
        this.e.a();
    }
}
