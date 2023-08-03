package edu.poly.monhocdemo.dialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.ChuongTrinhDaoTao_DB;
import edu.poly.monhocdemo.model.ChuongTrinhDaoTao;

public class NhapChuongTrinhHocMoiDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText etChuongTrinhDT, etTenChuongTrinhDT, etSoTinDT, etNamBatDauDT;

    public NhapChuongTrinhHocMoiDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_quan_ly_chuong_trinh_dao_tao);
        etChuongTrinhDT = findViewById(R.id.etChuognTrinhDT);
        etTenChuongTrinhDT = findViewById(R.id.etTenChuongTrinhDT);
        etSoTinDT = findViewById(R.id.etSoTinDT);
        etNamBatDauDT = findViewById(R.id.etNamBatDauDT);
        findViewById(R.id.btnLuu).setOnClickListener(this);
        findViewById(R.id.btnDong).setOnClickListener(this);
    }
    protected boolean check(View view) throws ParseException {
        String msg;
        boolean checked = true;
        List<ChuongTrinhDaoTao> ct;
        ChuongTrinhDaoTao_DB dao = new ChuongTrinhDaoTao_DB(context);

        if(true){

        }
            if (etChuongTrinhDT.getText().toString().trim().isEmpty()){
                msg ="Mã chương trình đào tạo không được bỏ trống!!!";
                checked = false;
                Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                snackbar.show();
                msg ="";
            }else{
                ct = dao.SelectCT(etChuongTrinhDT.getText().toString());
                if(ct.isEmpty()==false){
                    msg ="Mã chương trình đào tạo đã tồn tại!!!";
                    checked = false;
                    Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                    snackbar.show();
                    msg ="";
                }
            }
        if (etTenChuongTrinhDT.getText().toString().trim().isEmpty()){
            msg ="Tên chương trình đào tạo không được bỏ trống!!!";
            checked = false;
            Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
            snackbar.show();
            msg ="";
        }

        if (etNamBatDauDT.getText().toString().trim().isEmpty()){
            msg ="Năm bắt đầu đào tạo không được bỏ trống!!!";
            checked = false;
            Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
            snackbar.show();
            msg ="";
        }else{
            try {
                int i = Integer.parseInt(etNamBatDauDT.getText().toString());
                if(i>Integer.parseInt(String.valueOf(java.time.LocalDate.now().getYear()))||i<1000){
                    msg ="Năm nhập vào không hợp lệ!!!";
                    checked = false;
                    Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                    snackbar.show();
                    msg ="";
                }
            }catch(Exception e){
                msg ="Năm nhập vào không hợp lệ!!!";
                checked = false;
                Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                snackbar.show();
                msg ="";
            }
        }
        if (etSoTinDT.getText().toString().trim().isEmpty()){
            msg ="Số tín chỉ đào tạo không được bỏ trống!!!";
            checked = false;
            Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
            snackbar.show();
            msg ="";
        }else{
            try {
                int i=  Integer.parseInt(etSoTinDT.getText().toString());
                if(i<=0){
                    msg ="Số tín chỉ không hợp lệ!!!";
                    checked = false;
                    Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                    snackbar.show();
                    msg ="";
                }
            }catch(Exception e){
                msg ="Số tín chỉ không hợp lệ!!!";
                checked = false;
                Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
                snackbar.show();
                msg ="";
            }
        }

        return checked;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLuu:
                try {
                    if (this.check(view)) {
                        ChuongTrinhDaoTao ctdt = new ChuongTrinhDaoTao();
                        ctdt.setIdchuongtrinhdt(etChuongTrinhDT.getText().toString());
                        ctdt.setTenchuongtrinhdt(etTenChuongTrinhDT.getText().toString());
                        ctdt.setSotinchidt(Integer.parseInt(etSoTinDT.getText().toString()));
                        ctdt.setNambatdaudt(etNamBatDauDT.getText().toString());

                        ChuongTrinhDaoTao_DB ctdt_db = new ChuongTrinhDaoTao_DB(context);
                        ctdt_db.insert(ctdt);
                        Toast.makeText(context, "Chương trình đã được lưu!", Toast.LENGTH_SHORT).show();
                        dismiss();

                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btnDong:
                dismiss();
                break;
        }
    }
}
