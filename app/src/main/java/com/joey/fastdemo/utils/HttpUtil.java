package com.joey.fastdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.joey.fastdemo.common.AppContext;

/**
 * Created by move on 17/5/24.
 */

public class HttpUtil {
    public static boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) AppContext.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
        } catch (Exception e) {
            Log.v("ConnectivityManager", e.getMessage());
        }
        return false;
    }
}
