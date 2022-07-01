#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char *str)
{

    if ((str[0] == 'F') && (str[1] == 'I') && (str[2] == 'M'))
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool isNumbers(char *linha) 
    {
        bool checkStatus = true;
        for (int i=0;i<strlen(linha);i++)
        {
            if((linha[i] >= '0' && linha[i] <= '9'))
            {
                checkStatus=true;
            }
            else
            {
                checkStatus=false;
                return checkStatus;
            }
        }
        return checkStatus;
    }

bool isVowels(char *linha) 
    {
        bool checkStatus = true;
        for (int i = 0; i < strlen(linha); i++) 
        {
            if (linha[i] == 'a' || linha[i] == 'e' || linha[i] == 'i' || linha[i] == 'o'|| linha[i] == 'u' || linha[i] == 'A' || linha[i] == 'E'|| linha[i] == 'I' || linha[i] == 'O' || linha[i] == 'U') 
            {
                checkStatus = true;
            } else 
            {
                checkStatus = false;
                return checkStatus;
            }
        }

        return checkStatus;
    }

bool isLetra(char x)
{
    bool ret1 = false;
    if (x >= 'A' && x <= 'Z' || x >= 'a' && x <= 'z')
        ret1 = true;

    return ret1;
}

bool isRoyalNumbers(char *linha)
{
    bool checkStatus = true;
    for (int i = 0; i < strlen(linha); i++)
    {
        if ((linha[i] >= '0' && linha[i] <= '9') || (linha[i] == ',' || linha[i] == '.'))
        {
            checkStatus = true;
        }
        else
        {
            checkStatus = false;
            return checkStatus;
        }
    }
    return checkStatus;
}

bool isConsonants(char *linha)
{
    bool checkStatus = true;
    for (int i = 0; i < strlen(linha); i++)
    {
        if (linha[i] == 'a' || linha[i] == 'e' || linha[i] == 'i' || linha[i] == 'o' || linha[i] == 'u' || linha[i] == 'A' || linha[i] == 'E' || linha[i] == 'I' || linha[i] == 'O' || linha[i] == 'U')
        {
            checkStatus = false;
            return checkStatus;
        }
        else
        {
            checkStatus = true;
        }
    }
}


int main(void)
{
    char linha[999] = "";
    scanf(" %[^\n]s", linha);
    while (isFim(linha) == false)
        {
            if (isVowels(linha) == true)
            {
                printf("SIM ");
            }
            else
            {
                printf("NAO ");
            }
            
            if (isConsonants(linha) == true)
            {
                printf("SIM ");
            }
            else
            {
                printf("NAO ");
            }

            if (isNumbers(linha) == true)
            {
                printf("SIM ");
            }
            else
            {
                printf("NAO ");
            }

            if (isRoyalNumbers(linha) == true)
            {
                printf ("SIM\n");
            }
            else
            {
                printf ("NAO\n");
            }
            scanf(" %[^\n]s", linha);
        }
    return 0;
}