package com.yunos.faceunlock.facemanager.model;

import android.content.ContentValues;

/* compiled from: ProGuard */
public class FaceRecord {
    public String feature;
    public String landmark;
    public String name;
    public String path;
    public int uploaded;

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", this.name);
        contentValues.put("landmark", this.landmark);
        contentValues.put("feature", this.feature);
        contentValues.put("path", this.path);
        contentValues.put("uploaded", Integer.valueOf(this.uploaded));
        return contentValues;
    }

    public float[] str2floatArray(String str) {
        return null;
    }

    public String floatArray2str(float[] fArr) {
        return null;
    }
}
