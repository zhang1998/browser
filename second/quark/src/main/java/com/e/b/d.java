package com.e.b;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.model.LogField;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class d {
    private Map<String, String> a = new HashMap(64);

    public d() {
        if (!this.a.containsKey("_field_page")) {
            this.a.put("_field_page", "UT");
        }
    }

    public final d a(Map<String, String> map) {
        if (map != null) {
            Set<Entry> entrySet = map.entrySet();
            if (entrySet != null) {
                for (Entry entry : entrySet) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key == null || !(key instanceof String)) {
                        af.c("param aProperties key error", "key", key, "value", value);
                    } else if (value == null || !(value instanceof String)) {
                        af.c("param aProperties value error", "key" + key, "value", value);
                    } else {
                        a((String) key, (String) value);
                    }
                }
            }
        }
        return this;
    }

    public Map<String, String> a() {
        String str;
        int i = 0;
        Map<String, String> map = this.a;
        map.put("_bmbu", "yes");
        if (map != null) {
            if (map.containsKey(null)) {
                map.remove(null);
            }
            if (map.containsKey("")) {
                map.remove("");
            }
            if (map.containsKey(LogField.PAGE.toString())) {
                af.d("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            } else if (map.containsKey(LogField.EVENTID.toString())) {
                af.d("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            } else if (map.containsKey(LogField.ARG1.toString())) {
                af.d("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            } else if (map.containsKey(LogField.ARG2.toString())) {
                af.d("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            } else if (map.containsKey(LogField.ARG3.toString())) {
                af.d("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            }
            if (i == 0) {
                return null;
            }
            if (map != null) {
                map.remove(LogField.PAGE.toString());
                map.remove(LogField.EVENTID.toString());
                map.remove(LogField.ARG1.toString());
                map.remove(LogField.ARG2.toString());
                map.remove(LogField.ARG3.toString());
                map.remove(LogField.ARGS.toString());
            }
            if (map != null) {
                str = (String) map.remove("_field_page");
                if (str != null) {
                    map.put(LogField.PAGE.toString(), str);
                }
                str = (String) map.remove("_field_arg1");
                if (str != null) {
                    map.put(LogField.ARG1.toString(), str);
                }
                str = (String) map.remove("_field_arg2");
                if (str != null) {
                    map.put(LogField.ARG2.toString(), str);
                }
                str = (String) map.remove("_field_arg3");
                if (str != null) {
                    map.put(LogField.ARG3.toString(), str);
                }
                str = (String) map.remove("_field_args");
                if (str != null) {
                    map.put(LogField.ARGS.toString(), str);
                }
                str = (String) map.remove("_field_event_id");
                if (str != null) {
                    map.put(LogField.EVENTID.toString(), str);
                }
            }
            if (map.containsKey(LogField.EVENTID.toString())) {
                return null;
            }
            return map;
        }
        i = 1;
        if (i == 0) {
            return null;
        }
        if (map != null) {
            map.remove(LogField.PAGE.toString());
            map.remove(LogField.EVENTID.toString());
            map.remove(LogField.ARG1.toString());
            map.remove(LogField.ARG2.toString());
            map.remove(LogField.ARG3.toString());
            map.remove(LogField.ARGS.toString());
        }
        if (map != null) {
            str = (String) map.remove("_field_page");
            if (str != null) {
                map.put(LogField.PAGE.toString(), str);
            }
            str = (String) map.remove("_field_arg1");
            if (str != null) {
                map.put(LogField.ARG1.toString(), str);
            }
            str = (String) map.remove("_field_arg2");
            if (str != null) {
                map.put(LogField.ARG2.toString(), str);
            }
            str = (String) map.remove("_field_arg3");
            if (str != null) {
                map.put(LogField.ARG3.toString(), str);
            }
            str = (String) map.remove("_field_args");
            if (str != null) {
                map.put(LogField.ARGS.toString(), str);
            }
            str = (String) map.remove("_field_event_id");
            if (str != null) {
                map.put(LogField.EVENTID.toString(), str);
            }
        }
        if (map.containsKey(LogField.EVENTID.toString())) {
            return map;
        }
        return null;
    }

    public final d a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            af.d("setProperty", "key is null or key is empty or value is null,please check it!");
        } else {
            if (this.a.containsKey(str)) {
                this.a.remove(str);
            }
            this.a.put(str, str2);
        }
        return this;
    }
}
