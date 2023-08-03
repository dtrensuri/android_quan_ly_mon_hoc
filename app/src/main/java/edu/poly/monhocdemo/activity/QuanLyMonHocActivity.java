package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.MonHocDao;
import edu.poly.monhocdemo.adapter.MonHocAdapter;
import edu.poly.monhocdemo.model.MonHoc;

public class QuanLyMonHocActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etTimKiemmh, etMaMon, etTenMon, etSoTin, etMucTieuDR, etHTT, etNganh;
    private Button btnLuuMH,btnXoaMH;

    ImageView imTroLaiMH;
    private List<MonHoc> monHocList;
    private ListView lvQuanLyMH;
    private MonHocAdapter monHocAdapter;
    private boolean isEdit = false;
    MonHocDao mhd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_mon_hoc);

        etMaMon = findViewById(R.id.etMaMon);
        etTenMon = findViewById(R.id.etTenMon);
        etSoTin = findViewById(R.id.etSoTin);
        etMucTieuDR = findViewById(R.id.etMucTieuDR);
        etHTT = findViewById(R.id.etHTT);
        etNganh = findViewById(R.id.etNganh);

        etTimKiemmh = findViewById(R.id.etTimKiemmh);


        lvQuanLyMH = findViewById(R.id.lvQuanLyMH);
        lvQuanLyMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonHoc mh = monHocList.get(i);
                etMaMon.setText(mh.getIdmonhoc());
                etTenMon.setText(mh.getTenmh());
                etSoTin.setText(mh.getSotin().toString());
                etMucTieuDR.setText(mh.getMuctieudaura());
                etHTT.setText(mh.getHinhthucdanhgia());
                etNganh.setText(mh.getNganh());
                isEdit = true;
            }
        });

        duaAllDuLieuVaoListView(null);

        findViewById(R.id.btnLuuMH).setOnClickListener(this);
        findViewById(R.id.btnXoaMH).setOnClickListener(this);
        findViewById(R.id.ivTroLaiMH).setOnClickListener(this);
        findViewById(R.id.ivSearchMH).setOnClickListener(this);
        findViewById(R.id.ivTroLaiMH).setOnClickListener(this);
    }

    private void duaAllDuLieuVaoListView(String dk){

        MonHocDao dao = new MonHocDao(this);
        if(dk==null){
            monHocList = dao.getAll();
        }else{
            monHocList = dao.SelectMH(dk);
        }

        monHocAdapter = new MonHocAdapter(this,monHocList);
        lvQuanLyMH.setAdapter(monHocAdapter);

    }

    @Override
    public void onClick(View view) {
        MonHocDao dao = new MonHocDao(this);
        switch(view.getId()){
            case R.id.btnLuuMH:
                MonHoc mh = new MonHoc();
                mh.setIdmonhoc(etMaMon.getText().toString());
                mh.setTenmh(etTenMon.getText().toString());
                mh.setSotin( Integer.parseInt (etSoTin.getText().toString()));
                mh.setMuctieudaura(etMucTieuDR.getText().toString());
                mh.setHinhthucdanhgia(etHTT.getText().toString());
                mh.setNganh(etNganh.getText().toString());

                String msg;

                if(!isEdit){
                    dao.insert(mh);
                    msg = "Môn học đã được lưu !";
                }else{
                    dao.update(mh);
                    msg = "Môn học đã được cập nhật !";
                }
                Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                snackbar.show();

                isEdit = false;
                duaAllDuLieuVaoListView(null);
                xoaTrang();
                break;
            case R.id.btnXoaMH:
                if(isEdit && !etMaMon.getText().toString().equals("")){
                    String id = etMaMon.getText().toString();
                    dao.delete(id);
                    duaAllDuLieuVaoListView(null);
                    Snackbar.make(view, "Môn học đã được xóa",Snackbar.LENGTH_LONG).show();
                    xoaTrang();
                }
                break;

            case R.id.ivSearchMH:
                String dieukien = etTimKiemmh.getText().toString().trim();
                if(TextUtils.isEmpty(dieukien)){
                    Toast.makeText(QuanLyMonHocActivity.this,"Bạn chưa nhập dữ liệu",Toast.LENGTH_SHORT).show();
                }
                duaAllDuLieuVaoListView(dieukien);
                break;

            case R.id.ivTroLaiMH:
                    finish();
                break;
        }
    }

    private void xoaTrang(){
        etMaMon.setText(" ");
        etTenMon.setText(" ");
        etSoTin.setText(" ");
        etMucTieuDR.setText(" ");
        etHTT.setText(" ");
        etNganh.setText(" ");
    }
}