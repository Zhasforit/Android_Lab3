package kz.talipovsn.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Extendedactivity extends AppCompatActivity {

    // Локальные переменные для доступа к компонентам окна
    private EditText editText;
    private EditText editText2;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных доступа к компонентам окна
        editText =   findViewById(R.id.editText);
        editText2 =   findViewById(R.id.editText2);
        checkBox =   findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
    }

    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    public void onInfo(View v) {
        // Создание второго окна
        Intent intent = new Intent(Extendedactivity.this, ResultActivity.class);
        //Intent intent = new Intent("kz.talipovsn.questionnaire.ResultActivity");

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("fio", editText.getText().toString());
        intent.putExtra("color", editText2.getText().toString());
        intent.putExtra("robot", checkBox.isChecked() ? getString(R.string.Не_робот) : getString(R.string.Робот));
        intent.putExtra("game", selectRadioButton.getText());

        // Запуск второго окна
        startActivity(intent);
    }

    public void onBack(View v) {
        setResult(RESULT_OK);
        finish();
    }
}
