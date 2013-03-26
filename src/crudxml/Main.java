package crudxml;

import java.sql.Date;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        adiciona();
        
        login(3);
        
        ContatoCrudXML contato = new ContatoCrudXML();
        boolean login = contato.autenticaUsuario(3, "senha3");
       if (login == false) {
            JOptionPane.showMessageDialog(null, "Usuario/Senha invalido");
        } else {
            JOptionPane.showMessageDialog(null, "Bem-Vindo");
    }
    }

    

    static void adiciona() {
        ContatoCrudXML contatoCrudXML = new ContatoCrudXML();
        String[] nomes = {"Fulano", "Beltrano", "Ciclano"};
        String[] senhas = {"senha1", "senha2", "senha3"};
        String[] fones = {"(47) 2222-1111", "(47) 7777-5555", "(47) 9090-2525"};
        String[] emails = {"fulano@teste.com.br", "beltrano@teste.com.br", "ciclano@teste.com.br"};
        String[] observacoes = {"Novo cliente", "Cliente em dia", "Ligar na quinta"};
        Contato contato = null;

        for (int i = 0; i < nomes.length; i++) {
            contato = new Contato();
            contato.setNome(nomes[i]);
            contato.setSenha(senhas[i]);
            contato.setTelefone(fones[i]);
            contato.setEmail(emails[i]);
            contato.setDataCadastro(new Date(System.currentTimeMillis()));
            contato.setObservacao(observacoes[i]);
            contatoCrudXML.salvar(contato);
        }
        System.out.println("Total de registros cadastrados: " + contatoCrudXML.listar().size());
    }

    static void login(int codigo) {
        ContatoCrudXML contato = new ContatoCrudXML();
        Contato lista = contato.buscaContato(codigo);
        System.out.println(lista.getCodigo());
        System.out.println(lista.getNome());
        System.out.println(lista.getSenha());
        System.out.println(lista.getTelefone());
        System.out.println(lista.getEmail());
        System.out.println(lista.getObservacao());
    }
}
