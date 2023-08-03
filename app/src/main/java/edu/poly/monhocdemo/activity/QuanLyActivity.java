package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.poly.monhocdemo.R;

public class QuanLyActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        findViewById(R.id.btnSinhVien).setOnClickListener(this);
        findViewById(R.id.btnMonHoc).setOnClickListener(this);
        findViewById(R.id.btnLopHoc).setOnClickListener(this);
        findViewById(R.id.ivTroLaiQL).setOnClickListener(this);
        findViewById(R.id.btnChuongTrinhDaoTao).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSinhVien:
                Intent it = new Intent(this, QuanLySinhVienActivity.class);
                startActivity(it);
                break;
            case R.id.btnMonHoc:
                Intent it1 = new Intent(this, QuanLyMonHocActivity.class);
                startActivity(it1);
                break;
            case R.id.btnLopHoc:
                Intent it2 = new Intent(this, QuanLyLopHocActivity.class);
                startActivity(it2);
                break;
            case R.id.btnChuongTrinhDaoTao:
                Intent it3 = new Intent(this, QuanLyChuongTrinhDaoTaoActivity.class);
                startActivity(it3);
                break;
            case R.id.ivTroLaiQL:
                finish();
                break;
        }
    }
}