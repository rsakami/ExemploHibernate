package crudannotations;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.HibernateUtil;
import crudxml.Contato;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ContatoCrudAnnotations {

    public void salvar(ContatoAnnotations contato) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(contato);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi poss�vel inserir o contato. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar opera��o de inser��o. Mensagem: " + e.getMessage());
            }
        }
    }

    public void atualizar(ContatoAnnotations contato) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(contato);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi poss�vel alterar o contato. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e.getMessage());
            }
        }
    }

    public void excluir(ContatoAnnotations contato) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(contato);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("N�o foi poss�vel excluir o contato. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar opera��o de exclus�o. Mensagem: " + e.getMessage());
            }
        }
    }

    public List<ContatoAnnotations> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<ContatoAnnotations> resultado = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from ContatoAnnotations");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("N�o foi poss�vel selecionar contatos. Erro: " + e.getMessage());
            throw new HibernateException(e);
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
            }
        }
    }

    public ContatoAnnotations buscaContato(int valor) {
        ContatoAnnotations contato = null;
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Contato where codigo = :parametro");
            consulta.setInteger("parametro", valor);
            contato = (ContatoAnnotations) consulta.uniqueResult();
            transacao.commit();
            return contato;
        } catch (HibernateException e) {
            System.out.println("N�o foi poss�vel buscar contato. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar opera��o de buscar. Mensagem: " + e.getMessage());
            }
        }
        return contato;
    }
    
   }
