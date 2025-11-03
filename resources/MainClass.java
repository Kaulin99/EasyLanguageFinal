import java.util.Scanner;
public class MainClass{ 
 public static void main(String args[]){
   Scanner _key = new Scanner(System.in);
String msg;
double a;
double[] vet;
double i;

  // Inicializando vetores
  vet = new double[5];

a = 10;
i = 0;
vet[0] = a;
vet[1] = 20;
vet[i] = 30;
msg = "Digite um numero para o vetor[3]:";
System.out.println(msg);
vet[3] = _key.nextDouble();

msg = "O valor de vetor[1] eh:";
System.out.println(msg);
System.out.println(vet[1]);
if (vet[0]<vet[1]) {
	msg = "vetor[0] eh menor que vetor[1]";
	System.out.println(msg);

}

 }
}