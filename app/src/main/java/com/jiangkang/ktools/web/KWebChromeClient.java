package com.jiangkang.ktools.web;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.jiangkang.tools.widget.KDialog;


/**
 * Created by jiangkang on 2017/9/20.
 */

public class KWebChromeClient extends WebChromeClient {

    private static final String TAG = "Web";
    private WebContract.IView mContext;

    public KWebChromeClient(WebContract.IView context) {
        this.mContext = context;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.d(TAG, "onConsoleMessage:\n " + consoleMessage.message());
        return true;
    }


    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        KDialog.showMsgDialog(view.getContext(),message);
        return true;
    }


    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }


    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        mContext.getTvTitle().setText(title);
    }


    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        callback.invoke(origin,true,true);
    }


}
