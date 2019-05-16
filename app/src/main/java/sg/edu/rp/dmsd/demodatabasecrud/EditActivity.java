package sg.edu.rp.dmsd.demodatabasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView tvID;
    EditText etContent2;
    Button btnUpdate,btnDelete;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        tvID = findViewById(R.id.tvID);
        etContent2 = findViewById(R.id.etContent2);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etContent2.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(etContent2.getText().toString());
                dbh.updateNote(data);
                dbh.close();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                dbh.close();
            }
        });
    }

}
