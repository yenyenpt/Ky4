package phamthiyen.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    LoginButton button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.layout.activity_main);
        callbackmanager= Callbackmanager.Factory.create();
        button.registerCall(callbackManager, new FacebokkCakklback<LoginRe>)
    }
}