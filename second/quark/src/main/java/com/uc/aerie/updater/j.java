package com.uc.aerie.updater;

import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.uc.aerie.updater.b.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class j {
    List<String> a = new ArrayList();
    String b;
    HashMap<String, i> c = new HashMap();

    private j() {
    }

    static j a(File file) {
        try {
            String str = new String(a.a(file));
            j jVar = new j();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("updateModules");
                jVar.a = Arrays.asList(jSONObject.getString("receivers").split(","));
                jVar.b = jSONObject.getString(SharePatchInfo.UPDATE_VERSION);
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.a = jSONObject.getBoolean("isMaster");
                    iVar.b = jSONObject.getString("name");
                    iVar.c = jSONObject.getString("md5");
                    iVar.d = jSONObject.getString("algorithm");
                    iVar.e = jSONObject.getString("algorithmVersion");
                    jVar.c.put(iVar.b, iVar);
                }
                return jVar;
            } catch (Throwable e) {
                Log.e("AerieUpdateManager", "generateUpdateInfoFromFile exception.", e);
                return null;
            }
        } catch (Throwable e2) {
            Log.e("UpdateInfo", "read update json exception.", e2);
            return null;
        }
    }
}
