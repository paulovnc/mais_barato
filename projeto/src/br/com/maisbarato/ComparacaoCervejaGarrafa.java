package br.com.maisbarato;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ComparacaoCervejaGarrafa extends Activity {
	private Spinner pesosGarrafa1;
	private Spinner pesosGarrafa2;
	private EditText pesoDistintoGarrafa1;
	private EditText pesoDistintoGarrafa2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparacao_garrava_cerveja_activity);
		//pesos distintos só funcionam quando escolhidos
		pesoDistintoGarrafa1 = (EditText)findViewById(R.id.pesoDistintoGarrafa1);
		pesoDistintoGarrafa1.setVisibility(EditText.INVISIBLE);
		TextView textViewPesoDistintoGarrafa1 = (TextView) findViewById(R.id.textViewPesoEspecificoGarrafa1);
		textViewPesoDistintoGarrafa1.setVisibility(TextView.INVISIBLE);
		pesoDistintoGarrafa2 = (EditText)findViewById(R.id.pesoDistintoGarrafa2);
		pesoDistintoGarrafa2.setVisibility(EditText.INVISIBLE);
		TextView textViewPesoDistintoGarrafa2 = (TextView) findViewById(R.id.textViewPesoEspecificoGarrafa2);
		textViewPesoDistintoGarrafa2.setVisibility(TextView.INVISIBLE);
		
		//Tratando dos Spinners agora
		pesosGarrafa1 = (Spinner) findViewById(R.id.pesosGarrafa1);
		//valores a serem adicionados no primeiro spinner
		List<String> pesos = new ArrayList<String>();
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_275));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_350));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_355));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_500));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_600));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_1000));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_distinto));
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pesos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		pesosGarrafa1.setAdapter(adaptador);
		pesosGarrafa1.setOnItemSelectedListener(new SpinnerItemSelectedListener(pesoDistintoGarrafa1,textViewPesoDistintoGarrafa1));
		pesosGarrafa1.setSelection(0);//peso inicial
		
		//valores a serem adicionados no segundo spinner
		pesosGarrafa2 = (Spinner) findViewById(R.id.pesosGarrafa2);
		pesosGarrafa2.setAdapter(adaptador);
		pesosGarrafa2.setOnItemSelectedListener(new SpinnerItemSelectedListener(pesoDistintoGarrafa2,textViewPesoDistintoGarrafa2));
		pesosGarrafa2.setSelection(0);//peso inicial
		
		//botão comparar
		Button buttonComparar = (Button) findViewById(R.id.buttonCompararGarrafas);
		buttonComparar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					float precoCerveja1 = 0.0f;
					float pesoCerveja1 = 0.0f;
					float precoCerveja2 = 0.0f;
					float pesoCerveja2 = 0.0f;
					int escolha = 0;
					
					//tratando do peso e preco da primeira cerveja
					EditText dados = (EditText) findViewById(R.id.precoGarrafa1);
					precoCerveja1 = Float.parseFloat(dados.getText().toString());
					escolha = pesosGarrafa1.getSelectedItemPosition();
					/*
					 pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_275));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_350));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_355));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_500));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_600));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_1000));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_distinto));
					 * */
					switch(escolha){
						case 0:
							pesoCerveja1 = 275.0f;
							break;
						case 1:
							pesoCerveja1 = 350.0f;
							break;
						case 2:
							pesoCerveja1 = 355.0f;
							break;
						case 3:
							pesoCerveja1 = 500.0f;
							break;
						case 4:
							pesoCerveja1 = 600.0f;
							break;
						case 5:
							pesoCerveja1 = 1000.0f;
							break;
						case 6:
							dados = pesoDistintoGarrafa1;
							pesoCerveja1 = Float.parseFloat(dados.getText().toString());
							break;
					}
					
					//tratando do peso e preco da segunda cerveja
					dados = (EditText) findViewById(R.id.precoGarrafa2);
					precoCerveja2 = Float.parseFloat(dados.getText().toString());
					escolha = pesosGarrafa2.getSelectedItemPosition();
					switch(escolha){
						case 0:
							pesoCerveja2 = 275.0f;
							break;
						case 1:
							pesoCerveja2 = 350.0f;
							break;
						case 2:
							pesoCerveja2 = 355.0f;
							break;
						case 3:
							pesoCerveja2 = 500.0f;
							break;
						case 4:
							pesoCerveja2 = 600.0f;
							break;
						case 5:
							pesoCerveja2 = 1000.0f;
							break;
						case 6:
							dados = pesoDistintoGarrafa2;
							pesoCerveja2 = Float.parseFloat(dados.getText().toString());
							break;
					}
					Toast.makeText(v.getContext(), "peso1 " + pesoCerveja1 +" " + "peso2 " + pesoCerveja2 , Toast.LENGTH_SHORT).show();
					if(( Math.round(pesoCerveja1) == 0.0) || (Math.round(pesoCerveja2) == 0.0) )
						throw new ArithmeticException();
					float cerveja1 = precoCerveja1/pesoCerveja1;
					float cerveja2 = precoCerveja2/pesoCerveja2;
					if( (cerveja1) < (cerveja2) )
						Toast.makeText(v.getContext(), "A primeira cerveja é a mais barata. "+cerveja1+" "+cerveja2, Toast.LENGTH_LONG).show();
					else
						Toast.makeText(v.getContext(), "A segunda cerveja é a mais barata. "+cerveja1+" "+cerveja2, Toast.LENGTH_LONG).show();
				}catch(NumberFormatException ex){
					Log.e("ComparacaoCervejaGarrafa", "Erro durante a conversão dos numeros " + ex.getMessage());
					Toast.makeText(v.getContext(), "Erro durante o cálculo. É preciso preencher todos os campos", Toast.LENGTH_SHORT).show();
				}catch(ArithmeticException ex){
					Log.e("ComparacaoCervejaGarrafa", "Divisão por zero! " + ex.getMessage());
					Toast.makeText(v.getContext(), "Os pesos não podem ser zero.", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}