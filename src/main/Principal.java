package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
	// VARIAVEIS GLOBAIS
    static SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    public static Scanner sc = new Scanner(System.in);
    
    // MÉTODO PRINCIPAL (MAIN)
    public static void main(String[] args) throws ParseException{
    	int op=0;
    	//carregaLista();
		do{
			op = mostraMenu();
			switch (op)
			{
			case 1:
				System.out.println("Pesquisa Pessoa");
				Pessoa p = pesquisaPessoa();
				if(p != null){
					System.out.println("Achei a pessoa!");
					System.out.println(p.getNome());
				}else{
					System.out.println("Pessoa não encontrada!");
				}
				break;
			case 2:
				System.out.println("Cadastro");
				Pessoa pes = new Pessoa();
				pes.setNome("Godofredo Ariovaldo das Neves");
				pes.setRg("986532");
				pes.create();
				
				break;
			case 3:
				System.out.println("Alterar");
				break;
			case 4:
				System.out.println("Lista");
				break;
			case 5:
				System.out.println("Deletar");
				break;
			case 99:
				System.out.println("Adeus!");
				default:
                break;
            }            
        }while(op != 99);
    }

	public static int mostraMenu(){

		System.out.println("#### MENU ####");
		System.out.println("Escolha uma das opcoes e aperte ENTER (99 para sair): ");

		System.out.println("1- Pesquisar Pessoas");
		System.out.println("2- Cadastrar Pessoa");
		System.out.println("3- Alterar cadastro");
		System.out.println("4- Lista de Cadastros");
		System.out.println("5- Deletar Pessoa");

		int op = sc.nextInt();

		return op;

	}
        
	public static Pessoa pesquisaPessoa(){
		
		Pessoa p = new Pessoa();
		System.out.println("Informe o RG para busca: ");
		String busca = sc.next();
		for(Pessoa x: listaPessoas){
			if(x.getRg().equalsIgnoreCase(busca)){
				return x;
			}
		}            	System.out.println("Registro inserido com sucesso!");

		
		return null;
	}
	
	public static void carregaLista() {
		System.out.println("Carregando dados...");
        Connection conn = Tool.getConnection();
        if(conn != null){
            try {
                
                // Aqui pega os dados das pessoas!
                String query = "select * from pessoas";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next()){
                	listaPessoas.add(new Pessoa(rs.getString("nome"), null, rs.getString("rg")));
                }
            	//carregaLista();
    
/*                String queryy = "select * from animal";
                Statement st1 = conn.createStatement();
                ResultSet res = st1.executeQuery(queryy);
                while(res.next()){
                    System.out.println(res.getInt(1));
                    System.out.println(res.getString("nome"));
                    Pessoa p = new Pessoa("Gustavo", null);
                    System.out.println(p.toString());
                }*/
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Deu caca na conexao!");
        }
        
		
	}
   
}