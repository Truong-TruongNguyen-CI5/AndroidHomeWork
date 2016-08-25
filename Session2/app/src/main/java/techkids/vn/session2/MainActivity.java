package techkids.vn.session2;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString() ;
    ToggleButton tgFlash;
    Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        getReferences();
        setOnFlashDefault();
        addListenners();
    }
    public void getCamera(){
        try {
            camera = Camera.open();
        }catch (RuntimeException e){
            Log.e(TAG,String.format( "Could not open Camera %s", e.getMessage()) );
    }
    }
    void setOnFlashDefault(){
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
    }
    void getReferences(){
        tgFlash = (ToggleButton) findViewById(R.id.tg_Flash);
    }
    private void addListenners(){
        tgFlash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG,String.format( "TgFlash check changed %s", b));
                if(b) {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                }
                else{
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                }
            }
        });
    }
}
