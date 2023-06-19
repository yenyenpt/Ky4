package phamthiyen.example.assignment2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.GridView;

import phamthiyen.example.assignment2.Adapter.GridViewAdapter;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Toolbar toolbar;
    ActionBar actionBar;
    String[] name = {"Course", "Maps", "News", "Social"
    };
    int[] img = {R.drawable.mu, R.drawable.map, R.drawable.lich, R.drawable.cd};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_home_24);
        }
        if (actionBar != null) {
            actionBar.setTitle("Hỗ trợ học tập");
        }

        GridViewAdapter gridViewAdapter = new GridViewAdapter(getApplicationContext(), img, name);
        gridView.setAdapter(gridViewAdapter);

    }
}