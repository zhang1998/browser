package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.uc.imagecodec.export.IPictureView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
class fs extends DataSetObservable {
    private static final String c = fs.class.getSimpleName();
    private static final Object d = new Object();
    private static final Map<String, fs> e = new HashMap();
    final Object a;
    final List<cm> b;
    private final List<fq> f;
    private final Context g;
    private final String h;
    private Intent i;
    private ew j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private ep p;

    public final int a() {
        int size;
        synchronized (this.a) {
            d();
            size = this.b.size();
        }
        return size;
    }

    public final ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.a) {
            d();
            resolveInfo = ((cm) this.b.get(i)).a;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.a) {
            d();
            List list = this.b;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((cm) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent b(int i) {
        synchronized (this.a) {
            if (this.i == null) {
                return null;
            }
            d();
            cm cmVar = (cm) this.b.get(i);
            ComponentName componentName = new ComponentName(cmVar.a.activityInfo.packageName, cmVar.a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                Intent intent2 = new Intent(intent);
                if (this.p.a()) {
                    return null;
                }
            }
            a(new fq(componentName, System.currentTimeMillis(), (float) IPictureView.DEFAULT_MIN_SCALE));
            return intent;
        }
    }

    public final ResolveInfo b() {
        synchronized (this.a) {
            d();
            if (this.b.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((cm) this.b.get(0)).a;
            return resolveInfo;
        }
    }

    public final int c() {
        int size;
        synchronized (this.a) {
            d();
            size = this.f.size();
        }
        return size;
    }

    final void d() {
        int i;
        int i2 = 1;
        if (!this.o || this.i == null) {
            i = 0;
        } else {
            this.o = false;
            this.b.clear();
            List queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.b.add(new cm(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.l && this.n && !TextUtils.isEmpty(this.h)) {
            this.l = false;
            this.m = true;
            h();
        } else {
            i2 = 0;
        }
        i |= i2;
        g();
        if (i != 0) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.j == null || this.i == null || this.b.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.f);
        return true;
    }

    final boolean a(fq fqVar) {
        boolean add = this.f.add(fqVar);
        if (add) {
            this.n = true;
            g();
            if (this.m) {
                if (this.n) {
                    this.n = false;
                    if (!TextUtils.isEmpty(this.h)) {
                        AsyncTask eaVar = new ea();
                        Object[] objArr = new Object[]{new ArrayList(this.f), this.h};
                        if (VERSION.SDK_INT >= 11) {
                            eaVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eaVar.execute(objArr);
                        }
                    }
                }
                f();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void g() {
        int size = this.f.size() - this.k;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                this.f.remove(0);
            }
        }
    }

    private void h() {
        try {
            InputStream openFileInput = this.g.openFileInput(this.h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new fq(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(c, "Error reading historical recrod file: " + this.h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(c, "Error reading historical recrod file: " + this.h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
