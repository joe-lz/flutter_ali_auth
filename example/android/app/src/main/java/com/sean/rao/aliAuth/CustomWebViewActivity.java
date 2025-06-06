package xyz.todokit.plato;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

/**
 * @ProjectName: NumberAuthSDK_Standard_Android
 * @Package: com.aliqin.mytel.auth
 * @ClassName: CustomWebView
 * @Description: 自定义协议展示页
 * @Author: liuqi
 * @CreateDate: 2021/3/25 4:04 PM
 * @Version: 1.0
 */
public class CustomWebViewActivity extends Activity {
   private WebView mWebView;
   private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_web);
        String mUrl = getIntent().getStringExtra("url");
        String mName = getIntent().getStringExtra("name");
        setRequestedOrientation(getIntent().getIntExtra("orientation", ActivityInfo.SCREEN_ORIENTATION_PORTRAIT));
        mWebView = findViewById(R.id.webView);
        mToolbar = findViewById(R.id.toolbar);

        // 可参考设置 https://www.jianshu.com/p/2b68ac025612
        // 设置标题
        mToolbar.setTitle(mName);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onBackPressed();
          }
        });

        initWebView();
        mWebView.loadUrl(mUrl);
    }

    //第三种
    @Override
    public void onBackPressed() {
      //TODO something
      super.onBackPressed();
    }

    private void initWebView() {
        WebSettings wvSettings = mWebView.getSettings();
        // 是否阻止网络图像
        wvSettings.setBlockNetworkImage(false);
        // 是否阻止网络请求
        wvSettings.setBlockNetworkLoads(false);
        // 是否加载JS
        wvSettings.setJavaScriptEnabled(true);
        wvSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //覆盖方式启动缓存
        wvSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 使用广泛视窗
        wvSettings.setUseWideViewPort(true);
        wvSettings.setLoadWithOverviewMode(true);
        wvSettings.setDomStorageEnabled(true);
        //是否支持缩放
        wvSettings.setBuiltInZoomControls(false);
        wvSettings.setSupportZoom(false);
        //不显示缩放按钮
        wvSettings.setDisplayZoomControls(false);
        wvSettings.setAllowFileAccess(true);
        wvSettings.setDatabaseEnabled(true);
        //缓存相关
        // wvSettings.setAppCacheEnabled(true);
        wvSettings.setDomStorageEnabled(true);
        wvSettings.setDatabaseEnabled(true);
    }
}
