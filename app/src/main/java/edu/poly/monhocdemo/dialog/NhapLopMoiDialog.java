package edu.poly.monhocdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.LopHocDao;
import edu.poly.monhocdemo.model.LopHoc;

public class NhapLopMoiDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText etLopId,etTenLop,etPhongHoc,etDiaChiLH;

    public NhapLopMoiDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_quan_ly_lop_hoc);

        etLopId = findViewById(R.id.etLopId);
        etTenLop = findViewById(R.id.etTenLop);
        etPhongHoc = findViewById(R.id.etPhongHoc);
        etDiaChiLH = findViewById(R.id.etDiaChiLH);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnClose).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                LopHoc lh = new LopHoc();
                lh.setTenlop(etTenLop.getText().toString());
                lh.setPhonghoc(etPhongHoc.getText().toString());
                lh.setDiachi(etDiaChiLH.getText().toString());
                LopHocDao dao = new LopHocDao(context);
                dao.insert(lh);
                Toast.makeText(context, "Lớp đã được lưu!", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            case R.id.btnClose:
                dismiss();
                break;
        }
    }
}