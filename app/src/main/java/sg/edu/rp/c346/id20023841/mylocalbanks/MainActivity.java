package sg.edu.rp.c346.id20023841.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOCBC, tvDBS, tvUOB;
    String wordClicked;
    Boolean blocbc,bldbs,bluob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        blocbc = true;
        bldbs = true;
        bluob = true;

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1+800+111+1111));
                startActivity(intentContact);
                return true;
            } else if (item.getItemId() == 2){
                if(bldbs == true){
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                    bldbs = false;
                } else if (bldbs == false){
                    tvDBS.setTextColor(Color.parseColor("#808080"));
                    bldbs = true;
                }
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1+800+363+3333));
                startActivity(intentContact);
                return true;
            } else if (item.getItemId() == 2){
                if(blocbc == true){
                    tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                    blocbc = false;
                } else if (blocbc == false){
                    tvOCBC.setTextColor(Color.parseColor("#808080"));
                    blocbc = true;
                }
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1+800+222+2121));
                startActivity(intentContact);
                return true;
            } else if (item.getItemId() == 2){
                if(bluob == true){
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                    bluob = false;
                } else if (bluob == false){
                    tvUOB.setTextColor(Color.parseColor("#808080"));
                    bluob = true;
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.EnglishSelection){
            tvUOB.setText("UOB");
            tvOCBC.setText("OCBC");
            tvDBS.setText("DBS");
            return true;
        }else if(id == R.id.ChineseSelection){
            tvUOB.setText("大华银行");
            tvOCBC.setText("华侨银行");
            tvDBS.setText("星展银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
