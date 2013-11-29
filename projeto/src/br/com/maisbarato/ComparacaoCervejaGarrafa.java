package br.com.maisbarato;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ComparacaoCervejaGarrafa extends Activity {
	private Spinner pesosGarrafa1;
	private Spinner pesosGarrafa2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparacao_garrava_cerveja_activity);
		pesosGarrafa1 = (Spinner) findViewById(R.id.pesosGarrafa1);
		//valores a serem adicionados no primeiro spinner
		List<String> pesos = new ArrayList<String>();
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_275));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_350));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_355));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_500));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_600));
		pesos.add(getResources().getString(R.string.comparacao_garrafa_peso_1000));
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pesos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		pesosGarrafa1.setAdapter(adaptador);
		pesosGarrafa1.setOnItemSelectedListener(new SpinnerItemSelectedListener());
		
		//valores a serem adicionados no segundo spinner
		pesosGarrafa2 = (Spinner) findViewById(R.id.pesosGarrafa2);
		pesosGarrafa2.setAdapter(adaptador);
		pesosGarrafa2.setOnItemSelectedListener(new SpinnerItemSelectedListener());
	}
}
