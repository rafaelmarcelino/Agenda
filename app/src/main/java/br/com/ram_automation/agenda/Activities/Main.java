package br.com.ram_automation.agenda.Activities;

import android.app.Activity;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.ram_automation.agenda.R;

public class Main extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>();
        alunos.add("Rafael");
        alunos.add("Carmem");
        alunos.add("Barbara");
        alunos.add("Vera");
        alunos.add("Domingos");
        alunos.add("Aline");
        alunos.add("Rochele");

        ListView lv_alunos = findViewById(R.id.activity_main_lv_alunos);

        lv_alunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alunos));
    }
}
