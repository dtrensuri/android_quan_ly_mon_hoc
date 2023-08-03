package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.dialog.NhapLopMoiDialog;

public class QuanLyLopHocActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_hoc);
        findViewById(R.id.btnThemLop).setOnClickListener(this);
        findViewById(R.id.btnDanhSachLop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnThemLop:
                NhapLopMoiDialog dialog = new NhapLopMoiDialog(this);
                dialog.show();

                break;
            case R.id.btnDanhSachLop:
                Intent intent = new Intent(this, List_Lop_Hoc.class);
                startActivity(intent);
                break;
        }
    }
}