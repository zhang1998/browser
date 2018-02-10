package com.airbnb.lottie;

import android.graphics.Color;
import com.UCMobile.Apollo.ApolloMetaData;
import com.taobao.weex.ui.component.ab;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class bv {
    static bx a(JSONObject jSONObject, k kVar) {
        cp cpVar;
        List list;
        String optString = jSONObject.optString("nm");
        String optString2 = jSONObject.optString("refId");
        long optLong = jSONObject.optLong("ind");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int optInt = jSONObject.optInt("ty", -1);
        if (optInt < cp.Unknown.ordinal()) {
            cpVar = cp.values()[optInt];
        } else {
            cpVar = cp.Unknown;
        }
        long optLong2 = jSONObject.optLong("parent", -1);
        if (cpVar == cp.Solid) {
            i = (int) (((float) jSONObject.optInt("sw")) * kVar.g);
            i2 = (int) (((float) jSONObject.optInt("sh")) * kVar.g);
            i3 = Color.parseColor(jSONObject.optString("sc"));
        }
        du a = g.a(jSONObject.optJSONObject("ks"), kVar);
        int i6 = br.a()[jSONObject.optInt("tt")];
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
        if (optJSONArray != null) {
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                int i7;
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                String optString3 = optJSONObject.optString("mode");
                Object obj = -1;
                switch (optString3.hashCode()) {
                    case 97:
                        if (optString3.equals("a")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 105:
                        if (optString3.equals("i")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 115:
                        if (optString3.equals("s")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        i7 = df.a;
                        break;
                    case 1:
                        i7 = df.b;
                        break;
                    case 2:
                        i7 = df.c;
                        break;
                    default:
                        i7 = df.d;
                        break;
                }
                arrayList2.add(new j(i7, dh.a(optJSONObject.optJSONObject("pt"), kVar)));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
        if (optJSONArray2 != null) {
            for (optInt = 0; optInt < optJSONArray2.length(); optInt++) {
                Object a2 = db.a(optJSONArray2.optJSONObject(optInt), kVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
        float optDouble2 = ((float) jSONObject.optDouble("st")) / kVar.b();
        if (cpVar == cp.PreComp) {
            i4 = (int) (((float) jSONObject.optInt(ab.PROP_FS_WRAP_CONTENT)) * kVar.g);
            i5 = (int) (((float) jSONObject.optInt("h")) * kVar.g);
        }
        float optLong3 = (float) jSONObject.optLong(ApolloMetaData.KEY_IP);
        float optLong4 = (float) jSONObject.optLong("op");
        if (optLong3 > 0.0f) {
            list = arrayList3;
            list.add(new p(kVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
        }
        if (optLong4 <= 0.0f) {
            optLong4 = (float) (kVar.f + 1);
        }
        list = arrayList3;
        list.add(new p(kVar, Float.valueOf(IPictureView.DEFAULT_MIN_SCALE), Float.valueOf(IPictureView.DEFAULT_MIN_SCALE), null, optLong3, Float.valueOf(optLong4)));
        if (optLong4 <= kVar.b()) {
            list = arrayList3;
            list.add(new p(kVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, optLong4, Float.valueOf((float) kVar.f)));
        }
        return new bx(arrayList, kVar, optString, optLong, cpVar, optLong2, optString2, arrayList2, a, i, i2, i3, optDouble, optDouble2, i4, i5, arrayList3, i6);
    }
}
