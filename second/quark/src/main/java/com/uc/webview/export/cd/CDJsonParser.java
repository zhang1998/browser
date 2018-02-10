package com.uc.webview.export.cd;

import com.uc.webview.export.cd.platform.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class CDJsonParser extends CDParser {
    private static final String TAG = "CDJsonParser";
    JSONObject mJsonRootObj = null;
    String mOriginJson = null;

    public CDJsonParser(String str) {
        super(str);
        setOriginData(str);
    }

    public void setOriginData(String str) {
        this.mOriginJson = str;
        this.mJsonRootObj = null;
    }

    public void releaseOrigData() {
        this.mOriginJson = null;
    }

    public Object getResult() {
        return this.mJsonRootObj;
    }

    public void parse() {
        parse(this.mOriginJson);
    }

    private void parse(String str) {
        Throwable e;
        if (str != null) {
            new StringBuilder("jsonData.length : ").append(str.length());
            Object obj = null;
            try {
                this.mJsonRootObj = new JSONObject(str);
            } catch (Throwable e2) {
                Log.printStackTraceString("CDJsonParser.parse cd exception java.lang.ClassCastException ", e2);
                Log.d(TAG, ".parse faulure!!");
            } catch (Throwable e22) {
                Log.printStackTraceString("CDJsonParser.parse cd exception org.json.JSONException ", e22);
                Log.d(TAG, ".parse faulure!!");
            } catch (Throwable th) {
                e22 = th;
                int i = 1;
                if (obj != null) {
                    Log.d(TAG, ".parse faulure!!");
                }
                throw e22;
            }
        }
    }

    public String getStringValue(JSONObject jSONObject, String str) {
        Throwable e;
        Object obj = null;
        new StringBuilder(".getStringValue key : ").append(str).append(" inJsonObj != null : ").append(jSONObject != null);
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (str2.equals(str)) {
                    return jSONObject.get(str).toString();
                }
                Object obj2 = jSONObject.get(str2);
                if (obj2 instanceof JSONObject) {
                    str2 = getStringValue((JSONObject) obj2, str);
                    if (str2 != null) {
                        return str2;
                    }
                }
            }
            return null;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getStringValue cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getStringValue get " + str + " value faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getStringValue cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getStringValue get " + str + " value faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getStringValue get " + str + " value faulure!!");
            return null;
        }
    }

    public JSONArray getArrayValue(JSONObject jSONObject, String str) {
        Throwable e;
        Object obj = null;
        new StringBuilder(".getArrayValue key : ").append(str).append(" inJsonObj != null : ").append(jSONObject != null);
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object obj2 = jSONObject.get(str2);
                if (str2.equals(str) && (obj2 instanceof JSONArray)) {
                    return (JSONArray) obj2;
                }
                if (obj2 instanceof JSONObject) {
                    JSONArray arrayValue = getArrayValue((JSONObject) obj2, str);
                    new StringBuilder(".getArrayValue return : ").append(arrayValue);
                    if (arrayValue != null) {
                        return arrayValue;
                    }
                }
            }
            return null;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getArrayValue cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getArrayValue get " + str + " value faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getArrayValue cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getArrayValue get " + str + " value faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getArrayValue get " + str + " value faulure!!");
            return null;
        }
    }

    private void tranvelValues(JSONObject jSONObject, String str, ArrayList<String> arrayList) {
        Object obj;
        Throwable e;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                obj = jSONObject.get(str2);
                if (str2.equals(str) && (obj instanceof String)) {
                    arrayList.add((String) obj);
                } else if (obj instanceof JSONObject) {
                    tranvelValues((JSONObject) obj, str, arrayList);
                }
            }
            return;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParsertranvelValues cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, "tranvelValues get " + str + " value faulure!!");
            return;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParsertranvelValues cd exception org.json.JSONException ", e22);
            Log.d(TAG, "tranvelValues get " + str + " value faulure!!");
            return;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
        }
        if (obj != null) {
            Log.d(TAG, "tranvelValues get " + str + " value faulure!!");
        }
        throw e22;
    }

    public ArrayList<String> getStringValues(JSONObject jSONObject, String str) {
        Throwable th;
        Object obj = 1;
        new StringBuilder(".getValues key : ").append(str).append(" inJsonObj != null : ").append(jSONObject != null);
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        try {
            tranvelValues(jSONObject, str, arrayList);
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (obj == null) {
                throw th;
            }
            Log.d(TAG, ".getValuess get " + str + " value faulure!!");
            return null;
        }
    }

    public JSONObject getObject(JSONObject jSONObject, String str) {
        Throwable e;
        Object obj = null;
        new StringBuilder(".getObject key : ").append(str).append(" inJsonObj != null : ").append(jSONObject != null);
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        try {
            Iterator keys = jSONObject.keys();
            JSONObject jSONObject2 = null;
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (str2.equals(str)) {
                    return (JSONObject) jSONObject.get(str);
                }
                JSONObject object;
                Object obj2 = jSONObject.get(str2);
                if (obj2 instanceof JSONObject) {
                    object = getObject((JSONObject) obj2, str);
                    new StringBuilder(".getObject return : ").append(object);
                    if (object != null) {
                        return object;
                    }
                } else {
                    object = jSONObject2;
                }
                jSONObject2 = object;
            }
            return jSONObject2;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getObject cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getObject get " + str + " value faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getObject cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getObject get " + str + " value faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getObject get " + str + " value faulure!!");
            return null;
        }
    }

    public void tranvelObjects(JSONObject jSONObject, String str, ArrayList<Object> arrayList) {
        Object obj;
        Throwable e;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                obj = jSONObject.get(str2);
                if (obj instanceof JSONObject) {
                    if (str2.equals(str)) {
                        arrayList.add(obj);
                    } else {
                        tranvelObjects((JSONObject) obj, str, arrayList);
                    }
                }
            }
            return;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.tranvelObjects cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, "tranvelObjects get " + str + " value faulure!!");
            return;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.tranvelObjects cd exception org.json.JSONException ", e22);
            Log.d(TAG, "tranvelObjects get " + str + " value faulure!!");
            return;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
        }
        if (obj != null) {
            Log.d(TAG, "tranvelObjects get " + str + " value faulure!!");
        }
        throw e22;
    }

    public ArrayList<Object> getObjects(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList();
        try {
            tranvelObjects(jSONObject, str, arrayList);
            return arrayList;
        } catch (Throwable th) {
            if (1 != 0) {
                Log.d(TAG, ".getObjects get " + str + " object faulure!!");
                return null;
            }
        }
    }

    public ArrayList<Object> getObjectsIncludeKey(JSONObject jSONObject, String str) {
        Throwable e;
        if (jSONObject == null || str == null || str.length() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList();
        Object obj;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                obj = jSONObject.get((String) keys.next());
                if ((obj instanceof JSONObject) && ((JSONObject) obj).getString(str) != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getObjects cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getObjects get (" + str + ") faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getObjects cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getObjects get (" + str + ") faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getObjects get (" + str + ") faulure!!");
            return null;
        }
    }

    public ArrayList<Object> getObjectsIncludeKeyValue(JSONObject jSONObject, String str, String str2) {
        Object obj;
        Throwable e;
        if (jSONObject == null || str2 == null || str2.length() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                obj = jSONObject.get((String) keys.next());
                if (obj instanceof JSONObject) {
                    String string = ((JSONObject) obj).getString(str);
                    if (string != null && string.equals(str2)) {
                        arrayList.add(obj);
                    }
                }
            }
            return arrayList;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getObjects cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getResJsonObject get (" + str + ":" + str2 + ") faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getObjects cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getResJsonObject get (" + str + ":" + str2 + ") faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getResJsonObject get (" + str + ":" + str2 + ") faulure!!");
            return null;
        }
    }

    public Map<String, Object> getResources(JSONObject jSONObject, String str, String str2) {
        Throwable e;
        Object obj;
        if (jSONObject == null || str2 == null || str2.length() <= 0) {
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                Object obj2 = jSONObject.get(str3);
                if (obj2 instanceof JSONObject) {
                    String string = ((JSONObject) obj2).getString(str);
                    if (string != null && string.equals(str2)) {
                        hashMap.put(str3, obj2);
                    }
                }
            }
            return hashMap;
        } catch (Throwable e2) {
            Log.printStackTraceString("CDJsonParser.getResources cd exception java.lang.ClassCastException ", e2);
            Log.d(TAG, ".getResources get (" + str + ":" + str2 + ") faulure!!");
            return null;
        } catch (Throwable e22) {
            Log.printStackTraceString("CDJsonParser.getResources cd exception org.json.JSONException ", e22);
            Log.d(TAG, ".getResources get (" + str + ":" + str2 + ") faulure!!");
            return null;
        } catch (Throwable th) {
            e22 = th;
            int i = 1;
            if (obj == null) {
                throw e22;
            }
            Log.d(TAG, ".getResources get (" + str + ":" + str2 + ") faulure!!");
            return null;
        }
    }

    public String toString() {
        return this.mJsonRootObj == null ? "null" : this.mJsonRootObj.toString();
    }
}
