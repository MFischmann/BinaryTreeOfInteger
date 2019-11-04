
public class App {
    public static void main(String[] args) {
        BinaryTreeOfInteger arv = new BinaryTreeOfInteger();
        arv.addRoot(10);
        arv.addLeft(5, 10);
        arv.addRight(15, 10); 
        arv.addLeft(2,5);
        arv.addRight(7,5);   
        arv.addLeft(12,15);
        arv.addRight(17,15); 


        //System.out.println(arv.contains(10));
        //System.out.println(arv.contains(2));
        //System.out.println(arv.contains(17));
        //arv.testaCountNodes();
        //System.out.println(arv.strPositionsCentral());
        //System.out.println(arv.positionsPre());
        //System.out.println(arv.positionsPos());
        //System.out.println(arv.positionsCentral());
        //System.out.println(arv.positionsWidth());

        /* //Teste removeBranch
        System.out.println("Arveore antes remocao \n" + arv.positionsPre());
        System.out.println("Numero nodos: " + arv.size());
        System.out.println("Remocao 5: " + arv.removeBranch(5));
        System.out.println("Arveore apos remocao 5:\n" + arv.positionsPre());
        System.out.println("Numero nodos: " + arv.size());
        System.out.println("Remocao 3: " + arv.removeBranch(3));
        System.out.println("Arveore apos remocao 3:\n" + arv.positionsPre());
        System.out.println("Numero nodos: " + arv.size());
        System.out.println("Remocao 12: " + arv.removeBranch(12));
        System.out.println("Arveore apos remocao 12:\n" + arv.positionsPre());
        System.out.println("Numero nodos: " + arv.size());
        */

        //System.out.println(arv.strPositionsCentral());
        //System.out.println(arv.level(10));
        //System.out.println(arv.level(12));
        //System.out.println(arv.level(5));
        //System.out.println(arv.level(11));

         //Testes para metodo height
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addRight(3, 7));
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addLeft(8, 17));
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addLeft(70, 8));
        System.out.println("Altura arv: " + arv.height());
        
    }
    
}
