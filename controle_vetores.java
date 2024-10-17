
package AP_2semestre;
import java.util.Scanner;
import java.util.Random;

public class Atividade1_AlgoritmoseProgramaçãoII {

  public static void main(String[] args) {
    // Variáveis locais vazias ate a inicializacao do menu e declaração do usuário;
    int vetor[] = null;
    int opcao = 0;
    int tamanhoVetor;
    int maxNum;
    int verificaInicializacaoVetor = 0;

    // Inicialização do Scanner;
    Scanner leitor = new Scanner(System.in);

    do { // do while utilizado para o menu rodar ate o usuário escolher a opção de sair;

      menuApresenta();
      opcao = leitor.nextInt();

      
      if (verificaInicializacaoVetor == 0) { // if utilizado para verificar se o vetor foi inicializado, caso contrario informa que o vetor não foi inicializado e volta pro menu;
        while (opcao != 1 && opcao != 0) {
          System.out.println("OPÇÃO INVÁLIDA, O VETOR NAO FOI INICIALIZADO");
          System.out.println(" ");
          menuApresenta();
          opcao = leitor.nextInt();
        }
        verificaInicializacaoVetor++;
      }
      // switch utilizado para acessar as opções do menu;
      switch (opcao) {
        case 1: // case 1 recebe o tamanho do vetor junto com o maior numero dentro dele e o preenche com valores aleatórios;
          System.out.println("Insira o tamanho do vetor desejado:");
          tamanhoVetor = leitor.nextInt(); // recebe o tamanho do vetor;
          System.out.println("Insira um valor inteiro para que seja o maior número que o vetor pode ter: ");
          maxNum = leitor.nextInt(); // recebe o maior numero possível no vetor;
          System.out.println("");
          vetor = inicializaVetor(tamanhoVetor, maxNum); // chama a função para inicializar o vetor;
          System.out.println("");
          ;
          break;

        case 2: // case 2 imprime o vetor;

          System.out.println("");
          imprimirVetor(vetor); // função que imprime o vetor;
          System.out.println("");
          break;

        case 3: // case 3 verifica todas posições do vetor e encontra o valor, caso exista no vetor;

          System.out.println("Digite um número para verificar se ele existe no vetor");
          int numeroDesejado = leitor.nextInt(); // valor inserido pelo usuário;
          int retornoVerificaPresencaNum = verificaPresencaNumero(numeroDesejado, vetor); // variavel que recebe o retorno da função;

          if (retornoVerificaPresencaNum == -1) { // if else utilizado para o valor existentente retornaro valor ou nao existente retornar -1, e informar ao usuário;
            System.out.println(retornoVerificaPresencaNum + "\nO número não existe no vetor.");
          } else {
            System.out.printf("O número existe no indice:[%d]\n", retornoVerificaPresencaNum);
          }
          break;

        case 4: // Case 4 verifica o vetor e exibe o maior valor;

          int maiorValorVetor = verificaMaiorNumero(vetor); // Função que retorna o maior valor do vetor;
          System.out.printf("O maior número do vetor é: %d\n", maiorValorVetor);
          break;

        case 5: // Case 5 verifica o vetor, e exibe a media dos numeros pares existentes;

          double mediaPares = verificaMediaPares(vetor); // Função que retorna a media dos numeros pares do vetor;
          System.out.printf("A média dos números pares é: %.2f", mediaPares);
          System.out.println("");
          break;

        case 6: // Case 6 verifica o vetor e exibe a media dos numeros impares existentes;

          double mediaNumerosImpares = verificaMediaImpares(vetor); // Chama a função que retorna a media dos numeros impares do vetor;
          System.out.printf("A média dos números Impares é: %.2f%%", mediaNumerosImpares);
          System.out.println("");
          break;

        case 7: // Case 7 verifica o vetor e exibe a media centralizada do vetor, que consiste em desconsiderar o maior e o menor valor e fazer a media dos valores centrais;

          double mediaCentralizada = verificaMediaCentralizada(vetor); // Chama a função que retorna a media centralizada do vetor;

          if (mediaCentralizada > 0) { // If else utilizado para verificar se a media centralizada é maior que 0, caso contrario informa ao usuário;
            System.out.printf("A média centralizada do vetor é:%.2f", mediaCentralizada);
            System.out.println("");
          } else {
            System.out.println("O vetor não possui media centralizada");
            System.out.println("");
          }
          break;

        case 8:// Case 8 pede ao usuário um valor e verifica se existe 2 numeros no vetor que somados dão o valor inserido;

          System.out
              .println("Insira o número desejado para verificar se existe dois valores no vetor que somados é igual: ");
          System.out.println("");
          int numeroAlvo = leitor.nextInt(); // Recebe o numero a ser verificado;
          System.out.println("");
          boolean p = numeroSomadoIgual(numeroAlvo, vetor); // Boolean utilizado para retornar true or false;

          if (p == true) { // If else verifica e imprimi o resultado;
            System.out.println(p + " == Existe dois números no vetor que somados retornam o valor desejado");
          } else {
            System.out.println(p + " == Não existe dois números no vetor que somados retornam o valor desejado");
          }
          break;

        case 0: // case 0 encerra o programa assim que o usuário escolher;

          System.out.println("programa encerrado");
          break;

        default: // Caso inserido algum numero nao correspondente ao menu, informa ao usuário;

          System.out.println("OPÇÃO INVÁLIDA");

      }
    } while (opcao != 0); // continua o programa enquanto o usuário não digitar 0;
    leitor.close(); // Fecha o leitor;
  }

