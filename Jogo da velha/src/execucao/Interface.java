package execucao;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Katarina
 */
public class Interface {

    private ControladorDeJogo cntrl;
    private Scanner scanner;

    public Interface(ControladorDeJogo cntrl, Scanner scanner) {
        this.cntrl = cntrl;
        this.scanner = scanner;
    }

    private void mostraMenuInicial() {
        System.out.println("+---------------------------+\n"
                + "|       JOGO DA VELHA       |\n+---------------------------+");
        System.out.println("Jogador 1, escolha um símbolo\n"
                + "(1) - X    (2) - O\nOpção:");

        int escolha = 0;

        try {

            do {
                escolha = scanner.nextInt();

                if (escolha != 1 && escolha != 2) {
                    System.err.println("Digite apenas 1 ou 2!");
                }
            } while (escolha != 1 && escolha != 2);

        } catch (InputMismatchException e) {
            System.err.println("Escolha 1 para o X e 2 para o O. Não digite letras!");
        }

        cntrl.setaSimboloJogador(escolha);
    }

    private void mostraPainelJogo() {

        int vez = 1;
        int coordenada;

        boolean fezJogada;
        boolean ganhou = false;

        while (!cntrl.getJogo().getTab().estaCheio() ^ ganhou) {
            System.out.println("Jogador "+ vez + ", escolha uma coordenada:\n--------------");
            cntrl.geraTabuleiroImpresso();
            System.out.println("--------------");
            
            do {
                coordenada = scanner.nextInt();

                if (coordenada < 1 || coordenada > 9) {
                    System.err.println("Escolha coordenadas entre 1 e 9");
                }

            } while (coordenada < 1 || coordenada > 9);

            if (vez == 1) {
                fezJogada = cntrl.fezJogada(cntrl.getJogo().getJogador1().escolherPeca(coordenada));
                
                if(fezJogada = true){
                    ganhou = cntrl.verificaSeGanhou(cntrl.getJogo().getJogador1().getSimbolo());
                }                
                vez++;
            } else {
                fezJogada = cntrl.fezJogada(cntrl.getJogo().getJogador2().escolherPeca(coordenada));
                
                if(fezJogada = true){
                    ganhou = cntrl.verificaSeGanhou(cntrl.getJogo().getJogador2().getSimbolo());
                }
                
                vez--;
            }
            
            if(ganhou){
                System.out.println("-------------");
                cntrl.geraTabuleiroImpresso();
                System.out.println("-------------");
                System.out.println("Parabéns!!!");
            }
            
            if(cntrl.getJogo().getTab().estaCheio()){
                System.out.println("Velha!!!");
            }
            
        }
    }
    
    public void executa(){
        boolean jogarNovamente = true;
        
        while(jogarNovamente){
            mostraMenuInicial();
            mostraPainelJogo();
            
            System.out.println("--------------\nJogar novamente?\n(1) - Sim   (2) - Não\n--------------");
            int escolha = 0;
            
            try{
                
                do{
                    escolha = scanner.nextInt();
                    
                    if(escolha != 1 && escolha != 2){
                        System.err.println("Escolha 1 para sim e 2 para não!");
                    }
                }while(escolha != 1 && escolha != 2);
                
            }catch(InputMismatchException e){
                System.err.println("Digite 1 ou 2, apenas!");
            }
            
            jogarNovamente = escolha == 1;
            
        }
    }

    public static void main(String[] args) {
        Interface i = new Interface(new ControladorDeJogo(), new Scanner(System.in));
        i.executa();
    }
}

