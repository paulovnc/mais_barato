package br.com.maisbarato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		ImageButton botaoLataCerveja = (ImageButton) findViewById(R.id.imagemLataCerveja);
		botaoLataCerveja.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent("br.com.maisbarato.COMPARAR");
				it.addCategory("br.com.maisbarato.AVALIACAO");
				startActivity(it);
			}
		});
		
		ImageButton botaoGarrafaCerveja = (ImageButton) findViewById(R.id.imagemGarrafaCerveja);
		botaoGarrafaCerveja.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent("br.com.maisbarato.COMPARAR_GARRAFA");
				it.addCategory("br.com.maisbarato.AVALIACAO");
				startActivity(it);
			}
		});
	}
}
