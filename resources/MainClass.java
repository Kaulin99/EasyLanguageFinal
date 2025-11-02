import java.util.Scanner;
public class MainClass{ 
 public static void main(String args[]){
   Scanner _key = new Scanner(System.in);
String msg;
double a;
boolean flag;
a = 100;
flag = true;
msg = "Teste Booleano:";
System.out.println(msg);
if (flag==true) {
	msg = "Flag eh verdadeira!";
	System.out.println(msg);
	flag = false;

}

if (flag==false) {
	msg = "Flag agora eh falsa!";
	System.out.println(msg);

}

 }}