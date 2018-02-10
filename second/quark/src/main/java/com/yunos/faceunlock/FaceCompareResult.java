package com.yunos.faceunlock;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class FaceCompareResult {
    private String approximate_name;
    private int error_flag;
    private float score;
    private int type;

    public FaceCompareResult(float f, String str, int i) {
        this.score = f;
        this.approximate_name = str;
        this.error_flag = i;
        this.type = 2;
    }

    public FaceCompareResult(String str) {
        int i = 0;
        try {
            i = new JSONObject(str).getInt("similarity");
        } catch (JSONException e) {
        }
        this.score = ((float) i) / 100.0f;
        this.approximate_name = "";
        this.error_flag = 1;
        this.type = 1;
    }

    public String toString() {
        return "FaceCompareResult [approximate_name=" + this.approximate_name + ", score=" + this.score + ", error_flag=" + this.error_flag + "]\n";
    }

    public String getApproximate_name() {
        return this.approximate_name;
    }

    public void setApproximate_name(String str) {
        this.approximate_name = str;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public int getError_flag() {
        return this.error_flag;
    }

    public void setError_flag(int i) {
        this.error_flag = i;
    }

    public boolean isValid() {
        return this.error_flag == 1;
    }

    public boolean isLocal() {
        return this.type == 2;
    }

    public boolean isOnline() {
        return this.type == 1;
    }
}
