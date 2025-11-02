import java.util.Scanner;
public class MainClass{ 
 public static void main(String args[]){
   Scanner _key = new Scanner(System.in);
String  msg;
double  i;
double  limite;
msg = "Iniciando teste do laco PARA.";
System.out.println(msg);
limite = 5;
for (i = 0; i<limite; i = i+1) {
	msg = "Valor de i:";
	System.out.println(msg);
	System.out.println(i);
}

msg = "Fim do laco.";
System.out.println(msg);
 }}