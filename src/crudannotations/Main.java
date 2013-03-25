package crudannotations;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //adicionaContato();
        ContatoCrudAnnotations contato = new ContatoCrudAnnotations();
        
        

    }
  
    static void adicionaContato() {

        ContatoCrudAnnotations contatoCrudAnnotations = new ContatoCrudAnnotations();
        String[] nomes = {"Solanu", "Lunare", "Venusiana"};
        String[] fones = {"(47) 3333-4444", "(47) 7777-5555", "(47) 9090-2525"};
        String[] emails = {"solanu@javapro.com.br", "lunare@javapro.com.br", "venusiana@javapro.com.br"};
        String[] observacoes = {"Novo cliente", "Cliente em dia", "Ligar na sexta"};
        ContatoAnnotations contatoAnnotations = null;

        for (int i = 0; i < nomes.length; i++) {
            contatoAnnotations = new ContatoAnnotations();
            contatoAnnotations.setNome(nomes[i]);
            contatoAnnotations.setTelefone(fones[i]);
            contatoAnnotations.setEmail(emails[i]);
            contatoAnnotations.setDataCadastro(new Date(System.currentTimeMillis()));
            contatoAnnotations.setObservacao(observacoes[i]);
            contatoCrudAnnotations.salvar(contatoAnnotations);
        }
        System.out.println("Total de registros cadastrados: " + contatoCrudAnnotations.listar().size());
    }
    
             
    }
