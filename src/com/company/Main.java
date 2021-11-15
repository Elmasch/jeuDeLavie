package com.company;

public class Main {

    public static void affiche(boolean[][] matrice){
        for(int i = 0; i< 10; i++){
            for(int j =0; j < 10; j++){
                if(matrice[i][j] == true){
                    System.out.print('1');
                    System.out.print(' ');
                }
                else{
                    System.out.print('0');
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int nbVoisin (boolean[][] matrice, int i, int j){
        int nbvoisin = 0;

        for(int k = i -1; k <= i +1; k++){
            for(int l = j -1; l <= j +1 ; l++){
                if(( k  >=0 && k <10) && (l >=0 && l <10)){
                    if(matrice[k][l] == true){
                        ++nbvoisin;
                    }
                }
            }
        }

        if (matrice[i][j] == true) {
            nbvoisin--;
        }
        return nbvoisin;
    }

    public static boolean[][] condition(boolean[][] matrice){
        boolean[][] Buffer = new boolean[10][10];
        int nbvoi =0;

        for(int i = 0; i< matrice.length;i++){
            System.arraycopy(matrice[i],0,Buffer[i],0,matrice[i].length);
        }

        for(int i = 0; i< 10; i++){
            for(int j =0; j < 10; j++){
                nbvoi = nbVoisin(matrice,i,j);
                if(nbvoi == 3){
                    Buffer[i][j] = true;
                }
                else if (nbvoi < 2 || nbvoi > 3 ){
                    Buffer[i][j] = false;
                }
            }
        }
        return Buffer;
    }

    public static void main(String[] args) throws InterruptedException {
        boolean[][] matrice = new boolean[10][10];

        for(int i = 0; i< 10; i++){
            for(int j =0; j < 10; j++){
                matrice[i][j] = false;
            }
        }
        for(int i = 0; i < 50; i++){
            int x = (int)(0 + (Math.random() * ( 10 - 0)));
            int y = (int)(0 + (Math.random() * ( 10 - 0)));
            matrice[x][y] = true;
        }

        affiche(matrice);

        while(true){
            matrice = condition(matrice);
            affiche(matrice);
            Thread.sleep(1000);
        }
    }
}
