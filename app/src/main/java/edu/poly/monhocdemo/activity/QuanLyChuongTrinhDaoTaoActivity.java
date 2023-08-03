package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.ParseException;
import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.ChuongTrinhDaoTao_DB;
import edu.poly.monhocdemo.adapter.ChuongTrinhDaoTaoAdapter;
import edu.poly.monhocdemo.dialog.NhapChuongTrinhHocMoiDialog;
import edu.poly.monhocdemo.helper.DataTimeHelper;
import edu.poly.monhocdemo.model.ChuongTrinhDaoTao;
import edu.poly.monhocdemo.model.SinhVien;

public class QuanLyChuongTrinhDaoTaoActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lvChuongTrinh;
    private List<ChuongTrinhDaoTao> list;
    private ChuongTrinhDaoTaoAdapter chuongTrinhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_chuong_trinh_dao_tao);

        lvChuongTrinh = findViewById(R.id.lvChuongTrinh);
        duaDuLieuVaoList();
        findViewById(R.id.ivTroLaiCTDT).setOnClickListener(this);
        findViewById(R.id.fabLoadDanhSach).setOnClickListener(this);
        findViewById(R.id.fabThemCT).setOnClickListener(this);

        lvChuongTrinh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChuongTrinhDaoTao_DB ct_db = new ChuongTrinhDaoTao_DB(QuanLyChuongTrinhDaoTaoActivity.this);
                ChuongTrinhDaoTao cls = list.get(i);
                ct_db.delete(""+cls.getIdchuongtrinhdt());
                duaDuLieuVaoList();

                return false;
            }
        });
//        lvChuongTrinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ChuongTrinhDaoTao daoTao = list.get(i);
//                Intent intent = new Intent(QuanLyChuongTrinhDaoTaoActivity.this, NhapChuongTrinhHocMoiDialog.class);
//                intent.putExtra("id_ctdt",daoTao.getIdchuongtrinhdt());
//                startActivity(intent);
//            }
//        });
    }

    public void duaDuLieuVaoList(){
        ChuongTrinhDaoTao_DB ct_db = new ChuongTrinhDaoTao_DB(this);
        try {
            list = ct_db.getAll();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chuongTrinhAdapter = new ChuongTrinhDaoTaoAdapter(this, list);
        lvChuongTrinh.setAdapter(chuongTrinhAdapter);
    }

    @Override
    public void onClick(View view) {
        duaDuLieuVaoList();
        switch (view.getId()){
            case R.id.ivTroLaiCTDT:
                finish();
                break;
            case R.id.fabThemCT:
                NhapChuongTrinhHocMoiDialog dialog = new NhapChuongTrinhHocMoiDialog(this);
                dialog.show();
                break;
            case R.id.fabLoadDanhSach:
                duaDuLieuVaoList();
                break;
        }
    }
}