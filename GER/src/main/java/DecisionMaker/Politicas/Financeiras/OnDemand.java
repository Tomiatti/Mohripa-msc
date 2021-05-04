package DecisionMaker.Politicas.Financeiras;

public class OnDemand {

    public static void main(String[] args) {
        double creditoContratado, creditoMaximo, ValorMaq = 0, Creditogasto = 0, horagasta = 10;
        int periodoContratado, diaAtual,nMaq,TypeMaq;

       // Scanner scan = new Scanner(System.in);

       // System.out.println ("Digite valor contratado: ");
        creditoContratado =1000; // scan.nextInt();
       // System.out.println ("Digite valor maximo gasto por hora maquina: ");
        creditoMaximo = 2000; //scan.nextInt();
       // System.out.println("Digite o numero de maquinas: ");
        nMaq = 6 ; //scan.nextInt();
       // System.out.println("Informe tipo de maquina: 1 - small, 2 - medium 3 - large: ");
        TypeMaq =1; // scan.nextInt();

        double creditosGastos = CalculoCreditoGasto(Creditogasto, creditoContratado, creditoMaximo, nMaq, TypeMaq);
    }

    private static double CalculoCreditoGasto(double Creditogasto,double creditoContratado, double creditoMaximo, int nMaq, int TypeMaq) {
        double Horagasta= 10;
        double ValorMaq = 0;
        if(TypeMaq == 1){
            ValorMaq = 1.0;
        }
        if(TypeMaq == 2){
            ValorMaq = 2.0;
        }
        if(TypeMaq == 3){
            ValorMaq = 3.0;
        }

        if(Creditogasto >= creditoMaximo) {
            System.out.println ("Credito maximo alcançado" + Creditogasto );
        }

        Creditogasto=(Horagasta*ValorMaq)*nMaq;
        System.out.println ("Credito Gasto:" + Creditogasto );
        return 0;
    }
}
