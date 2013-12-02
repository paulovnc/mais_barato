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

public class ComparacaoCervejaLata extends Activity {
	private Spinner pesosLata1;
	private Spinner pesosLata2;
	private EditText pesoDistintoLata1;
	private EditText pesoDistintoLata2;
	private TextView textViewPesoEspecifico1;
	private TextView textViewPesoEspecifico2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparacao_lata_cerveja);
		
		//configurações iniciais da tela
		textViewPesoEspecifico1 = (TextView) findViewById(R.id.textViewPesoEspecifico1);
		textViewPesoEspecifico2 = (TextView) findViewById(R.id.TextViewPesoEspecifico2);
		textViewPesoEspecifico1.setVisibility(TextView.INVISIBLE);
		textViewPesoEspecifico2.setVisibility(TextView.INVISIBLE);
		
		pesoDistintoLata1 = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja1);
		pesoDistintoLata2 = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja2);
		pesoDistintoLata1.setVisibility(TextView.INVISIBLE);
		pesoDistintoLata2.setVisibility(TextView.INVISIBLE);

		//configuracao dos Spinners
		pesosLata1 = (Spinner) findViewById(R.id.spinnerPesosLata1);
		pesosLata2 = (Spinner) findViewById(R.id.spinnerPesosLata2);

		//Opções do Spinner
		List<String> pesos = new ArrayList<String>();
		pesos.add(getResources().getString(R.string.comparacao_peso_250));
		pesos.add(getResources().getString(R.string.comparacao_peso_350));
		pesos.add(getResources().getString(R.string.comparacao_peso_473));
		pesos.add(getResources().getString(R.string.comparacao_peso_outro_valor));

		//Definindo o adapter
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pesos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		//Configurando Spinners
		pesosLata1.setAdapter(adaptador);
		pesosLata1.setOnItemSelectedListener(new SpinnerItemSelectedCervejaLataListener(pesoDistintoLata1, textViewPesoEspecifico1));

		pesosLata2.setAdapter(adaptador);
		pesosLata2.setOnItemSelectedListener(new SpinnerItemSelectedCervejaLataListener(pesoDistintoLata2,textViewPesoEspecifico2));


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
					escolha = pesosLata1.getSelectedItemPosition();
					switch(escolha){
						case 0:
							pesoCerveja1 = 250.0f;
							break;
						case 1:
							pesoCerveja1 = 350.0f;
							break;
						case 2:
							pesoCerveja1 = 473.0f;
							break;
						case 3:
							dados = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja1);
							pesoCerveja1 = Float.parseFloat(dados.getText().toString());
							break;
					}

					//tratando do peso e preco da segunda cerveja
					dados = (EditText) findViewById(R.id.precoCerveja2);
					precoCerveja2 = Float.parseFloat(dados.getText().toString());
					escolha = pesosLata2.getSelectedItemPosition();
					switch(escolha){
						case 0:
							pesoCerveja2 = 250.0f;
							break;
						case 1:
							pesoCerveja2 = 350.0f;
							break;
						case 2:
							pesoCerveja2 = 473.0f;
							break;
						case 3:
							dados = (EditText) findViewById(R.id.editTextPesoEspecificoCerveja2);
							pesoCerveja2 = Float.parseFloat(dados.getText().toString());
							break;
					}

					if(( Math.round(pesoCerveja1) == 0) || (Math.round(pesoCerveja2) == 0) )
						throw new ArithmeticException();
					float cerveja1 = precoCerveja1/pesoCerveja1;
					float cerveja2 = precoCerveja2/pesoCerveja2;
					if( (cerveja1) < (cerveja2) )
						Toast.makeText(v.getContext(), "A primeira cerveja é a mais barata. "+cerveja1+" "+cerveja2, Toast.LENGTH_LONG).show();
					else
						Toast.makeText(v.getContext(), "A segunda cerveja é a mais barata. "+cerveja1+" "+cerveja2, Toast.LENGTH_LONG).show();
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
