package br.com.maisbarato;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ComparacaoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparacao_activity);
		//configurando eventos radiobutton da cerveja 1
		RadioButton botaoOutroPrecoCerveja1 = (RadioButton) findViewById(R.id.radioButOutro1);
		botaoOutroPrecoCerveja1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText edtOutroPeso = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja1);
				edtOutroPeso.setVisibility(EditText.VISIBLE);
			}
		});
		//configurando evendo radiobutton da cerveja 2
		RadioButton botaoOutroPrecoCerveja2 = (RadioButton) findViewById(R.id.radioButOutro2);
		RadioGroup group2 = (RadioGroup) findViewById(R.id.radioGroupPesoCerveja1);
		
		botaoOutroPrecoCerveja2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText edtOutroPeso = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja2);
				edtOutroPeso.setVisibility(EditText.VISIBLE);
			}
		});
		
		Button botaoComparar = (Button) findViewById(R.id.buttonCalcular);
		botaoComparar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					float precoCerveja1 = 0.0f;
					float pesoCerveja1 = 0.0f;
					float precoCerveja2 = 0.0f;
					float pesoCerveja2 = 0.0f;
					int escolha = 0;
					
					//tratando do peso e preco da primeira cerveja
					EditText dados = (EditText) findViewById(R.id.precoCerveja1);
					precoCerveja1 = Float.parseFloat(dados.getText().toString());
					RadioGroup pesosCerveja1 = (RadioGroup) findViewById(R.id.radioGroupPesoCerveja1);
					escolha = pesosCerveja1.getCheckedRadioButtonId();
					switch(escolha){
						case R.id.radioBut250:
							pesoCerveja1 = 250.0f;
							break;
						case R.id.radioBut350:
							pesoCerveja1 = 350.0f;
							break;
						case R.id.radioBut500:
							pesoCerveja1 = 473.0f;
							break;
						case R.id.radioButOutro1:
							dados = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja1);
							pesoCerveja1 = Float.parseFloat(dados.getText().toString());
							break;
					}
					
					//tratando do peso e preco da segunda cerveja
					dados = (EditText) findViewById(R.id.precoCerveja2);
					precoCerveja2 = Float.parseFloat(dados.getText().toString());
					RadioGroup pesosCerveja2 = (RadioGroup) findViewById(R.id.radioGroupPesoCerveja2);
					escolha = pesosCerveja2.getCheckedRadioButtonId();
					switch(escolha){
						case R.id.radioButSeg250:
							pesoCerveja2 = 250.0f;
							break;
						case R.id.radioButSeg350:
							pesoCerveja2 = 350.0f;
							break;
						case R.id.radioButSeg473:
							pesoCerveja2 = 473.0f;
							break;
						case R.id.radioButOutro2:
							dados = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja1);
							pesoCerveja2 = Float.parseFloat(dados.getText().toString());
							break;
					}
					
					if(( Math.round(pesoCerveja1) == 0) || (Math.round(pesoCerveja2) == 0) )
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
