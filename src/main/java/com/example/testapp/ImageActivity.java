package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private Spinner imageSpinner;
    private Button ratingButton;
    private Button callSomeone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String detail = extras.getString("Key1");
            if(detail != null){
                Toast.makeText(this, detail, Toast.LENGTH_SHORT).show();
            }
        }

        imageSpinner = findViewById(R.id.ratingSpinner1);
        ratingButton = findViewById(R.id.ratingButton1);
        callSomeone = findViewById(R.id.callSomeone1);

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rIntent = new Intent();
                String getSelection = imageSpinner.getSelectedItem().toString();
                rIntent.putExtra("Key1", getSelection);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });

        callSomeone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = imageSpinner.getSelectedItemPosition();
                Intent implicitIntent = null;

                switch(position){
                    default:
                        implicitIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:07983298329"));
                        break;
                }

                if(implicitIntent != null){
                    if(isIntentAvailable(implicitIntent)){
                        startActivity(implicitIntent);
                    }else{
                        Toast.makeText(v.getContext(), "Not rated 10 - Can't call anyone.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }

    public boolean isIntentAvailable(Intent i){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(i, 0);
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;
    }

}
