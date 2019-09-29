package com.example.demothreadhandleasyntask;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static android.os.Build.VERSION.SDK_INT;

public class DownloadActivity extends Activity implements View.OnClickListener {
    private static final int REQUEST_PERMISSION = 1;
    private EditText mEdtLink;
    private Button mBtnDownload;
    private ProgressBar mPbDownload;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == MyAsyncTask.WHAT_PROGRESS_UPDATE) {
                int percent = message.arg1;
                mPbDownload.setProgress(percent);
            } else if (message.what == MyAsyncTask.WHAT_POST_EXCUTE) {
                Toast.makeText(DownloadActivity.this, "Download Complete", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private MyAsyncTask mMyAsyncTask;
    private String mListPermission[] = new String[]{
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        if (checkPermission()) {
            addControls();
        } else {
            if (SDK_INT >= android.os.Build.VERSION_CODES.M) {
                requestPermissions(mListPermission, REQUEST_PERMISSION);
            }
        }
        addEvents();
    }

    private boolean checkPermission() {
        if (SDK_INT >= android.os.Build.VERSION_CODES.M) {
            for (String p : mListPermission) {
                int state = checkSelfPermission(p);
                if (state != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            addControls();
        } else {
            finish();
        }
    }

    private void addEvents() {
        mBtnDownload.setOnClickListener(this);
    }

    private void addControls() {
        mEdtLink = findViewById(R.id.edtLink);
        mBtnDownload = findViewById(R.id.btnDownload);
        mPbDownload = findViewById(R.id.pbDownload);
        mEdtLink.setText("http://vnno-vn-6-tf-mp3-s1-zmp3.zadn.vn/0fa1213a097de023b96c/2819329265115630931?authen=exp=1569956684~acl=/0fa1213a097de023b96c/*~hmac=51998caa378bd0bf2a5ada7255a75719");
        //mEdtLink.setText("http://img.f50.bdpcdn.net/Assets/Media/2019/09/27/67/messi.jpg");
    }

    @Override
    public void onClick(View view) {
        String link = mEdtLink.getText().toString();
        if (link.isEmpty()) {
            Toast.makeText(this, "Url invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        mMyAsyncTask = new MyAsyncTask(handler);
        mMyAsyncTask.execute(link);
    }

}
