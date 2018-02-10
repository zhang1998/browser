package com.uc.webview.export.cd;

import com.uc.webview.export.cd.platform.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class CDJsonConsumer {
    private static final String TAG = "CDJsonConsumer";
    CDJsonParser mParser;

    public CDJsonConsumer(CDParser cDParser) {
        this.mParser = (CDJsonParser) cDParser;
    }

    public String getValue(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getStringValue((JSONObject) this.mParser.getResult(), str);
    }

    public String getValue(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getStringValue((JSONObject) obj, str);
    }

    public ArrayList<String> getValues(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getStringValues((JSONObject) this.mParser.getResult(), str);
    }

    public ArrayList<String> getValues(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getStringValues((JSONObject) obj, str);
    }

    public ArrayList<String> getArray(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return getArray(this.mParser.getResult(), str);
    }

    public ArrayList<String> getArray(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONArray arrayValue = this.mParser.getArrayValue((JSONObject) obj, str);
            if (arrayValue == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList();
            for (int i = 0; i < arrayValue.length(); i++) {
                String string = arrayValue.getString(i);
                if (string != null && string.length() > 0) {
                    arrayList.add(arrayValue.getString(i));
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.printStackTraceString("CDJsonConsumergetArray cd exception org.json.JSONException ", e);
            return null;
        }
    }

    public Object getObject(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObject((JSONObject) this.mParser.getResult(), str);
    }

    public Object getObject(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObject((JSONObject) obj, str);
    }

    public ArrayList<Object> getObjects(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObjects((JSONObject) this.mParser.getResult(), str);
    }

    public ArrayList<Object> getObjects(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObjects((JSONObject) obj, str);
    }

    public ArrayList<Object> getObjectsIncludeKey(String str) {
        if (this.mParser == null || this.mParser.getResult() == null || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObjectsIncludeKey((JSONObject) this.mParser.getResult(), str);
    }

    public ArrayList<Object> getObjectsIncludeKey(Object obj, String str) {
        if (obj == null || !(obj instanceof JSONObject) || str == null || str.length() <= 0) {
            return null;
        }
        return this.mParser.getObjectsIncludeKey((JSONObject) obj, str);
    }

    public ArrayList<Object> getObjectsIncludeKeyValue(String str, String str2) {
        if (this.mParser == null || this.mParser.getResult() == null || str2 == null || str2.length() <= 0 || str2 == null || str2.length() <= 0) {
            return null;
        }
        return this.mParser.getObjectsIncludeKeyValue((JSONObject) this.mParser.getResult(), str, str2);
    }

    public Map<String, String> getResourcesSpecialKey(String str, String str2, String str3) {
        if (this.mParser == null || this.mParser.getResult() == null || str2 == null || str2.length() <= 0 || str2 == null || str2.length() <= 0) {
            return null;
        }
        Map resources = this.mParser.getResources((JSONObject) this.mParser.getResult(), str, str2);
        try {
            Map<String, String> hashMap = new HashMap();
            for (Entry entry : resources.entrySet()) {
                hashMap.put(entry.getKey(), this.mParser.getStringValue((JSONObject) entry.getValue(), str3));
            }
            return hashMap;
        } catch (Throwable e) {
            Log.printStackTraceString("CDJsonConsumergetResourcesSpecialKey cd exception :  ", e);
            return null;
        }
    }

    public void saveToFile(String str) {
        Log.d(TAG, "saveToFile path:" + str);
        if (!CDUtil.isEmptyString(str) && this.mParser != null && this.mParser.getResult() != null) {
            CDUtil.saveDataToFile(this.mParser.toString(), str);
        }
    }

    public String toString() {
        return this.mParser == null ? "null" : this.mParser.toString();
    }
}
