package com.shin.testdraggablepanel;

import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.pedrovgs.DraggablePanel;

public class MainActivity extends AppCompatActivity {

    Button btn_click;
    DraggablePanel draggablePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        draggablePanel  = (DraggablePanel) findViewById(R.id.dp_draggable_panel);
        draggablePanel.setFragmentManager(getSupportFragmentManager());
        draggablePanel.setTopFragment(new One());
        draggablePanel.setBottomFragment(new Two());
        draggablePanel.setTopViewHeight(300);
        draggablePanel.initializeView();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                draggablePanel.closeToLeft();
            }
        }, 300);

        btn_click = (Button)findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draggablePanel.maximize();
            }
        });
    }
}
