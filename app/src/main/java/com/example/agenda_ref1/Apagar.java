package com.example.agenda_ref1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Apagar extends AppCompatActivity {
    //variavel para inserir o nome do contato para apagar
    private EditText contato;
    //botão para apagar
    private Button btnApagar;

    private ContatosDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apagar);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        db = new ContatosDB(this);

        contato =  findViewById(R.id.nomeAXML);
        btnApagar = findViewById(R.id.apagarAXML);

        //listener do botão apagar chama o método apaga contado da classe ContatosDB
        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se não encontrar o registro devolve 0 senão devolve -1
                int count = db.apagaContato(contato.getText().toString());
                //não encontrou contato
                if (count == 0) {
                    Toast.makeText(Apagar.this, "Contato Inexistente!", Toast.LENGTH_SHORT).show();
                    contato.setText("");
                    // encontrou e apagou
                } else {
                    Toast.makeText(Apagar.this, "Contato apagado!", Toast.LENGTH_SHORT).show();
                    contato.setText("");
                }
            }
        });
    }
}