  // metodo 1 : Inicializa o vetor com valores aleatórios;
  public static int[] inicializaVetor(int tamanhoVetor, int maxNum) {
    Random numeroAleatorio = new Random();
    int vetorResultante[] = new int[tamanhoVetor];

    for (int indice = 0; indice < vetorResultante.length; indice++) {
      vetorResultante[indice] = numeroAleatorio.nextInt(maxNum) + 1;
    }
    return vetorResultante;
  }

  /*comentários: inicializamos a função random e o vetor com o tamanho do vetor passado por parâmetro;
   * após a inicialização, criamos um laço para percorrer o vetor;
   * e guardamos o random no vetor, com o maior numero do vetor passado por parâmetro + 1, exemplo: maior numero 30 = (0 ao 29) + 1 == (0 ao 30);
   */

  // metodo 2 : Imprime o vetor;
  public static void imprimirVetor(int[] vetor) {
    System.out.println();
    for (int indice = 0; indice < vetor.length; indice++) {
      System.out.printf("[%d]", vetor[indice]);
    }
    System.out.println("");
  }

  // metodo 3 : Numero existente no vetor
  public static int verificaPresencaNumero(int verNumero, int[] vetor) {
    for (int indice = 0; indice < vetor.length; indice++) {
      if (vetor[indice] == verNumero) {
        return indice;
      }
    }
    return -1;
  }

  /*comentários: foi feito um laço para o vetor;
   * um if para verificar se o valor do vetor é igual ao valor recebido pelo usuário;
   * e retornamos a posição caso a condição for correta, se não retornamos um "-1", informando que não foi encontrado; 
   */

  // metodo 4 : Maior numero do vetor
  public static int verificaMaiorNumero(int[] vetor) {
    int auxMaior = vetor[0];

    for (int indice = 0; indice < vetor.length; indice++) {
      if (vetor[indice] > auxMaior) {
        auxMaior = vetor[indice];
      }
    }
    return auxMaior;
  }

  /*comentários: foi feito uma variável auxilixar para guardar o valor do vetor na 1° posição;
   * um laço para o vetor;
   * um if para verificar se o vetor na posição indice é maior que a variável auxiliar, e substituir o valor;
   * e retornamos a variável auxiliar
    */

  // metodo 5 : Media dos numeros pares;
  public static double verificaMediaPares(int[] vetor) {
    double soma = 0;
    int quantidadePar = 0;

    for (int i = 0; i < vetor.length; i++) {
      if (vetor[i] % 2 == 0) {
        soma = soma + vetor[i];
        quantidadePar++;
      }
    }
    double media = soma / quantidadePar; // Calcula a media dos numeros pares;
    return media;
  }

