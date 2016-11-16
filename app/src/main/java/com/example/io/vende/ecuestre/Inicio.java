package com.example.io.vende.ecuestre;

/**
 * Created by MauricioVende on 09/11/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Inicio extends Fragment{
    static WebView wv_inicio;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inicioView = inflater.inflate(R.layout.fm_inicio,container,false);
        wv_inicio = (WebView)inicioView.findViewById(R.id.wv_inicio);
        wv_inicio.getSettings().setJavaScriptEnabled(true);

        wv_inicio.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                // Inject CSS when page is done loading
                injectCSS();
                super.onPageFinished(view, url);
            }
        });


        wv_inicio.loadUrl("http://ecuestre.digital/");

        return inicioView;
    }

    private void injectCSS() {
        String css = ".page_head {display:none !important}" +
                ".navbar{display:none !important}";
        wv_inicio.loadUrl("javascript:(function() {" +
                "var parent = document.getElementsByTagName('head').item(0);" +
                "var style = document.createElement('style');" +
                "style.type = 'text/css';" +
                "style.innerHTML = '" + css + "';" +
                "parent.appendChild(style);" +
                "})()");
    }

    public static boolean canGoBack(){
        return wv_inicio.canGoBack();
        // return true;
    }

    public static void goBack(){
        wv_inicio.goBack();
        // return true;
    }


}
