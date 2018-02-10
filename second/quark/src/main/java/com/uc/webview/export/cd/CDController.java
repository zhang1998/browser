package com.uc.webview.export.cd;

import com.uc.webview.export.cd.platform.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class CDController {
    public static final String JSON_CD_ENCRYPT_KEY = "encrypt";
    public static final String JSON_CD_OPERATE_TYPE_KEY = "operate_type";
    public static final String JSON_CD_RES_DATA_KEY = "data";
    public static final String ORIGIN_DATA_FILE_NAME = "origin";
    public static final String PREFIX_JSON_CD = "JSON_CD";
    private static final String TAG = CDController.class.getSimpleName();
    private static String mCDSavaDir = null;
    private static CDController sInstance;

    private CDController() {
    }

    public static synchronized CDController initInstance() {
        CDController cDController;
        synchronized (CDController.class) {
            if (sInstance == null) {
                sInstance = new CDController();
            }
            cDController = sInstance;
        }
        return cDController;
    }

    public static CDController getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new IllegalStateException("Not initialize the instance yet, call initInstance first.");
    }

    public static void setEnablePrintLog(boolean z) {
        Log.setEnable(z);
        Log.d(TAG, "setEnablePrintLog " + z);
    }

    public static void setCDSaveDir(String str) {
        Log.d(TAG, "setCDSaveDir " + str);
        mCDSavaDir = str;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Throwable e) {
            Log.printStackTraceString(TAG + "setCDSaveDir cd exception : ", e);
        }
    }

    private static String getSavedDir() {
        return mCDSavaDir;
    }

    public CDJsonConsumer parseFromFile(String str) {
        Log.d(TAG, "parseFromFile appDataDir " + str);
        if (CDUtil.isEmptyString(str)) {
            return null;
        }
        setCDSaveDir(str);
        return parse(null, CDUtil.readFile(getSavedDir() + "/origin"));
    }

    public CDJsonConsumer parse(String str, String str2) {
        Log.d(TAG, "parse data.len = " + str2.length());
        if (CDUtil.isEmptyString(str2)) {
            return null;
        }
        CDParser createCDParserForAndroid = CDParserFactory.getInstance().createCDParserForAndroid(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        createCDParserForAndroid.parse();
        Log.d(TAG, "parse time: " + (System.currentTimeMillis() - currentTimeMillis) + " milliseconds");
        createCDParserForAndroid.releaseOrigData();
        if (createCDParserForAndroid.getResult() != null) {
            return CDParserFactory.getInstance().createCDConsumerForAndroid(createCDParserForAndroid);
        }
        return null;
    }

    public void recoveryUseOldResData(Object obj) {
        Log.d(TAG, "recoveryUseOldResData.");
        try {
            if (obj instanceof CDJsonConsumer) {
                recoveryUseOldResData((CDJsonConsumer) obj);
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "public recoveryUseOldResData cd exception :  ", th);
        }
    }

    private void recoveryUseOldResData(CDJsonConsumer cDJsonConsumer) {
        new StringBuilder("recoveryUseOldResData consumer != null : ").append(cDJsonConsumer != null);
        try {
            String savedDir = getSavedDir();
            if (!CDUtil.isEmptyString(savedDir)) {
                String value;
                Map resourcesSpecialKey = cDJsonConsumer.getResourcesSpecialKey(JSON_CD_ENCRYPT_KEY, "true", "data");
                if (resourcesSpecialKey != null) {
                    for (Entry entry : resourcesSpecialKey.entrySet()) {
                        if (entry.getValue() == null) {
                            Object object = cDJsonConsumer.getObject((String) entry.getKey());
                            value = cDJsonConsumer.getValue(object, JSON_CD_OPERATE_TYPE_KEY);
                            if (CDUtil.isEmptyString(value) || value.equals("remove")) {
                                CDUtil.removeFile(savedDir + "/" + ((String) entry.getKey()));
                            } else {
                                value = CDUtil.readFile(savedDir + "/" + ((String) entry.getKey()));
                                if (!CDUtil.isEmptyString(value)) {
                                    ((JSONObject) object).put("data", value);
                                }
                            }
                        }
                    }
                }
                resourcesSpecialKey = cDJsonConsumer.getResourcesSpecialKey(JSON_CD_ENCRYPT_KEY, "false", "data");
                if (resourcesSpecialKey != null) {
                    for (Entry entry2 : resourcesSpecialKey.entrySet()) {
                        if (entry2.getValue() == null) {
                            Object object2 = cDJsonConsumer.getObject((String) entry2.getKey());
                            value = cDJsonConsumer.getValue(object2, JSON_CD_OPERATE_TYPE_KEY);
                            if (CDUtil.isEmptyString(value) || value.equals("remove")) {
                                CDUtil.removeFile(savedDir + "/" + ((String) entry2.getKey()));
                            } else {
                                CDJsonParser cDJsonParser = new CDJsonParser(CDUtil.readFile(savedDir + "/" + ((String) entry2.getKey())));
                                cDJsonParser.parse();
                                if (cDJsonParser.getResult() != null) {
                                    ((JSONObject) object2).put("data", cDJsonParser.getResult());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "recoveryUseOldResData cd exception :  ", th);
        }
    }

    public void dataPersistence(String str, Object obj) {
        Log.d(TAG, "dataPersistence.");
        try {
            if (obj instanceof CDJsonConsumer) {
                dataPersistence(str, (CDJsonConsumer) obj);
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "public dataPersistence cd exception :  ", th);
        }
    }

    private void dataPersistence(String str, CDJsonConsumer cDJsonConsumer) {
        new StringBuilder("dataPersistence originData.length : ").append(str.length()).append(" consumer != null : ").append(cDJsonConsumer != null);
        if (CDUtil.isEmptyString(mCDSavaDir)) {
            Log.e(TAG, "dataPersistent mAppDataDir is Empty! CD cann't be persisted.");
            return;
        }
        final Map hashMap = new HashMap();
        hashMap.put(ORIGIN_DATA_FILE_NAME, str);
        try {
            Map resourcesSpecialKey = cDJsonConsumer.getResourcesSpecialKey(JSON_CD_ENCRYPT_KEY, "true", "data");
            if (resourcesSpecialKey != null) {
                for (Entry entry : resourcesSpecialKey.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            resourcesSpecialKey = cDJsonConsumer.getResourcesSpecialKey(JSON_CD_ENCRYPT_KEY, "false", "data");
            if (resourcesSpecialKey != null) {
                for (Entry entry2 : resourcesSpecialKey.entrySet()) {
                    hashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "dataPersistent cd exception :  ", th);
        }
        new Thread() {
            public void run() {
                String access$000 = CDController.getSavedDir();
                if (!CDUtil.isEmptyString(access$000)) {
                    for (Entry entry : hashMap.entrySet()) {
                        CDUtil.saveDataToFile((String) entry.getValue(), access$000 + "/" + ((String) entry.getKey()));
                    }
                }
            }
        }.start();
    }

    public void dataEncrypt(Object obj) {
        Log.d(TAG, "dataEncrypt.");
        try {
            if (obj instanceof CDJsonConsumer) {
                dataEncrypt((CDJsonConsumer) obj);
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "public dataEncrypt cd exception :  ", th);
        }
    }

    private void dataEncrypt(CDJsonConsumer cDJsonConsumer) {
        new StringBuilder("dataEncrypt consumer != null : ").append(cDJsonConsumer != null);
        try {
            String value = cDJsonConsumer.getValue("pub_key");
            if (!CDUtil.isEmptyString(value)) {
                ArrayList objectsIncludeKeyValue = cDJsonConsumer.getObjectsIncludeKeyValue(JSON_CD_ENCRYPT_KEY, "true");
                if (objectsIncludeKeyValue != null) {
                    Iterator it = objectsIncludeKeyValue.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        new StringBuilder("dataEncrypt enctypt jObj : ").append(next);
                        String encrypt = RSAUtils.encrypt(value, cDJsonConsumer.getValue(next, "data"));
                        if (CDUtil.isEmptyString(encrypt)) {
                            Log.e(TAG, "dataEncrypt enatypt failue!!");
                        } else {
                            ((JSONObject) next).remove("data");
                            CDJsonParser cDJsonParser = new CDJsonParser(encrypt);
                            cDJsonParser.parse();
                            if (cDJsonParser.getResult() != null) {
                                ((JSONObject) next).put("data", cDJsonParser.getResult());
                            }
                            new StringBuilder("dataEncrypt enctypt modified jObj : ").append(next);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.printStackTraceString(TAG + "dataEncrypt cd exception :  ", th);
        }
    }
}
