package br.com.maisbarato;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.TextView;

public class SpinnerItemSelectedCervejaLataListener implements OnItemSelectedListener {
	private EditText pesoEspecifico;
	private TextView textView;
	public SpinnerItemSelectedCervejaLataListener(EditText peso , TextView textView){
		super();
		this.pesoEspecifico = peso;
		this.textView = textView;
	}
	/*
	pesoCerveja1 = 250.0f;
	break;
case R.id.radioBut350:
	pesoCerveja1 = 350.0f;
	break;
case R.id.radioBut500:
	pesoCerveja1 = 473.0f;
	break;*/
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		//Toast.makeText(arg0.getContext(),
		//		"item selecionado foi: "+arg0.getItemAtPosition(arg2).toString(),
		//		Toast.LENGTH_LONG).show();
		switch(arg2){
			case 0:
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 1:
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 2:
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 3:
				pesoEspecifico.setVisibility(EditText.VISIBLE);
				textView.setVisibility(TextView.VISIBLE);
				break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
