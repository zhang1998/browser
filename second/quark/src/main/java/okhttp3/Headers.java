package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

/* compiled from: ProGuard */
public final class Headers {
    private final String[] namesAndValues;

    /* compiled from: ProGuard */
    public final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        final Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public final Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public final Builder add(String str, String str2) {
            checkNameAndValue(str, str2);
            return addLenient(str, str2);
        }

        final Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public final Builder removeAll(String str) {
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase((String) this.namesAndValues.get(i))) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final Builder set(String str, String str2) {
            checkNameAndValue(str, str2);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        private void checkNameAndValue(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                length = str2.length();
                for (i = 0; i < length; i++) {
                    charAt = str2.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                    }
                }
            }
        }

        public final String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.namesAndValues.get(size))) {
                    return (String) this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public final Headers build() {
            return new Headers();
        }
    }

    private Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final String get(String str) {
        return get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        String str2 = get(str);
        return str2 != null ? HttpDate.parse(str2) : null;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    public final Set<String> names() {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public final List<String> values(String str) {
        int size = size();
        List list = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(name(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(value(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(name(i)).append(": ").append(value(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public final Map<String, List<String>> toMultimap() {
        Map<String, List<String>> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            String toLowerCase = name(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(toLowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(toLowerCase, list);
            }
            list.add(value(i));
        }
        return treeMap;
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static Headers of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        } else {
            int i;
            String[] strArr2 = (String[]) strArr.clone();
            for (i = 0; i < strArr2.length; i++) {
                if (strArr2[i] == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i] = strArr2[i].trim();
            }
            i = 0;
            while (i < strArr2.length) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i += 2;
                } else {
                    throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                }
            }
            return new Headers(strArr2);
        }
    }

    public static Headers of(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String trim = ((String) entry.getKey()).trim();
            String trim2 = ((String) entry.getValue()).trim();
            if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                strArr[i] = trim;
                strArr[i + 1] = trim2;
                i += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
            }
        }
        return new Headers(strArr);
    }
}
