package com.taobao.weex.bridge;

import com.uc.apollo.impl.SettingsConst;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class WXParams {
    private String appName;
    private String appVersion;
    private String deviceHeight;
    private String deviceModel;
    private String deviceWidth;
    private String logLevel;
    private String needInitV8;
    private Map<String, String> options;
    private String osVersion;
    private String platform;
    private String shouldInfoCollect;
    private String weexVersion;

    public Object getOptions() {
        return this.options;
    }

    public void setOptions(Map<String, String> map) {
        this.options = map;
    }

    public String getShouldInfoCollect() {
        return this.shouldInfoCollect;
    }

    public void setShouldInfoCollect(String str) {
        this.shouldInfoCollect = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getWeexVersion() {
        return this.weexVersion;
    }

    public void setWeexVersion(String str) {
        this.weexVersion = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getDeviceWidth() {
        return this.deviceWidth;
    }

    @Deprecated
    public void setDeviceWidth(String str) {
        this.deviceWidth = str;
    }

    public String getDeviceHeight() {
        return this.deviceHeight;
    }

    public void setDeviceHeight(String str) {
        this.deviceHeight = str;
    }

    public String getLogLevel() {
        if (this.logLevel == null) {
            return "";
        }
        return this.logLevel;
    }

    public void setLogLevel(String str) {
        this.logLevel = str;
    }

    public String getNeedInitV8() {
        if (this.needInitV8 == null) {
            return "";
        }
        return this.needInitV8;
    }

    public void setNeedInitV8(boolean z) {
        if (z) {
            this.needInitV8 = SettingsConst.TRUE;
        } else {
            this.needInitV8 = SettingsConst.FALSE;
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", getPlatform());
            jSONObject.put("osVersion", getOsVersion());
            jSONObject.put("appVersion", getAppVersion());
            jSONObject.put("weexVersion", getWeexVersion());
            jSONObject.put("deviceModel", getDeviceModel());
            jSONObject.put("appName", getAppName());
            jSONObject.put("deviceWidth", getDeviceWidth());
            jSONObject.put("deviceHeight", getDeviceHeight());
            jSONObject.put("logLevel", getLogLevel());
            if (this.options != null) {
                for (String str : this.options.keySet()) {
                    jSONObject.put(str, this.options.get(str));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
