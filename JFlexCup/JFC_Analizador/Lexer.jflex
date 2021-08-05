package analizadores;
import java_cup.runtime.*; 
import analizadores.sym.*;
import java.util.List;
import java.util.ArrayList;
import objetos.ErrorCom;

%%

//Configuracion JFLEX
%public
%class Lexer
%standalone
%line
%column
%cup

//Expresiones Regulares



blancos = [ \r\t\b\f\n]+
letra = [a-zA-Z]
numero = [0-9] [0-9]*
identificador = {letra} ({letra}|{numero})*


//Codigo Incrustado
%{
    private List<ErrorCom> erroresCom;

    private void error(String lexeme) {
        erroresCom.add(new ErrorCom("Lexico","Simbolo no existe en el lenguaje",String.valueOf(yyline+1),String.valueOf(yycolumn+1),lexeme));
    }    

    private void errorPrueba(String lexeme, String tipo) {
        erroresCom.add(new ErrorCom("PRUEBA",tipo,String.valueOf(yyline+1),String.valueOf(yycolumn+1),lexeme));
    }

    public List<ErrorCom> getErroresCom() {
        return erroresCom;
    }


%}

%init{
    erroresCom = new ArrayList<>();
%init}

%%


//Reglas Lexicas
<YYINITIAL> {
 
    "+" {return new Symbol(sym.SUMA,yyline+1,yycolumn+1, yytext());} 
    "*" {return new Symbol(sym.MULT,yyline+1,yycolumn+1, yytext());}     
    "(" {return new Symbol(sym.PARI,yyline+1,yycolumn+1, yytext());}
    ")" {return new Symbol(sym.PARD,yyline+1,yycolumn+1, yytext());}
    {numero} {return new Symbol(sym.NUM,yyline+1,yycolumn+1, yytext());}
    {identificador} {return new Symbol(sym.IDENT,yyline+1,yycolumn+1, yytext());}

    {blancos} {}


    

}

/* Error por cualquier otro simbolo*/
[^]
		{ error(yytext()); new Symbol(sym.error,yyline,yycolumn, yytext());}
