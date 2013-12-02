package br.com.maisbarato;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.TextView;

public class SpinnerItemSelectedCervejaGarrafaListener implements OnItemSelectedListener {
	private EditText pesoEspecifico;
	private TextView textView;
	public SpinnerItemSelectedCervejaGarrafaListener(EditText peso , TextView textView){
		super();
		this.pesoEspecifico = peso;
		this.textView = textView;
	}
	
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
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 4:
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 5:
				pesoEspecifico.setVisibility(EditText.INVISIBLE);
				textView.setVisibility(TextView.INVISIBLE);
				break;
			case 6:
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
