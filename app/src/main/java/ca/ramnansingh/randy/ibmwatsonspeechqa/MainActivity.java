package ca.ramnansingh.randy.ibmwatsonspeechqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.ibm.cio.watsonsdk.SpeechDelegate;
import com.ibm.cio.watsonsdk.SpeechToText;

public class MainActivity extends AppCompatActivity implements SpeechDelegate{

    public final static String EXTRA_MESSAGE = "ca.ramnansingh.randy.ibmwatsonspeechqa.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void speech2Text() {
        SpeechToText.sharedInstance().initWithContext("https://gateway.watsonplatform.net/question-and-answer-beta/api", this.getApplicationContext(), new SpeechConfiguration(SpeechConfiguration.AUDIO_FORMAT_OGGOPUS));
        SpeechToText.sharedInstance().setCredentials(this.USERNAME, this.PASSWORD);
        SpeechToText.sharedInstance().setDelegate(this);
        SpeechToText.sharedInstance().setModel("en-US_BroadbandModel");
        SpeechToText.sharedInstance().recognize();
        SpeechToText.sharedInstance().
    }

    public void onOpen() {
        // the  connection to the STT service is successfully opened
    }

    public void onError(String error) {
        // error interacting with the STT service
    }

    public void onClose(int code, String reason, boolean remote) {
        // the connection with the STT service was just closed
    }

    public void onMessage(String message) {
        // a message comes from the STT service with recognition results
    }
}
