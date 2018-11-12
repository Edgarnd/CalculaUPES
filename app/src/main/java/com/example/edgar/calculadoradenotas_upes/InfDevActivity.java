package com.example.edgar.calculadoradenotas_upes;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

import java.util.List;

public class InfDevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_dev);
    }

    //Method to Facebook
    public void FaceB(View view){
        Uri webpage = Uri.parse("http://www.facebook.com/Edgar.rda");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent, PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe){
            startActivity(webIntent);
        } else {
            Toast.makeText(this, "Buscame en facebook como Edgar Renderos", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to Instagram
    public void Insta(View view){
        Uri webpage = Uri.parse("https://www.instagram.com/edgar_rend/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe){
            startActivity(webIntent);
        } else {
            Toast.makeText(this, "Sigueme como edgar_rend", Toast.LENGTH_SHORT).show();
        }
    }
}
