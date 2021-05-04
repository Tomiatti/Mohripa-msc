package Webservice.Politicas.Financeiras;

public class ROI {

    public static void main(String[] args) {
        double creditosGastos = CalculoCreditoGasto(2000, 30, 20, 100, 50);
        System.out.println("Gasto :"+creditosGastos);
    }

    double creditoContratado;
    int periodoContratado, diaAtual;
    double previsaoDemanda, valorObservadoDemanda;

    public static double CalculoCreditoGasto(double creditoContratado, int periodoContratado, int diaAtual, double previsaoDemanda, double valorObservadoDemanda)
    {
        //ROI policy
        double creditoGasto;
        double valorCreditoPorDia;
        valorCreditoPorDia = creditoContratado/(periodoContratado-diaAtual);
        System.out.println("XCredito dia "+valorCreditoPorDia);
        creditoGasto = (valorCreditoPorDia*valorObservadoDemanda)/previsaoDemanda;

        return creditoGasto;
    }

}
