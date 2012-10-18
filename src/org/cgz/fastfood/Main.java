package org.cgz.fastfood;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Main extends Activity
{
    private Handler mHandler=new Handler();
    private WebView mWebView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String msg="mesg";
        Log.e("##########tag1", "msg");
        setContentView(R.layout.main);
        final WebView mWebView=(WebView)this.findViewById(R.id.webview);
        mWebView.loadUrl("http://192.168.2.100:8080/test_web/html/jquery-01.html");
        //mWebView.loadUrl("http://www.baidu.com");
        WebSettings webViewSetting=mWebView.getSettings();
        webViewSetting.setJavaScriptEnabled(true);

        mWebView.addJavascriptInterface(new Object(){
            public void clickOnAndroid(){
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("##########tag2","msg");
                        Log.e("##########tag3","msg");
                        Log.e("##########tag4","msg");
                        Log.e("##########tag5","msg");
                        Log.e("##########tag6","msg");
                        mWebView.loadUrl("javascript:ware()");
                    }
                });
            }
        },"demo");
        //System.out.println("test");
    }
}
