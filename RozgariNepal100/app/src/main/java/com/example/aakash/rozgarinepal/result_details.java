package com.example.aakash.rozgarinepal;

public class result_details {
    String result_id, result_rt, result_sc, result_m, result_fp;

    public result_details() {
    }

    public result_details(String result_rt, String result_sc, String result_m, String result_fp) {
        this.result_id = result_id;
        this.result_rt = result_rt;
        this.result_sc = result_sc;
        this.result_m = result_m;
        this.result_fp = result_fp;
    }

    public String getResult_id() {
        return result_id;
    }

    public String getResult_rt() {
        return result_rt;
    }

    public void setResult_rt(String result_rt) {
        this.result_rt = result_rt;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public String getResult_sc() {
        return result_sc;
    }

    public void setResult_sc(String result_sc) {
        this.result_sc = result_sc;
    }

    public String getResult_m() {
        return result_m;
    }

    public void setResult_m(String result_m) {
        this.result_m = result_m;
    }

    public String getResult_fp() {
        return result_fp;
    }

    public void setResult_fp(String result_fp) {
        this.result_fp = result_fp;
    }
}