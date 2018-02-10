package com.uc.crashsdk.export;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class CustomLogInfo {
    public boolean mAddFooter = true;
    public boolean mAddHeader = true;
    public boolean mAddLogcat = false;
    public boolean mAddThreadsDump = false;
    public ArrayList<String> mCachedInfos = null;
    public ArrayList<String> mCallbacks = null;
    public StringBuffer mData;
    public ArrayList<String> mDumpFiles = null;
    public ArrayList<Integer> mDumpTids = null;
    public String mLogType;
    public boolean mUploadNow = false;

    public CustomLogInfo(StringBuffer stringBuffer, String str) {
        this.mData = stringBuffer;
        this.mLogType = str;
    }

    public CustomLogInfo(CustomLogInfo customLogInfo) {
        Iterator it;
        this.mData = customLogInfo.mData;
        this.mLogType = customLogInfo.mLogType;
        this.mAddHeader = customLogInfo.mAddHeader;
        this.mAddFooter = customLogInfo.mAddFooter;
        this.mAddLogcat = customLogInfo.mAddLogcat;
        this.mUploadNow = customLogInfo.mUploadNow;
        this.mAddThreadsDump = customLogInfo.mAddThreadsDump;
        if (customLogInfo.mDumpFiles != null) {
            this.mDumpFiles = new ArrayList();
            it = customLogInfo.mDumpFiles.iterator();
            while (it.hasNext()) {
                this.mDumpFiles.add((String) it.next());
            }
        }
        if (customLogInfo.mCallbacks != null) {
            this.mCallbacks = new ArrayList();
            it = customLogInfo.mCallbacks.iterator();
            while (it.hasNext()) {
                this.mCallbacks.add((String) it.next());
            }
        }
        if (customLogInfo.mCachedInfos != null) {
            this.mCachedInfos = new ArrayList();
            it = customLogInfo.mCachedInfos.iterator();
            while (it.hasNext()) {
                this.mCachedInfos.add((String) it.next());
            }
        }
        if (customLogInfo.mDumpTids != null) {
            this.mDumpTids = new ArrayList();
            it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                this.mDumpTids.add((Integer) it.next());
            }
        }
    }
}
