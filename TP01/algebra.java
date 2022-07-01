class algebra {
           
    public static void main(String[] args) {
        String[] rep = new String[1000];
        int nE = 0;

        do {
            rep[nE] = MyIO.readLine();
        } while (vef(rep[nE++], "0") == false);
        nE--;

        for (int i = 0; i < nE; i = i + 1) {
            String fraseComEspaco = removeEspaco(rep[i]);
            int[] vE = goIn(fraseComEspaco);
            String frExp = expr(fraseComEspaco);
            MyIO.println(avaliacao(frExp, vE));
        }
    }
     

            public static String poeValores(String exp, int[] rep) {
                String valuefra = "";
                for (int i = 0; i < exp.length(); i = i + 1) {
                    int j = 0, boole = -1;
                    while (j < rep.length) {
                        if (exp.charAt(i) == ('A' + j)) {
                            boole = rep[j];
                        }
                        j = j + 1;
                    }
                    if (boole != -1) {
                        valuefra += boole;
                    } else {
                        valuefra += exp.charAt(i);
                    }
                }
                return valuefra;
            }
  
            public static String removeEspaco(String origem) {
                String fraseComEspaco = "";
                for (int i = 0; i < origem.length(); i = i + 1) {
                    if (origem.charAt(i) != ' ') {
                        fraseComEspaco += origem.charAt(i);
                    }
                }
                return fraseComEspaco;
            }


       
    

    public static String expr(String fraseComEspaco) {
        String noexpf = "";
        for (int i = 0; i < fraseComEspaco.length(); i = i + 1) {
            if (!(fraseComEspaco.charAt(i) >= '0' && fraseComEspaco.charAt(i) <= '9')) {
                noexpf += fraseComEspaco.charAt(i);
            }
        }
        return noexpf;
    }








    
    public static String expremoval(String fraseComEspaco, int ent) {
        String noexpf = "";
        for (int i = 1; i <= ent; i++) {
            noexpf += fraseComEspaco.charAt(i);
        }
        return noexpf;
    }

    public static String avaliacao(String exp, int[] rep) {
        exp = poeValores(exp, rep);
        exp = executaBoolean(exp);
        return exp;
    }

   
  






    public static String executaBoolean(String exp) {
        int iF, pI = 0;
        while (!vef(exp, "0") && !vef(exp, "1")) {
            iF= verificaFrase(exp, recepcao[pI]);
            if (iF != -1) {
                exp = trocaBoolean(exp, iF, pI);
            }
            if (pI < recepcao.length - 1) {
                pI++;
            } else {
                pI = 0;
            }
        }
        return exp;
    }








    public static int verificaFrase(String fR, String standard) {
        int ii = -1;
        if (standard.length() <= fR.length()) {
            int i = 0;
            while (ii == -1 && i < fR.length()) {
                if (fR.charAt(i) == standard.charAt(0)) {
                    if (verificaPadrao(fR, standard, i)) {
                        ii = i;
                    }
                }
                i = i  + 1;
            }
        }
        return ii;
    }











    public static String trocaBoolean(String exp, int idf, int iP) {
        String newexp = "";
        for (int i = 0; i < exp.length(); i++) {
            if (i == idf) {
                newexp += outToBox[iP];
                i = (idf + recepcao[iP].length() - 1);
            } else {
                newexp += exp.charAt(i);
            }
        }
        return newexp;
    }

    public static boolean verificaPadrao(String frr, String standard, int k) {
        boolean padrao = true;
        int h = 0;
        while (padrao && k < frr.length() && h < standard.length()) {
            if (frr.charAt(k) != standard.charAt(h)) {
                padrao = false;
            }
            k = k + 1;
            h = h + 1;
        }
        return padrao;
    }



    




    public static int[] goIn(String fraseComEspaco) {
        int ent = Character.getNumericValue(fraseComEspaco.charAt(0));
        int[] dados = new int[ent];
        String noexpf = expremoval(fraseComEspaco, ent);

        for (int i = 0; i < noexpf.length(); i = i + 1) {
            int boole = Character.getNumericValue(noexpf.charAt(i));
            if (boole == 0 || boole == 1) {
                dados[i] = boole;
            }
        }
        return dados;
    }

          
          public static boolean vef(String A, String B) {
            boolean equals = true;
            if (A.length() != B.length()) {
                equals = false;
            } else {
                int i = 0;
                while (i < A.length() && equals) {
                    if (A.charAt(i) != B.charAt(i)) {
                        equals = false;
                    }
                    i = i + 1;
                }
            }
            return equals;
        }
  





    
    static String[] recepcao = { "not(0)", "not(1)", "or(0,0)", "or(0,1)", "or(1,0)", "or(1,1)", "and(0,0)",
    "and(0,1)", "and(1,0)", "and(1,1)", "or(0,0,0)", "or(0,0,1)", "or(0,1,0)", "or(0,1,1)", "or(1,0,0)",
    "or(1,0,1)", "or(1,1,0)", "or(1,1,1)", "and(0,0,0)", "and(0,0,1)", "and(0,1,0)", "and(0,1,1)", "and(1,0,0)",
    "and(1,0,1)", "and(1,1,0)", "and(1,1,1)", "or(0,0,0,0)", "or(0,0,0,1)", "or(0,0,1,0)", "or(0,0,1,1)",
    "or(0,1,0,0)", "or(0,1,0,1)", "or(0,1,1,0)", "or(0,1,1,1)", "or(1,0,0,0)", "or(1,0,0,1)", "or(1,0,1,0)",
    "or(1,0,1,1)", "or(1,1,0,0)", "or(1,1,0,1)", "or(1,1,1,0)", "or(1,1,1,1)", "and(0,0,0,0)", "and(0,0,0,1)",
    "and(0,0,1,0)", "and(0,0,1,1)", "and(0,1,0,0)", "and(0,1,0,1)", "and(0,1,1,0)", "and(0,1,1,1)",
    "and(1,0,0,0)", "and(1,0,0,1)", "and(1,0,1,0)", "and(1,0,1,1)", "and(1,1,0,0)", "and(1,1,0,1)",
    "and(1,1,1,0)", "and(1,1,1,1)" };







    static String[] outToBox = { "1", "0", "0", "1", "1", "1", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1",
    "0", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
    "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" };





}