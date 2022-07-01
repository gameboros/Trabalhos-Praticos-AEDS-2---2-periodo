#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>

bool checarPalindromo(char *linha)
{

    char inversa[999] = "";
    int tamanhoLinha = strlen(linha);
    int numChar = 0;
    for (int i = (tamanhoLinha-1); i >= 0; i--)
    {

        inversa[numChar] = linha[i];

        numChar++;

      //  numChar++;
    }




    if (strcmp(inversa, linha)==0)
    {

        return true;
    }
    else
    {

        return false;
    }
}

bool isFim(char *str)
    {
        
        printf("%s", str);
        
        if((str[0] == 'F') && (str[1] == 'I') && (str[2] == 'M'))
        {
            return true;
        }
        else
        {
            return false;
        }
    } 


int main(void)
{
    char linha[999] = "";

    do
    {

        scanf(" %[^\n]s", linha);
        if (checarPalindromo(linha) == true)
        {
             printf("SIM\n");
        }
        else
        {
             printf("NAO\n");
        }
        strcpy(linha, "");
    } while ((linha[0]!='F')&&(linha[1]!='I')&&(linha[2]!='M'));

    return 0;
}

