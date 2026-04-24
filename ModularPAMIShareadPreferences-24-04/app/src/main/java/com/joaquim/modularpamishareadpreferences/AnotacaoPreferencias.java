package com.joaquim.modularpamishareadpreferences;
import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {
    public final SharedPreferences preferences;
    public final SharedPreferences.Editor editor;

    public static String chave = "anotacao";

    public AnotacaoPreferencias(Context contexto){

        preferences = contexto.getSharedPreferences("arquivo_preferencias", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public void salvarAnotacao(String anotacao){
        editor.putString(chave,anotacao);
        editor.commit();

    }
    public String recuperarAnotacao(){
        return preferences.getString(chave,"");


        }

}
