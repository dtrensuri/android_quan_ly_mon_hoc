package edu.poly.monhocdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.SqLite.LopHocDao;
import edu.poly.monhocdemo.adapter.LopHocAdapter;
import edu.poly.monhocdemo.model.LopHoc;

public class List_Lop_Hoc extends AppCompatActivity {
    private ListView lvClasses;
    private List<LopHoc> list;
    private LopHocAdapter lhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lop_hoc);

        lvClasses = findViewById(R.id.lvClasses);
        duaDuLieuVaoList();

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                LopHocDao dao = new LopHocDao(List_Lop_Hoc.this);
                LopHoc cls = list.get(i);
                dao.delete(""+cls.getId());

                duaDuLieuVaoList();

                return false;
            }
        });
    }

    private void duaDuLieuVaoList(){
        LopHocDao dao = new LopHocDao(this);
        list = dao.getAll();

        lhAdapter = new LopHocAdapter(this, list);
        lvClasses.setAdapter(lhAdapter);
    }
}