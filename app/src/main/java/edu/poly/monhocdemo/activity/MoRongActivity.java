package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import edu.poly.monhocdemo.R;

public class MoRongActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_rong);
        findViewById(R.id.ivThongTinCaNhan).setOnClickListener(this);
        findViewById(R.id.ivTaiKhoan).setOnClickListener(this);
        findViewById(R.id.ivThoiGianBieu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivThongTinCaNhan:

                break;
            case R.id.ivTaiKhoan:

                break;
            case R.id.ivThoiGianBieu:

                break;

        }
    }
}