  /*comentários: foi feito um laço para percorrer o vetor;
   * um if para verificar se o vetor era par;
   * um acumulador soma, para guardar o valor total da soma dos números;
   * um contador da quantidade de numeros par;
   * e por fim retornamos o valor do cálculo guardado na variavel média;
   */

  // metodo 6 : Media dos numeros impares;
  public static double verificaMediaImpares(int[] vetor) {
    double porcentagemImpares = 0;

    for (int indice = 0; indice < vetor.length; indice++) {
      if (vetor[indice] % 2 == 1) {
        porcentagemImpares++;
      }
    }
    porcentagemImpares = porcentagemImpares * 100 / vetor.length;
    return porcentagemImpares;
  }

  /*comentários: utilizamos um laço para percorrer o vetor;
   * um if para verificar se o vetor era ímpar ;
   * um contador para guardar a quantidade de valores ímpar;
   * e retornamos o valor do calculo da porcentagem;
   */

  // metodo 7 : Media centralizada do vetor;
  public static double verificaMediaCentralizada(int[] vetor) {
    double maiorValor = vetor[0];
    double menorValor = vetor[0];
    double mediaCentralizada = 0;

    for (int indice = 0; indice < vetor.length; indice++) {
      if (vetor[indice] > maiorValor) {
        maiorValor = vetor[indice];
      }
    }
    for (int indice = 0; indice < vetor.length; indice++) {
      if (vetor[indice] < menorValor) {
        menorValor = vetor[indice];
      }
    }
    for (int indice = 0; indice < vetor.length; indice++) {
      mediaCentralizada = mediaCentralizada + vetor[indice];
    }
    mediaCentralizada = (mediaCentralizada - (maiorValor + menorValor)) / (vetor.length - 2);
    return mediaCentralizada;
  }
  /*
   * comentários: O metodo realizará as funções e calculará a media centralizada
   * dos valores, utilizamos 3 for, os 2 primeiros para identificar o maior e
   * menor valor do vetor e o 3° para percorrer e realizar o acumulador da média;
   * após esse passo, realizamos o calculo eliminando os valores e 2 posições.
   */

  // metodo 8 : Verifica se existe dois numeros no vetor que somados dão o valor inserido;
  public static boolean numeroSomadoIgual(int achaNumero, int[] vetor) {
    int variavelAuxiliarSoma = 0; //

    for (int indice = 0; indice < vetor.length; indice++) {
      for (int indice2 = 0; indice2 < vetor.length; indice2++) {
        if (indice2 != indice) {
          variavelAuxiliarSoma = 0;
          variavelAuxiliarSoma = vetor[indice] + vetor[indice2];
          if (variavelAuxiliarSoma == achaNumero) {
            return true;
          }
        }
      }

    }
    return false;
  }

  /*
   * comentários:
   * utilizamos um boolean para retornar o valor encontrado como true or false,
   * foi feito um for para percorrer o vetor e outro pra percorrer e comparar os
   * numeros das posições;
   * If feito para condicionar a função a só dar continuidade quando os valores
   * forem de indices diferentes;
   */

  // metod 9 : Guarda o menu de opções
  public static void menuApresenta() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println(" ");
    System.out.println("1-INICIALIZAR VETOR COM NUMEROS ALEATORIOS");
    System.out.println("2-IMPRIMIR VETOR");
    System.out.println("3-VERIFICAR POSSIVEL NUMERO EXISTENTE");
    System.out.println("4-BUSCAR O MAIOR NUMERO ARMAZENADO NO VETOR");
    System.out.println("5-CALCULAR MEDIA DOS NUMEROS PAR");
    System.out.println("6-CALCULAR PERCENTUAL DOS NÚMEROS IMPARES");
    System.out.println("7-CALCULAR MEDIA CENTRALIZADA DO VETOR");
    System.out.println("8-VERIFICAR SE 2 NUMEROS IGUAIS RESULTAM NO VALOR DADO");
    System.out.println("0-ENCERRAR PROGRAMA");
    System.out.println(" ");
    System.out.println("-----------------------------------------------------------------------");
  }
}