package br.com.ram_automation.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Main extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView nome = new TextView(this);
        nome.setText("Rafael Alves Marcelino");

        setContentView(nome);
    }
}
