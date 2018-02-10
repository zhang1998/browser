package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;
import java.util.HashMap;
import java.util.List;

@Interface
/* compiled from: ProGuard */
public interface ICoreStat {

    @Interface
    /* compiled from: ProGuard */
    public abstract class CustomStat {
        private static CustomStat a = null;

        @Interface
        /* compiled from: ProGuard */
        public enum WALogType {
            SCENE(1),
            EVENT(2);
            
            private int a;

            private WALogType(int i) {
                this.a = 0;
                this.a = i;
            }

            public final int value() {
                return this.a;
            }
        }

        public abstract void WaStat(WaData waData);

        public abstract void stat(String str);

        public abstract void uploadCoreVideoStatByWA(WALogType wALogType, String str, HashMap<String, String> hashMap);

        public static void setInstance(CustomStat customStat) {
            a = customStat;
        }

        public static CustomStat getInstance() {
            return a;
        }
    }

    @Interface
    /* compiled from: ProGuard */
    public class WaData {
        public String category = null;
        public String eventAction = null;
        public String eventCategory = null;
        public HashMap<String, String> extValues = null;
        public List<String> keyList = null;
        public HashMap<String, String> values = null;

        public WaData(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, List<String> list) {
            this.category = str;
            this.eventCategory = str2;
            this.eventAction = str3;
            this.values = hashMap;
            this.extValues = hashMap2;
        }
    }

    String getCoreStatSerializeString();

    String[] getCoreStatUploadString();

    void initCoreStatFromString(String str);

    void setEnable(boolean z);
}
