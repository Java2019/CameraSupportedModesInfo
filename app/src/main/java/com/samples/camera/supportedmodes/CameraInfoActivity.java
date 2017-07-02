package com.samples.camera.supportedmodes;

import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class CameraInfoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_info);

        TextView text = (TextView)findViewById(R.id.text);
        text.setMovementMethod(new ScrollingMovementMethod());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Camera camera = Camera.open();

        Camera.Parameters params = camera.getParameters();

        List<Camera.Size> sizes = params.getSupportedPreviewSizes();
        if (sizes != null){
            text.append("Supported Picture Sizes:\n");
            for (Camera.Size size : sizes) {
                text.append(String.format("%dx%d; ",
                        size.height, size.width));
            }
        }
        else {
            text.append("\nNo Supported Picture Sizes");
        }
        List<String> flashModes = params.getSupportedFlashModes();
        if (flashModes != null) {
            text.append("\n\nSupported Flash modes :\n");
            for (String mode : flashModes) {
                text.append(String.format("%s; ", mode));
            }
        }
        else {
            text.append("\nNo Supported Flash Modes");
        }
        List<String> antibandings = params.getSupportedAntibanding();
        if (antibandings != null) {
            text.append("\n\nSupported Antibanding :\n");
            for (String mode : antibandings) {
                text.append(String.format("%s; ", mode));
            }
        }
        else {
                text.append("\nNo Supported Antibanding");
            }
        List<String> colorEffects = params.getSupportedColorEffects();
        if (colorEffects != null) {
                text.append("\n\nSupported color effects \n");
                for (String mode : colorEffects) {
                    text.append(String.format("%s; ", mode));
                }
            }
        else {
                text.append("\nNo Supported Color Effects");
            }
        List<String> focusModes = params.getSupportedFocusModes();
        if (focusModes != null) {
                text.append("\n\nSupported Focus Modes \n");
                for (String mode : focusModes) {
                    text.append(String.format("%s; ", mode));
                }
            }
        else {
                text.append("\nNo Supported Focus Modes");
            }
        List<Size> previewSizes = params.getSupportedPreviewSizes();
        if (previewSizes != null) {
                text.append("\n\nSupported Preview Sizes \n");
                for (Size mode : previewSizes) {
                    text.append(String.format("%dx%d; ",
                            mode.height, mode.width));
                }
            }
        else {
                text.append("\nNo Supported Preview Sizes");
            }

        List<String> sceneModes = params.getSupportedSceneModes();
        if (sceneModes != null) {
                text.append("\n\nSupported SceneModes \n");
                for (String mode : sceneModes) {
                    text.append(String.format("%s; ", mode));
                }
            }
        else {
                text.append("\nNo Supported SceneModes");
            }
        List<String> whiteBalances = params.getSupportedWhiteBalance();
        if (whiteBalances != null) {
            text.append("\nSupported White Balance \n");
            for (String mode : whiteBalances) {
                text.append(String.format("%s; ", mode));
            }
        }
        else {
            text.append("\nNo Supported White Balance");
        }
        camera.release();
    }
}
