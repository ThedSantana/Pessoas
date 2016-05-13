package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Pessoa {
    
    private String	nome;
    private Date	dt_nascimento;
    private String	rg;
    
	public Pessoa(){}
    
    public Pessoa(String nome, Date dt_nascimento, String rg) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
    
    public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void create(){
		String ins = "insert into pessoas(nome, rg) values('" + this.nome + "', '" + this.rg + "')";
        Statement st;
		try {
			Connection conn = Tool.getConnection();
			st = conn.createStatement();
            if(st.executeUpdate(ins) == 1){
            	System.out.println("Registro inserido com sucesso!");
            }else{
            	System.out.println("Erro ao inserir o registro!");
            }
		} catch (SQLException e) {
			System.out.println("Erro ao inserir!!");
			System.out.println(e.getMessage());
		}
	}
	
    @Override
    public String toString() {
        return "Pessoa [nome=" + this.nome + ", dt_nascimento=" + this.dt_nascimento + ", rg=" + this.rg
                + "]";
    }
}
