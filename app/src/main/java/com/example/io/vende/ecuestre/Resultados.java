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

public class Resultados extends Fragment{
    static WebView wv_resultados;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View resultadosView = inflater.inflate(R.layout.fm_resultados,container,false);
        wv_resultados = (WebView)resultadosView.findViewById(R.id.wv_resultados);
        wv_resultados.getSettings().setJavaScriptEnabled(true);

        wv_resultados.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                // Inject CSS when page is done loading
                injectCSS();
                super.onPageFinished(view, url);
            }
        });

        wv_resultados.loadUrl("http://ecuestre.digital/publico/concursos.php");


        return resultadosView;
    }

    private void injectCSS() {
        String css = ".page_head {display:none !important}" +
                ".navbar{display:none !important}";
        wv_resultados.loadUrl("javascript:(function() {" +
                "var parent = document.getElementsByTagName('head').item(0);" +
                "var style = document.createElement('style');" +
                "style.type = 'text/css';" +
                "style.innerHTML = '" + css + "';" +
                "parent.appendChild(style);" +
                "})()");
    }

    public static boolean canGoBack(){
        return wv_resultados.canGoBack();
        // return true;
    }

    public static void goBack(){
        wv_resultados.goBack();
        // return true;
    }


}
