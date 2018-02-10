package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.d.e;
import com.UCMobile.Apollo.ApolloMetaData;
import com.taobao.weex.ui.component.ab;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ds {
    private static int a = -1;

    public static c a(Context context, String str, t tVar) {
        try {
            InputStream open = context.getAssets().open(str);
            c ctVar = new ct(context.getResources(), tVar);
            ctVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{open});
            return ctVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Unable to find file " + str, e);
        }
    }

    public static c a(Resources resources, JSONObject jSONObject, t tVar) {
        c asVar = new as(resources, tVar);
        asVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
        return asVar;
    }

    public static c a(Resources resources, JSONObject jSONObject, t tVar, int i) {
        a = i;
        c asVar = new as(resources, tVar);
        asVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
        return asVar;
    }

    static k a(Resources resources, InputStream inputStream) {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            k a = a(resources, new JSONObject(new String(bArr, "UTF-8")));
            dn.a((Closeable) inputStream);
            return a;
        } catch (Throwable e) {
            throw new IllegalStateException("Unable to find file.", e);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to load JSON.", e2);
        } catch (Throwable th) {
            dn.a((Closeable) inputStream);
        }
    }

    static k a(Resources resources, JSONObject jSONObject) {
        Rect rect = null;
        float f = resources.getDisplayMetrics().density;
        if (a != -1) {
            f = ((float) resources.getDisplayMetrics().densityDpi) / ((float) a);
        }
        int optInt = jSONObject.optInt(ab.PROP_FS_WRAP_CONTENT, -1);
        int optInt2 = jSONObject.optInt("h", -1);
        if (!(optInt == -1 || optInt2 == -1)) {
            rect = new Rect(0, 0, (int) (((float) optInt) * f), (int) (((float) optInt2) * f));
        }
        k kVar = new k(rect, jSONObject.optLong(ApolloMetaData.KEY_IP, 0), jSONObject.optLong("op", 0), jSONObject.optInt("fr", 0), f);
        JSONArray optJSONArray = jSONObject.optJSONArray("assets");
        b(optJSONArray, kVar);
        a(optJSONArray, kVar);
        a(jSONObject, kVar);
        return kVar;
    }

    private static void a(JSONObject jSONObject, k kVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray("layers");
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            bx a = bv.a(optJSONArray.optJSONObject(i), kVar);
            List list = kVar.d;
            e eVar = kVar.c;
            list.add(a);
            eVar.a(a.c, a);
        }
    }

    private static void a(@Nullable JSONArray jSONArray, k kVar) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                if (optJSONArray != null) {
                    List arrayList = new ArrayList(optJSONArray.length());
                    e eVar = new e();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        bx a = bv.a(optJSONArray.optJSONObject(i2), kVar);
                        eVar.a(a.c, a);
                        arrayList.add(a);
                    }
                    kVar.a.put(optJSONObject.optString("id"), arrayList);
                }
            }
        }
    }

    private static void b(@Nullable JSONArray jSONArray, k kVar) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject.has("p")) {
                    bc bcVar = new bc(optJSONObject.optInt(ab.PROP_FS_WRAP_CONTENT), optJSONObject.optInt("h"), optJSONObject.optString("id"), optJSONObject.optString("p"));
                    kVar.b.put(bcVar.a, bcVar);
                }
            }
        }
    }
}
