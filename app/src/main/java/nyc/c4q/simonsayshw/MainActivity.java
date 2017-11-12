package nyc.c4q.simonsayshw;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.net.ssl.HandshakeCompletedEvent;

public class MainActivity extends AppCompatActivity {
    private Button greenButton;
    private Button yellowButton;
    private Button blueButton;
    private Button redButton;

    private ArrayList<Button> simonSequence = new ArrayList<>();
    private ArrayList<Button> colorsClicked = new ArrayList<>();
    private ArrayList<Button> colors = new ArrayList<>();

    int x;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenButton = (Button) findViewById(R.id.green_button);
        yellowButton = (Button) findViewById(R.id.yellow_button);
        blueButton = (Button) findViewById(R.id.blue_button);
        redButton = (Button) findViewById(R.id.red_button);

        colors.add(greenButton);
        colors.add(yellowButton);
        colors.add(blueButton);
        colors.add(redButton);

        Toast.makeText(getApplicationContext(), "Pay attention to the colors flashing and then click them in the same order", Toast.LENGTH_SHORT).show();


        greenButton.setBackgroundColor(getResources().getColor(R.color.black));
        yellowButton.setBackgroundColor(getResources().getColor(R.color.black));
        blueButton.setBackgroundColor(getResources().getColor(R.color.black));
        redButton.setBackgroundColor(getResources().getColor(R.color.black));

        max = 1;
        runGame();

        }

        public void runGame(){
        final Handler handler = new Handler();
        x = 0;
        final Runnable runnable = new Runnable() {
            public void run() {
                Random r = new Random();
                int c = r.nextInt(4);
                if (x < max) {
                    simonSequenceRuns(colors.get(c));
                    //mp.stop();
                    handler.postDelayed(this, 3000);
//                    normalColors(colors.get(c));
                }
                else{
                    greenButton.setBackgroundColor(getResources().getColor(R.color.green));
                    yellowButton.setBackgroundColor(getResources().getColor(R.color.yellow));
                    blueButton.setBackgroundColor(getResources().getColor(R.color.blue));
                    redButton.setBackgroundColor(getResources().getColor(R.color.red));
                }
                x++;
            }
        };
        // trigger first time
        handler.post(runnable);

    }

        public void simonSequenceRuns(Button btn){
        simonSequence.add(btn);
        switch(btn.getId()) {
            case  R.id.green_button:
                greenButton.setBackgroundColor(getResources().getColor(R.color.light_green));
                break;
            case R.id.yellow_button:
                yellowButton.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                break;
            case R.id.blue_button:
                blueButton.setBackgroundColor(getResources().getColor(R.color.light_blue));
                break;
            case R.id.red_button:
                redButton.setBackgroundColor(getResources().getColor(R.color.light_red));
                break;
            default:
                break;
        }
    }

//    public void normalColors(Button btn){
//        switch(btn.getId()) {
//            case R.id.green_button:
//                greenButton.setBackgroundColor(getResources().getColor(R.color.green));
//                break;
//            case R.id.yellow_button:
//                yellowButton.setBackgroundColor(getResources().getColor(R.color.yellow));
//                break;
//            case R.id.blue_button:
//                blueButton.setBackgroundColor(getResources().getColor(R.color.blue));
//                break;
//            case R.id.red_button:
//                redButton.setBackgroundColor(getResources().getColor(R.color.red));
//                break;
//            default:
//                break;
//        }
//    }

        public void playerClicks(View v) {
            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_four);
        switch (v.getTag().toString()){
            case "green":
                colorsClicked.add(greenButton);
                greenButton.setBackgroundColor(getResources().getColor(R.color.light_green));
                mp.start();
                break;
            case "yellow":
                colorsClicked.add(yellowButton);
                yellowButton.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                mp.start();
                break;
            case "blue":
                colorsClicked.add(blueButton);
                blueButton.setBackgroundColor(getResources().getColor(R.color.light_blue));
                mp.start();
                break;
            case "red":
                colorsClicked.add(redButton);
                redButton.setBackgroundColor(getResources().getColor(R.color.light_red));
                mp.start();
                break;
        }
       // compareSequences(simonSequence, colorsClicked);
    }


//    public void compareSequences(ArrayList<Button> simonSequence, ArrayList<Button> colorsClicked){
//        if (!simonSequence.equals(colorsClicked)) {
//            //Game Over
//        } else {
//            greenButton.setBackgroundColor(getResources().getColor(R.color.black));
//            yellowButton.setBackgroundColor(getResources().getColor(R.color.black));
//            blueButton.setBackgroundColor(getResources().getColor(R.color.black));
//            redButton.setBackgroundColor(getResources().getColor(R.color.black));
//            max++;
//            if (max >= 4) {
//
//            }
//            runGame();
//
//        }
//    }


