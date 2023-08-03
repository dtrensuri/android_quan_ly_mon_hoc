package edu.poly.monhocdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.poly.monhocdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnQuanLy).setOnClickListener(this);
        findViewById(R.id.btnMoRong).setOnClickListener(this);
        findViewById(R.id.btnDangXuat).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnQuanLy:
                Intent intent1 = new Intent(this, QuanLyActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnMoRong:
                Intent intent2 = new Intent(this, MoRongActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnDangXuat:
                finish();
        }
    }
}