import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        char sexo, question;
        int codigo, masculino = 0, feminino = 0, idadec;
        double servico = 0;
        ArrayList<Integer> idade = new ArrayList<>();
        ArrayList<Integer> geral = new ArrayList<>();
        ArrayList<Character> sexo_1 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("Início da pesquisa!");






        
        while (true) {
            do {
                System.out.println("======================================");
                System.out.println("Qual seu objetivo no shopping?");
                System.out.println("1 para Compras");
                System.out.println("2 para Serviços");
                System.out.println("3 para lazer");
                System.out.println("4 para alimentação");
                System.out.println("Digite 5 para encerrar a pesquisa");
                System.out.println("======================================");

                codigo = sc.nextInt();

                if (codigo <= 0 || codigo >= 6) {
                    System.out.println("Insíra um código válido");
                }
            } while (codigo <= 0 || codigo >= 6);

            if (codigo == 5) {
                break;
            }

            if (codigo == 1) {
                geral.add(1);
            }
            if (codigo == 2) {
                servico++;
                geral.add(2);
            }
            if (codigo == 3) {
                geral.add(3);
            }
            if (codigo == 4) {
                geral.add(4);
            }

            do {
                System.out.println("======================================");
                System.out.println("Qual sua idade?");
                System.out.println("======================================");
                idadec = sc.nextInt();
                idade.add(idadec);
                if (idadec < 0) {
                    System.out.println("Insíra uma idade válida");
                }
            } while (idadec < 0);

            do {
                System.out.println("======================================");
                System.out.println("Qual seu sexo? M/F");
                System.out.println("======================================");
                sexo = Character.toUpperCase(sc.next().charAt(0));

                sexo_1.add(sexo);

                if (sexo == 'M') {
                    masculino++;
                } else {
                    feminino++;
                }
                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Insíra um sexo válido");
                }
            } while (sexo != 'M' && sexo != 'F');
        }

        if (geral.size() >= 1) {
            System.out.println("==============RESULTADO===============");
            System.out.println("A quantidade de pessoas que busca serviço em relação ao geral é "
                    + ((double) servico / geral.size() * 100) + "%");

            if (masculino == feminino) {
                System.out.println("A quantidade de homens e mulheres são iguais");
            } else if (masculino > feminino) {
                System.out.println("A quantidade de homens é maior que a de mulheres");
            } else {
                System.out.println("A quantidade de mulheres é maior que a de homens");
            }

            System.out.println("============FIM=DA=PESQUISA===========");

            do {
                System.out.println("Deseja ver o detalhamento individual da faixa etárea e sexo dos clientes? Y/N");
                question = Character.toUpperCase(sc.next().charAt(0));
                if (question != 'Y' && question != 'N') {
                    System.out.println("Digite uma resposta válida");
                }
            } while (question != 'Y' && question != 'N');

            if (question == 'Y') {
                System.out.println("A idade e sexo das pessoas que respondeu a pesquisa, respectivamente, é: ");
                for (int i = 0; i < idade.size(); i++) {
                    System.out.print("Pessoa número " + (i + 1) + ": " + idade.get(i) + " anos de idade, do sexo ");
                    if (sexo_1.get(i) == 'M') {
                        System.out.print("masculino");
                    } else {
                        System.out.print("feminino");
                    }
                    System.out.println(", e o código selecionado foi " + geral.get(i));
                }
            }
        }
        System.out.println("Finalizado.");
        sc.close();
    }
}