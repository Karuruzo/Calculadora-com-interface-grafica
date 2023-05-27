public class calculadora2 {
    private static double ANS;
    public static int soma(double A, double B){
        //TODO FUNÇÃO SOMA
        ANS=A+B;
        System.out.println("soma="+(A+B));
        return 0;
    }
    public static int subtracao(double A, double B){
        //TODO FUNÇÃO SUBTRAÇÃO
        ANS=A-B;
        System.out.println("subtração="+(A-B));
        return 0;
    }
    public static int multiplicacao(double A, double B){
        //TODO FUNÇÃO MULTIPLICAÇÃO
        ANS=A*B;
        System.out.println("multiplicação="+(A*B));
        return 0;
    }
    public static double divisao(double A, double B){
        //TODO FUNÇÃO DIVISÃO
        ANS=A/B;
        System.out.println("divisão="+(A/B));
        return A;
    }
    public static void bhaskara(double A, double B, double C){
        //TODO FUNÇÃO BHASKARA
        double delta, x1,x2;
        delta=(Math.pow(B,2))-(4*A*C);
        x1=(-B+(Math.sqrt(delta)))/(2*A);
        x2=(-B-(Math.sqrt(delta)))/(2*A);
        if (delta <=0){
            System.out.println("delta menor que zero");
            System.out.println(delta);
        }
        else{
            System.out.println("x1="+(x1));
            System.out.println("x2="+(x2));
        }
    }
    public static double raiz(double radicando, double indice){
        //TODO FUNÇÃO RAIZ
        ANS=Math.pow(radicando,1/indice);
        System.out.println("raiz="+(Math.pow(radicando,1/indice)));
        return radicando;
    }
    public static double potencia(double base, double expoente){
        //TODO FUNÇÃO POTENCIA
        ANS=Math.pow(base, expoente);
        System.out.println("potencia="+(Math.pow(base, expoente)));
        return base;
    }
    public double getANS() {
        return ANS;
    }
}