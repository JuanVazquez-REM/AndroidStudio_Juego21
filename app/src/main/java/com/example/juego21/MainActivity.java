package com.example.juego21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    TextView total,solo;
    Button addCarta;
    Integer puntos=0;
    LinearLayout layout1;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.addCarta).setOnClickListener(this);
        layout1 = findViewById(R.id.layout1);

       /* addCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.cuatro_c);
                addView(imageView,0,LinearLayout.LayoutParams.MATCH_PARENT);

            }
        });*/

       queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.addCarta:

                String url = "https://ramiro174.com/api/numero";

                JsonObjectRequest obtenerNumero = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            solo = findViewById(R.id.text_puntos);
                            total = findViewById(R.id.text_total);
                            ImageView imageView = new ImageView(MainActivity.this);
                            Integer numero = response.getInt("numero");

                            switch (numero){
                                case 1: imageView.setImageResource(R.drawable.uno_c); break;
                                case 2: imageView.setImageResource(R.drawable.dos_c); break;
                                case 3: imageView.setImageResource(R.drawable.tres_c); break;
                                case 4: imageView.setImageResource(R.drawable.cuatro_c); break;
                                case 5: imageView.setImageResource(R.drawable.cinco_c); break;
                                case 6: imageView.setImageResource(R.drawable.seis_c); break;
                                case 7: imageView.setImageResource(R.drawable.siete_c); break;
                                case 8: imageView.setImageResource(R.drawable.ocho_c); break;
                                case 9: imageView.setImageResource(R.drawable.nueve_c); break;
                                case 10: imageView.setImageResource(R.drawable.diez_c); break;
                                case 11: imageView.setImageResource(R.drawable.once_c); break;
                                case 12: imageView.setImageResource(R.drawable.doce_c); break;
                                case 13: imageView.setImageResource(R.drawable.trese_c); break;
                            }
                            puntos += numero;
                            addView(imageView,0,LinearLayout.LayoutParams.MATCH_PARENT);
                            total.setText(puntos.toString());

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(obtenerNumero);
                break;
            case 2:
                break;
        }
    }

    public void addView(ImageView imageView, int width, int height){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height,1);
        layoutParams.setMargins(0,10,0,10);

        imageView.setLayoutParams(layoutParams);
        layout1.addView(imageView);
    }
}