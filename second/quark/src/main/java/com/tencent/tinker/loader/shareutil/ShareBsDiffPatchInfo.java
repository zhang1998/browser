package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ProGuard */
public class ShareBsDiffPatchInfo {
    private static final String IGNORE_CREATE_SYMLINK = "ignoreCreateSymlink";
    public String md5;
    public String name;
    public String patchMd5;
    public String path;
    public String rawCrc;

    public ShareBsDiffPatchInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.md5 = str2;
        this.rawCrc = str4;
        this.patchMd5 = str5;
        this.path = str3;
    }

    public static void parseDiffPatchInfo(String str, ArrayList<ShareBsDiffPatchInfo> arrayList, ArrayList<String> arrayList2) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    if (str2.startsWith(IGNORE_CREATE_SYMLINK)) {
                        arrayList2.addAll(Arrays.asList(str2.substring(19, str2.length()).trim().split(",")));
                    } else {
                        String[] split = str2.split(",", 5);
                        if (split != null && split.length >= 5) {
                            arrayList.add(new ShareBsDiffPatchInfo(split[0].trim(), split[2].trim(), split[1].trim(), split[3].trim(), split[4].trim()));
                        }
                    }
                }
            }
        }
    }

    public static boolean checkDiffPatchInfo(ShareBsDiffPatchInfo shareBsDiffPatchInfo) {
        if (shareBsDiffPatchInfo == null) {
            return false;
        }
        String str = shareBsDiffPatchInfo.name;
        String str2 = shareBsDiffPatchInfo.md5;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.md5);
        stringBuffer.append(",");
        stringBuffer.append(this.rawCrc);
        stringBuffer.append(",");
        stringBuffer.append(this.patchMd5);
        return stringBuffer.toString();
    }
}
