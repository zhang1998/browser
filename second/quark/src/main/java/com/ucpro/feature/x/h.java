package com.ucpro.feature.x;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.uc.framework.resources.ae;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.m;
import com.ucpro.base.e.e;
import com.ucpro.feature.k.a.c.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.d;
import com.ucpro.ui.contextmenu.f;

/* compiled from: ProGuard */
public class h extends e implements c {
    private Bitmap c;
    private com.ucpro.feature.k.a.c.c d;
    private g e;
    private b f = new a(this);
    private Runnable g = new g(this);

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.M == i) {
            d a = f.a().a(this.b);
            a.c();
            a.a(a.d((int) R.string.choice_wallpaper), 30091);
            if (a.a()) {
                a.a(a.d((int) R.string.disable_wallpaper), 30093);
            } else if (e.a()) {
                a.a(a.d((int) R.string.enable_wallpaper), 30092);
            }
            f.a().a(this.b, this.f);
        } else if (com.ucpro.base.a.e.N == i) {
            Uri uri = (Uri) message.obj;
            if (uri != null) {
                try {
                    com.ucpro.base.c.b.g gVar;
                    String string;
                    Bitmap a2;
                    m b = this.a.b();
                    if (this.d == null || this.d.getParent() == null) {
                        this.d = new com.ucpro.feature.k.a.c.c(this.b);
                        this.e = new g(this.d, this.b);
                        this.d.setWindowCallBacks(this);
                        gVar = this.d;
                    } else {
                        gVar = null;
                    }
                    b.a(gVar, true);
                    String[] strArr = new String[]{"_data"};
                    Cursor query = this.b.getContentResolver().query(uri, strArr, null, null, null);
                    if (query != null) {
                        query.moveToFirst();
                        string = query.getString(query.getColumnIndex(strArr[0]));
                        query.close();
                    } else {
                        string = uri.getPath();
                    }
                    Bitmap a3 = com.uc.util.b.a(this.b.getResources(), string, false);
                    if (d(a3)) {
                        a2 = com.uc.util.b.a(com.ucpro.base.system.b.a.c(), com.ucpro.base.system.b.a.d(), Config.RGB_565);
                        if (d(a2)) {
                            float height;
                            float round;
                            a2.eraseColor(0);
                            Canvas canvas = new Canvas(a2);
                            Rect rect = new Rect();
                            rect.set(0, 0, a3.getWidth(), a3.getHeight());
                            RectF rectF = new RectF();
                            if (((float) a3.getWidth()) / ((float) a3.getHeight()) > ((float) a2.getWidth()) / ((float) a2.getHeight())) {
                                height = (float) a2.getHeight();
                                round = (float) Math.round(((float) a3.getWidth()) * (height / ((float) a3.getHeight())));
                            } else {
                                round = (float) a2.getWidth();
                                height = (float) Math.round(((float) a3.getHeight()) * (round / ((float) a3.getWidth())));
                            }
                            rectF.set(0.0f, 0.0f, round, height);
                            Paint paint = new Paint();
                            paint.setFilterBitmap(true);
                            paint.setDither(true);
                            paint.setAntiAlias(true);
                            canvas.drawBitmap(a3, rect, rectF, paint);
                        } else {
                            a2 = null;
                        }
                    } else {
                        a2 = null;
                    }
                    b(a3);
                    int a4 = e.a(a2);
                    if (this.e != null) {
                        this.e.a.a(a2, a4);
                    }
                } catch (Exception e) {
                }
            }
        } else if (com.ucpro.base.a.e.Y == i) {
            if (!a.a()) {
                s_().a(new ae(a.c("default_background_white")));
            } else if (d(this.c)) {
                c(this.c);
            } else {
                a.a(com.ucweb.common.util.j.a.b(com.ucweb.common.util.d.a(), "040B867722E0E9B4", "DF7C2FBA6FB6E4A1", false));
                Context context = this.b;
                c(com.uc.util.b.a(context.getResources(), e.b(), false));
            }
        } else if (com.ucpro.base.a.e.Z == i) {
            com.ucweb.common.util.h.m.c(this.g);
            i();
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.W);
        } else if (com.ucpro.base.a.e.aa == i) {
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.X);
            com.ucweb.common.util.h.m.a(2, this.g, 7000);
        } else if (com.ucpro.base.a.e.O == i) {
            com.ucweb.common.util.c.b(message.obj instanceof Object[]);
            Object[] objArr = (Object[]) message.obj;
            com.ucweb.common.util.h.m.a(0, new c(this, (Bitmap) objArr[0], ((Integer) objArr[1]).intValue()));
            s_().b(true);
        }
    }

    private void i() {
        boolean z = false;
        if (a.b()) {
            boolean a = com.ucpro.model.a.a.a.a("setting_night_mode", false);
            com.ucpro.model.a.b a2 = com.ucpro.model.a.a.a;
            String str = "setting_night_mode";
            if (!a) {
                z = true;
            }
            a2.b(str, z);
            com.ucweb.common.util.h.m.a(2, new d(this));
        }
    }

    private static void b(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public final void b(int i, Message message) {
        int i2 = j.f;
    }

    private void c(Bitmap bitmap) {
        if (d(bitmap)) {
            s_().a(new BitmapDrawable(this.b.getResources(), bitmap));
            this.c = bitmap;
        }
    }

    private static boolean d(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof com.ucpro.base.c.b.g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final View a(View view) {
        return this.a.b().b(this.a.b().a());
    }

    static /* synthetic */ void a(h hVar, Bitmap bitmap, int i) {
        try {
            hVar.i();
            boolean a = e.a(i);
            com.ucweb.common.util.j.a.a(com.ucweb.common.util.d.a(), "040B867722E0E9B4", "DF7C2FBA6FB6E4A1", a);
            a.a(a);
            hVar.c = bitmap;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.W);
            e.a(e.b(), bitmap);
            com.ucpro.business.stat.m.a("quark_lab", com.ucpro.feature.k.a.f, new String[0]);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(h hVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("image/*");
            hVar.b.startActivityForResult(intent, 3);
        } catch (Exception e) {
        }
    }
}
