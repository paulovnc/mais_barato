package br.com.maisbarato;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComparacaoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparacao_activity);
		Button botaoComparar = (Button) findViewById(R.id.buttonCalcular);
		botaoComparar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					EditText dados = (EditText) findViewById(R.id.precoCerveja1);
					float precoCerveja1 = Float.parseFloat(dados.getText().toString());
					dados = (EditText) findViewById(R.id.pesoCerveja1);
					
					float pesoCerveja1 = Float.parseFloat(dados.getText().toString());
					dados = (EditText) findViewById(R.id.precoCerveja2);
					float precoCerveja2 = Float.parseFloat(dados.getText().toString());
					dados = (EditText) findViewById(R.id.pesoCerveja2);
					float pesoCerveja2 = Float.parseFloat(dados.getText().toString());
					
					
					if(((int)pesoCerveja1 == 0) || ((int)pesoCerveja2 == 0) )
						throw new ArithmeticException();
					if( (precoCerveja1/pesoCerveja1) < (precoCerveja2/pesoCerveja2) )
						Toast.makeText(v.getContext(), "A primeira cerveja é a mais barata.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(v.getContext(), "A segunda cerveja é a mais barata.", Toast.LENGTH_LONG).show();
				}catch(NumberFormatException ex){
					Log.e("ComparacaoActivity", "Erro durante a conversão dos numeros " + ex.getMessage());
					Toast.makeText(v.getContext(), "Erro durante o cálculo. É preciso preencher todos os campos", Toast.LENGTH_SHORT).show();
				}catch(ArithmeticException ex){
					Log.e("ComparacaoActivity", "Divisão por zero! " + ex.getMessage());
					Toast.makeText(v.getContext(), "Os pesos não podem ser zero.", Toast.LENGTH_SHORT).show();
				}
			}
				
		});
	}
}
