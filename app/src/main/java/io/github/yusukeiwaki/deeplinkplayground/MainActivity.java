package io.github.yusukeiwaki.deeplinkplayground;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri != null) {
                setUrl(uri.toString());
                return;
            }
        }
        setUrl(null);
    }

    private <T extends View> T findViewById2(int resId) {
        return (T) findViewById(resId);
    }

    private void setUrl(String url) {
        TextView urlText = findViewById2(R.id.url);
        if (TextUtils.isEmpty(url)) {
            urlText.setText("(empty)");
        } else {
            urlText.setText(url);
        }
    }
}
