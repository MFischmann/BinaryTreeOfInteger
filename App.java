
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
        /*
        System.out.println(arv.strPositionsCentral());
        System.out.println(arv.level(10));
        System.out.println(arv.level(12));
        System.out.println(arv.level(5));
        System.out.println(arv.level(11));
        */
        /* //Testes para metodo height
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addRight(3, 7));
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addLeft(8, 17));
        System.out.println("Altura arv: " + arv.height());
        System.out.println(arv.addLeft(70, 8));
        System.out.println("Altura arv: " + arv.height());
        */

        //System.out.println("Elemento 5 e externo? "+arv.isExternal(5));
        //System.out.println("Elemento 12 e externo? "+arv.isExternal(12));
        //System.out.println("Elemento 5 e interno? "+arv.isInternal(5));
        //System.out.println("Elemento 12 e interno? "+arv.isInternal(12));
        /*
        System.out.println("Elemento 5 tem filho esq? "+arv.hasLeft(5));
        System.out.println("Elemento 12 tem filho esq? "+arv.hasLeft(12));
        arv.addLeft(11, 12);
        System.out.println("Elemento 12 tem filho esq? "+arv.hasLeft(12));*/
        /*
        System.out.println("Elemento 5 tem filho dir? "+arv.hasRight(5));
        System.out.println("Elemento 12 tem filho dir? "+arv.hasRight(12));
        arv.addRight(11, 12);
        System.out.println("Elemento 12 tem filho dir? "+arv.hasRight(12));*/
        /*
        System.out.println("Qual filho a esq do elemento 5? "+arv.getLeft(5));
        System.out.println("Qual filho a esq do elemento 12? "+arv.getLeft(12));
        arv.addLeft(11, 12);
        System.out.println("Qual filho a esq do elemento 12? "+arv.getLeft(12));
        */
        /*
        System.out.println("Qual filho a dir do elemento 5? "+arv.getRight(5));
        System.out.println("Qual filho a dir do elemento 12? "+arv.getRight(12));
        arv.addRight(11, 12);
        System.out.println("Qual filho a dir do elemento 12? "+arv.getRight(12));
        */
        //System.out.println("Qual pai do elemento 5? "+arv.getParent(5));
        //System.out.println("Qual pai do elemento 12? "+arv.getParent(12));
        //System.out.println("Qual pai do elemento 10? "+arv.getParent(10));
        /*
        System.out.println("Num folhas: "+arv.countLeaves());
        arv.addLeft(11, 12);
        System.out.println("Num folhas: "+arv.countLeaves());
        arv.addRight(13, 12);
        System.out.println("Num folhas: "+arv.countLeaves());
        */
        System.out.println("Num galhos: "+arv.countBranches());
        arv.addLeft(11, 12);
        System.out.println("Num galhos: "+arv.countBranches());
        arv.addRight(13, 12);
        System.out.println("Num galhos: "+arv.countBranches());
    }
    
}
