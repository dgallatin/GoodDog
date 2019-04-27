package com.example.gooddog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class CameraActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.good_dog_camera);

        // Register button presses
        Button camBack = findViewById(R.id.cam_back_button);
        camBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onBack();
            }
        });

        FloatingActionButton camSnapshot = findViewById(R.id.cam_snapshot);
        camSnapshot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onSnapshot();
            }
        });

        // TODO Start Camera preview and object detection
        SurfaceView camPreview = findViewById(R.id.cam_preview);
    }

    private void onBack()
    {
        // TODO Free camera
        this.finish();
    }

    private void onSnapshot()
    {
        // TODO Take a picture, crop to dogs, save cropped photos and free camera
        String savedImage = "";
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("image_location", savedImage);
        startActivity(intent);
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context)
    {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
}
