package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.MonHocDao;
import edu.poly.monhocdemo.SqLite.SinhVienDao;
import edu.poly.monhocdemo.adapter.MonHocAdapter;
import edu.poly.monhocdemo.adapter.SinhVienAdapter;
import edu.poly.monhocdemo.helper.DataTimeHelper;
import edu.poly.monhocdemo.model.MonHoc;
import edu.poly.monhocdemo.model.SinhVien;

public class QuanLySinhVienActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText etTimKiemSV, etIdSV, etHoTenSV, etGioiTinhSV, etNgaySinhSV, etDiaChiSV, etSDTSV, etGmailSV;

    private List<SinhVien> sinhVienList;
    private ListView lvQuanLySV;
    private SinhVienAdapter sinhVienAdapter;
    private boolean isEdit = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sinh_vien);

        etIdSV = findViewById(R.id.etIdSV);
        etHoTenSV = findViewById(R.id.etHoTenSV);
        etGioiTinhSV = findViewById(R.id.etGioiTinhSV);
        etNgaySinhSV = findViewById(R.id.etNgaySinhSV);
        etDiaChiSV = findViewById(R.id.etDiaChiSV);
        etGmailSV = findViewById(R.id.etGmailSV);
        etSDTSV = findViewById(R.id.etSDTSV);


        etTimKiemSV = findViewById(R.id.etTimKiemSV);


        lvQuanLySV = findViewById(R.id.lvQuanLySV);
        lvQuanLySV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = sinhVienList.get(i);
                etIdSV.setText(sv.getIdsinhvien());
                etHoTenSV.setText(sv.getHotensv());
                etGioiTinhSV.setText(sv.getGioitinhsv());
                etNgaySinhSV.setText(DataTimeHelper.toString(sv.getNgaysinhsv()));
                etDiaChiSV.setText(sv.getDiachisv());
                etGmailSV.setText(sv.getGmailsv());
                etSDTSV.setText(sv.getSdtsv());
                isEdit = true;
            }
        });

        try {
            duaAllDuLieuVaoListView(null);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        findViewById(R.id.btnLuuSV).setOnClickListener(this);
        findViewById(R.id.btnXoaSV).setOnClickListener(this);
        findViewById(R.id.ivTimKiemSV).setOnClickListener(this);
    }
    public boolean check(View view){
        boolean check=true;
        String msg ="";
        if(etGmailSV.getText().toString().trim().isEmpty()==false){
            if(etGmailSV.getText().toString().contains("@")!=true){
                check = false;
                msg = "Định dạng email chưa đúng!!!!";
            }
        }
        if(etIdSV.getText().toString().trim().isEmpty()){
            check = false;
            msg = "Mã sinh viên không được để trống!!!!";
        }
        if(etHoTenSV.getText().toString().trim().isEmpty()){
            check = false;
            msg = "Họ và tên không được để trống!!!!";
        }
        if(etGioiTinhSV.getText().toString()==""){
            check = false;
            msg = "Giới tính không được để trống!!!!";
        }else{
            if(etGioiTinhSV.getText().toString().equals("nam")==false&&etGioiTinhSV.getText().toString().equals("nu")==false){
                check = false;
                msg = "Giới tính chỉ được điền nam hoặc nữ";
            }
        }
        if(etNgaySinhSV.getText().toString().trim().isEmpty()==false){
            try {
                DataTimeHelper.toDate(etNgaySinhSV.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
                check = false;
                msg = "Định dạng ngày sinh chưa đúng dd/MM/yyyy";
            }
        }
        if(check!= true) {
            Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
            snackbar.show();
            msg ="";
        }
        return check;
    }
    private void duaAllDuLieuVaoListView(String dk) throws ParseException {

        SinhVienDao dao = new SinhVienDao(this);
        if(dk==null){
            sinhVienList = dao.getAll();
        }else{
            sinhVienList = dao.SelectSV(dk);
        }

        sinhVienAdapter = new SinhVienAdapter(this,sinhVienList);
        lvQuanLySV.setAdapter(sinhVienAdapter);
    }
//public boolean check(){
//       boolean check=false;
//    if(etGmailSV.getText().toString().contains("@")){
//        check = true;
//    }
//    return check;
//}
    @Override
    public void onClick(View view) {
        SinhVienDao dao = new SinhVienDao(this);
        switch(view.getId()){
            case R.id.btnLuuSV:
            if(check(view)){
                    SinhVien sv = new SinhVien();
                    sv.setIdsinhvien(etIdSV.getText().toString());
                    sv.setHotensv(etHoTenSV.getText().toString());
                    sv.setGioitinhsv(etGioiTinhSV.getText().toString());
                    try {
                        sv.setNgaysinhsv(DataTimeHelper.toDate(etNgaySinhSV.getText().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    sv.setDiachisv(etDiaChiSV.getText().toString());
                    sv.setSdtsv(etGmailSV.getText().toString());
                    sv.setGmailsv(etSDTSV.getText().toString());

                    String msg;

                    if(!isEdit){
                        dao.insert(sv);
                        msg = "Sinh viên đã được lưu !";
                    }else{
                        dao.update(sv);
                        msg = "Sinh viên đã được cập nhật !";
                    }
                    Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                    snackbar.show();

                    isEdit = false;
                    try {
                        duaAllDuLieuVaoListView(null);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    xoaTrang();
            }
                break;

            case R.id.btnXoaSV:
                if(isEdit && !etIdSV.getText().toString().equals("")){
                    String id = etIdSV.getText().toString();
                    dao.delete(id);
                    try {
                        duaAllDuLieuVaoListView(null);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Snackbar.make(view, "Sinh viên đã được xóa",Snackbar.LENGTH_LONG).show();
                    xoaTrang();
                }
                break;

            case R.id.ivTimKiemSV:
                String dieukien = etTimKiemSV.getText().toString().trim();
                if(TextUtils.isEmpty(dieukien)){
                    Toast.makeText(QuanLySinhVienActivity.this,"Bạn chưa nhập dữ liệu",Toast.LENGTH_SHORT).show();
                }
                try {
                    duaAllDuLieuVaoListView(dieukien);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(sinhVienList.isEmpty()){
                    Toast.makeText(QuanLySinhVienActivity.this,"Không tìm thấy !!!",Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    private void xoaTrang(){
        etIdSV.setText(" ");
        etHoTenSV.setText(" ");
        etGioiTinhSV.setText(" ");
        etNgaySinhSV.setText(" ");
        etDiaChiSV.setText(" ");
        etGmailSV.setText(" ");
        etSDTSV.setText(" ");

    }
}