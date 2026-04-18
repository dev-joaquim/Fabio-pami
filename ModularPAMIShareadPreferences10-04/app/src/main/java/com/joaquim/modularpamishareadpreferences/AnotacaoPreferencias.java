package com.joaquim.modularpamishareadpreferences;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import javax.xml.namespace.QName;

public class AnotacaoPreferencias {
    public final SharedPreferences preferences;
    public final SharedPreferences.Editor editor;

    public AnotacaoPreferencias(Context contexto){

        preferences = contexto.getSharedPreferences(QName:"arquivo_preferencias", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public void salvarAnotacao(){

    }
    public String recuperarAnotacao(){

    return  "";
        }

}
