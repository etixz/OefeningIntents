package eb.egonb.oefeningintents;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button callButton, mapButton;
    private TextView tvName;
    private Gebruiker gebruiker = new Gebruiker("Jos",
            "04ziedevanier",
            "https://www.google.com/search?rlz=1C1GCEA_enBE875BE875&ei=u6lGXpHGIYWP8gLXjYOoDg&q=joske&oq=joske&gs_l=psy-ab.3..0i71l8.0.0..1059447...0.2..0.0.0.......0......gws-wiz.XlNK4bgrMWE&ved=0ahUKEwjRj6jbm9HnAhWFh1wKHdfGAOUQ4dUDCAs&uact=5",
            "35.652832,139.839478?z=5");;

    private View.OnClickListener callListener = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            Uri callUri = Uri.parse("tel:" + gebruiker.getTelefoonNr());
            Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    askPermission();
                    return;
                }
            }
            startActivity(callIntent);
        }
    };

    private View.OnClickListener mapListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            Uri adresUri = Uri.parse("geo:" + gebruiker.getAdres());
            mapIntent.setData(adresUri);
            if(mapIntent.resolveActivity(getPackageManager()) != null){
                startActivity(mapIntent);
            }
        }
    };

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
    }

    public void openWebsite(View v){
        Uri webUri = Uri.parse(gebruiker.getWebsite());
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(webIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapButton = findViewById(R.id.btn_map);
        callButton = findViewById(R.id.btn_call);
        tvName = findViewById(R.id.tv_name);

        mapButton.setOnClickListener(mapListener);
        callButton.setOnClickListener(callListener);
        tvName.setText(gebruiker.getNaam());
    }
}
