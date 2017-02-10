package es.esy.vivekrajendran.myapp.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.esy.vivekrajendran.myapp.R;


public class Chooser extends Dialog {

    private Context context;

    public Chooser(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_chooser);
        Button ok = (Button) findViewById(R.id.btn_chooser_ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(context, "Selected", Toast.LENGTH_SHORT).show();
            }
        });

        Button cancel = (Button) findViewById(R.id.btn_chooser_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
