package com.example.agenda_ref1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ExibeContatos extends AppCompatActivity {
    //listview para exibir a lista de contatos
    private ListView minhaLista;

    //adapter da listView
    private ArrayAdapter adapter;

    //array para a lista de contatos
    private static ArrayList<Contato> exibeLista;

    private ContatosDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibe_contatos);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        db = new ContatosDB(this);

        minhaLista = (ListView) findViewById(R.id.listViewXML);
        //chama o método findAll que devolve um array e guarda em exibeLista
        exibeLista = db.findAll();
        //criação de uma instância de um ListAdapter utilizando um layout nativo
        adapter = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, exibeLista);

        //associação a ListView com o adapter
        minhaLista.setAdapter(adapter);
    }

}
