package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.RegisterController;
import com.vitor.myclient.model.Login;
import com.vitor.myclient.model.Register;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    TextView helloTxt;
    ImageView orderPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        helloTxt = findViewById(R.id.helloTxt);
        orderPage = findViewById(R.id.orderPage);

        RegisterController registerController = new RegisterController(this);
        String name = registerController.getSavedName();

        helloTxt.setText("Hello, " + name + "!");

        orderPage.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
            startActivity(intent);
        });

    }
}