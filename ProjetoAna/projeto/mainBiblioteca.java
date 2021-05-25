package projeto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class mainBiblioteca{
        
	public static void main(String[] args){
		
                Biblioteca biblio = new Biblioteca();

                JOptionPane.showMessageDialog(null, "* Bem-vindo ao Programa Biblioteca !\n"+
                        "* Cadastro de Livros com Consulta do Acervo Cadastrado\n"+
                        "* Aplicado para efeitos did�ticos de Programa��o Orientada a Objetos\n"+
                        "* Autor: Newton Gomes (Vers�o 2016)", 
                        "Programa Biblioteca - 2016", JOptionPane.INFORMATION_MESSAGE);
                
                biblio.setNome(JOptionPane.showInputDialog("Nome da Biblioteca:"));
                biblio.setLocal(JOptionPane.showInputDialog("Localiza��o da Biblioteca:"));
                
                Livro livro;
                ArrayList<Livro> listaLivros;
                int opcao = 0, cont;
                String opcoes = 
                  "Biblioteca: "+biblio.getNome()+
                  "\nLocaliza��o: "+biblio.getLocal()+
                  "\n\n***Op��es*** "+
                  "\n1. Cadastrar Livro"+
                  "\n2. Pesquisar Livro (c�digo)"+
                  "\n3. Pesquisar Livro (t�tulo)"+
                  "\n4. Listar Livros"+
                  "\n5. Informa��es"+
                  "\n6. Finalizar"+
                  "\n\nSelecione a op��o: ";

                while (opcao != 6) 
                {
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,opcoes,
                                        "Biblioteca "+biblio.getNome(),JOptionPane.QUESTION_MESSAGE));
                
                        switch(opcao)
                        {
                          case 1:
                              try {
                                biblio.incluirLivro(digitarLivro());                                  
                              }
                              catch(NullPointerException ex){
                                  ex.printStackTrace();
                              }
                              catch(ArrayIndexOutOfBoundsException ex){
                                  
                              }
                              catch(Exception ex){
                                  
                              }
                                JOptionPane.showMessageDialog(null, "Livro Cadastrado!\nTotal: "+
                                                biblio.getQuantidade()+" livro(s)");
                                break;
                          case 2:
                                  livro = biblio.obterLivro(Integer.parseInt(
                                                  JOptionPane.showInputDialog("Digite c�digo para pesquisar:")));
                                  if (livro != null)
                                          mostrarLivro(livro,biblio.getNome());
                                  else
                                          JOptionPane.showMessageDialog(null, "Livro N�o Localizado!");
                                break;
                          case 3:
                                  listaLivros = biblio.obterLivro(JOptionPane.showInputDialog("Digite T�tulo do Livro para pesquisar:"));
                                  cont = 0;
                                  if (listaLivros.size() > 0){
                                          for(Livro liv : listaLivros){
                                                  cont++;
                                                  mostrarLivro(liv,biblio.getNome() + 
                                                          " "+cont+" / "+listaLivros.size());
                                          }
                                  }
                                  else
                                          JOptionPane.showMessageDialog(null, "T�tulo de Livro N�o Localizado!");
                                  break;
                          case 4:{
                                  StringBuffer lista = new StringBuffer();
                                  lista.append("Lista de Livros Cadastrados:\n");
                                  for (int i=0;i<biblio.getQuantidade();i++)
                                  {
                                          livro = biblio.getLivro(i);
                                          lista.append(livro.getCodigo()+" - "+
                                                          livro.getTitulo()+" - "+livro.getAutor()+" - "+
                                                          livro.getNumPaginas()+" pags.\n");
                                  }
                                  lista.append("Total: "+biblio.getQuantidade()+" livro(s)");
                                  JOptionPane.showMessageDialog(null, lista.toString());
                                  break;
                          }
                          case 5:
                                        JOptionPane.showMessageDialog(null, "Informa��es da Biblioteca\n"+
                                                        "Nome da Biblioteca: "+biblio.getNome()+"\n"+
                                                        "Localiza��o: "+biblio.getLocal()+"\n"+
                                                        "Existem at� o momento\n"+biblio.getQuantidade()+
                                                        " livro(s) cadastrado(s)");
                                        break;
                        }
                }
            	JOptionPane.showInternalMessageDialog(null, "***** Fim do Programa *****" + "\n***Obrigado e Volte Sempre!***");
                //System.out.println("# Fim do Programa #");
                //System.out.println("bye...");
        }
        
        static Livro digitarLivro()
        {
                Livro liv = new Livro();
                liv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("C�digo do Livro:")));
                liv.setTitulo(JOptionPane.showInputDialog("T�tulo do Livro:"));
                liv.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));
                liv.setISBN(JOptionPane.showInputDialog("N�mero ISBN do Livro:"));
                liv.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("N�mero de P�ginas do Livro:")));
                liv.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Valor de Compra:")));
                return liv;
        }
        
        static void mostrarLivro(Livro x,String bib)
        {
                String texto = "Livro:\n"+
                "\nC�digo: "+x.getCodigo()+
                "\nT�tulo: "+x.getTitulo()+
                "\nAutor: "+x.getAutor()+
                "\nISBN: "+x.getISBN()+
                "\nP�ginas: "+x.getNumPaginas()+
                "\nValor: "+x.getValorCompra();
                JOptionPane.showMessageDialog(null, texto, "Biblioteca: "+bib,
                                JOptionPane.WARNING_MESSAGE);
        }

}