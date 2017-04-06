package com.lsmore.simplemvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lsmore.simplemvpdemo.R;
import com.lsmore.simplemvpdemo.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IView {

    EditText name;
    TextView showText;

    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) this.findViewById(R.id.editText);
        showText = (TextView) this.findViewById(R.id.textView);

        presenter = new Presenter(this);
    }

    public void onSave(View view){
        presenter.saveItem();
    }

    public void onShow(View view){
        presenter.showItem();
    }

    @Override
    public String getItemName() {

        return name.getText().toString();
    }

    @Override
    public void showItemName(String name) {

        showText.setText(name);
    }
}
