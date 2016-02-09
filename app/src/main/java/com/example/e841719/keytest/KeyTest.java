package com.example.e841719.keytest;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class KeyTest extends AppCompatActivity /* implements View.OnKeyListener Activity */ {
    EditText edit1;
    EditText log1;
    static final String theApp = "KeyTest: ";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    final static String TAG=theApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_test);

        log1 = (EditText) findViewById(R.id.logText);
        log1.setHorizontallyScrolling(false);

        edit1 = (EditText) findViewById(R.id.editText);
        edit1.requestFocus();

        edit1.setKeyListener(new KeyListener() {
            @Override
            public int getInputType() {
                return  InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT;
//                return 0;
            }

            @Override
            public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
                String name = getResources().getResourceEntryName(view.getId());
                String action = "onKeyDown";

                final String message = "[KeyEvent, {name:" + name +
                        "},{action:" + action +
                        "},{code:" + String.valueOf(keyCode) +
                        "},{chars:" + event.getCharacters() +
                        "},{char:" + event.getUnicodeChar() +
                        "},{scode:" + event.getScanCode() +
                        "}]";
                Log.d(TAG, message);
                addLog(message);
                return false;
            }

            @Override
            public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
                String name = getResources().getResourceEntryName(view.getId());
                String action = "onKeyDown";

                final String message = "[KeyEvent, {name:" + name +
                        "},{action:" + action +
                        "},{code:" + String.valueOf(keyCode) +
                        "},{chars:" + event.getCharacters() +
                        "},{char:" + event.getUnicodeChar() +
                        "},{scode:" + event.getScanCode() +
                        "}]";
                Log.d(TAG, message);
                addLog(message);
                return false;
            }

            @Override
            public boolean onKeyOther(View view, Editable text, KeyEvent event) {
                return false;
            }

            @Override
            public void clearMetaKeyState(View view, Editable content, int states) {

            }
        });
        /*
        edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
            //    addLog(String.format("onKey: %s, keyCode: %s (%s)", event.getScanCode(), event.getKeyCode(), keyCode));
            //    addLog(KeyEvent.keyCodeToString(keyCode));
                return false;
            }
        });
        */
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int scanCode = event.getScanCode();
        Log.d(theApp, "KeyDown");
        //addLog(String.format("KeyDown: %s, %s", event.getScanCode(), event.getKeyCode()));
        return false;
    }// End of onKeyDown

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        Log.d(theApp, "KeyUp");
        //addLog(String.format("KeyUp: %s, %s (%s)", event.getScanCode(), event.getKeyCode(), keyCode));
        return false;
    }// End of onKeyUp

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(theApp, String.valueOf(event.getKeyCode()));
        String[] sActions=new String[]{"Down","Up","Multiple"};
        String sAction=sActions[event.getAction()];
        addLog(String.format("dispatchKeyEvent: Action: %s, ScanCode %s, KeyCode: %s", sAction, event.getScanCode(), event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }
    */

    void addLog(String s) {
        StringBuilder sEdit = new StringBuilder();
        sEdit.append(log1.getText());
        sEdit.append(s + "\n");
        log1.setText(sEdit);
        Log.d(theApp, s);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "KeyTest Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.e841719.keytest/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "KeyTest Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.e841719.keytest/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
