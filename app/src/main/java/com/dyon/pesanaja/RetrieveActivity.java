package com.dyon.pesanaja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RetrieveActivity extends AppCompatActivity {
    FloatingActionButton fabAdd;
//    RecyclerView recyclerView;
    ListView listView;
    private DatabaseHelper dbHelper;
    private ArrayList<Order> ordersArrayList;

    String valueId, valueName, valueNote;
    Integer valueRice, valueChicken, valueCatfish, valueMineral, valueTea, valueOrange;

    LayoutInflater inflater;

    Cursor cursor;

    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_view);
        fabAdd = findViewById(R.id.floatingActionButton);
        dbHelper = new DatabaseHelper(this);
        ordersArrayList = dbHelper.getAllOrders();
        refreshData();

////        recyclerView = findViewById(R.id.recycleView);
//        listView = findViewById(R.id.listView);
//
//        dbHelper = new DatabaseHelper(this);
////        adapter = new OrderAdapter(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        ordersArrayList = dbHelper.getAllOrders();
//        cursor =  db.rawQuery("SELECT*FROM tb_order", null);
//
//        String [] daftar;
//        daftar = new String[cursor.getCount()];
//        cursor.moveToFirst();
//        for (int i=0; i< cursor.getCount();i++){
//            cursor.moveToPosition(i);
//            daftar[i] = cursor.getString(1);
//        }
//        listView = findViewById(R.id.listView);
//        listView.setSelected(true);
//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,daftar));
//        listView.setOnItemClickListener((adapterView, view, position, l) -> {
//            final Order order = ordersArrayList.get(position);
//            dialogForm(order.getId().toString(), order.getNameCustomer(), order.getRice(), order.getChicken(), order.getCatfish(), order.getMineral(), order.getTea(), order.getOrange(), order.getNote(), "update");
//
////            String DataSelect = daftar[position];
////            Intent toView = new Intent(ViewActivity.this, DetailActivity.class);
////            toView.putExtra("nama", DataSelect);
////            startActivity(toView);
//        });


//        List<Order> itemList = new ArrayList<Order>();
//        itemList = ordersArrayList;
//        adapter = new OrderAdapter(RetrieveActivity.this, itemList);
//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                final Order order = ordersArrayList.get(i);
//                AlertDialog.Builder builder = new AlertDialog.Builder(RetrieveActivity.this);
//                  dialogForm(order.getId().toString(), order.getNameCustomer(), order.getRice(), order.getChicken(), order.getCatfish(), order.getMineral(), order.getTea(), order.getOrange(), order.getNote(), "update");
//            }
//        });


//        adapter.setListOrders(ordersArrayList);
//

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RetrieveActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//                @Override
//                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                    return false;
//                }
//
//                @Override
//                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                    dialogForm(valueId, valueName, valueRice, valueChicken, valueCatfish, valueMineral, valueTea, valueOrange, valueNote, "update");
//                }
//
//                @Override
//                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//                    dialogForm(valueId, valueName, valueRice, valueChicken, valueCatfish, valueMineral, valueTea, valueOrange, valueNote, "update");
//                }
//            }
//        );

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogForm("", "", 0, 0, 0, 0, 0, 0, "", "add");
            }
        });
    }

    public void dialogForm(String id, String nama, Integer rice, Integer chicken, Integer catfish, Integer mineral, Integer tea, Integer orange, String note, String button){
        AlertDialog.Builder dialogForm = new AlertDialog.Builder(RetrieveActivity.this);
        inflater = getLayoutInflater();
        View viewDialog = inflater.inflate(R.layout.form_order, null);
        dialogForm.setView(viewDialog);
        dialogForm.setCancelable(true);
        dialogForm.setTitle("Form Mahasiswa");

        EditText tnama = (EditText) viewDialog.findViewById(R.id.inNama);
        EditText trice = (EditText) viewDialog.findViewById(R.id.inRice);
        EditText tchicken = (EditText) viewDialog.findViewById(R.id.inChicken);
        EditText tcatfish = (EditText) viewDialog.findViewById(R.id.inCatfish);
        EditText tmineral = (EditText) viewDialog.findViewById(R.id.inMineral);
        EditText ttea = (EditText) viewDialog.findViewById(R.id.inTea);
        EditText torange = (EditText) viewDialog.findViewById(R.id.inOrange);
        EditText tnote = (EditText) viewDialog.findViewById(R.id.inNote);

        if (id.isEmpty()){
            tnama.setText(null);
            trice.setText(null);
            tchicken.setText(null);
            tcatfish.setText(null);
            tmineral.setText(null);
            ttea.setText(null);
            torange.setText(null);
            tnote.setText(null);
        }else{
            tnama.setText(nama);
            trice.setText(rice);
            tchicken.setText(chicken);
            tcatfish.setText(catfish);
            tmineral.setText(mineral);
            ttea.setText(tea);
            torange.setText(orange);
            tnote.setText(note);
        }

        dialogForm.setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueName = tnama.getText().toString();
                valueRice = Integer.parseInt(trice.getText().toString());
                valueChicken = Integer.parseInt(tchicken.getText().toString());
                valueCatfish = Integer.parseInt(tcatfish.getText().toString());
                valueMineral = Integer.parseInt(tmineral.getText().toString());
                valueTea = Integer.parseInt(ttea.getText().toString());
                valueOrange = Integer.parseInt(torange.getText().toString());
                valueNote = tnote.getText().toString();
                simpan();
                dialog.dismiss();
            }
        });
        dialogForm.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tnama.setText(null);
                trice.setText(null);
                tchicken.setText(null);
                tcatfish.setText(null);
                tmineral.setText(null);
                ttea.setText(null);
                torange.setText(null);
                tnote.setText(null);
            }
        });
        dialogForm.show();
    }

    public void simpan(){
//        Map<String, Object> params = new HashMap<>();
//        params.put("nama", valueName);
//        params.put("rice", valueRice);
//        params.put("chicken", valueChicken);
//        params.put("catfish", valueCatfish);
//        params.put("mineral", valueMineral);
//        params.put("tea", valueTea);
//        params.put("orange", valueOrange);
//        params.put("note", valueNote);

        if (dbHelper.addOrderDetail(valueName, valueRice, valueChicken, valueCatfish, valueMineral, valueTea, valueOrange, valueNote) > 0){
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        ordersArrayList = dbHelper.getAllOrders();
//        adapter.setListOrders(ordersArrayList);
//        adapter.notifyDataSetChanged();
//    }
    public void refreshData(){
        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor =  db.rawQuery("SELECT*FROM tb_order", null);

        String [] daftar;
        daftar = new String[cursor.getCount()];
            cursor.moveToFirst();
            for (int i=0; i< cursor.getCount();i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1);
        }
        listView = findViewById(R.id.listView);
        listView.setSelected(true);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,daftar));
        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            final Order order = ordersArrayList.get(position);
            dialogForm(order.getId().toString(), order.getNameCustomer(), order.getRice(), order.getChicken(), order.getCatfish(), order.getMineral(), order.getTea(), order.getOrange(), order.getNote(), "update");
        });
    }
}
