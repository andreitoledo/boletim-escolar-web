package br.com.andreitoledo.boletim.util.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 *Gerador de tabelas no banco de dados
 */

public class GeraTabelas {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("AndreiToledoPU");

        factory.close();
    }
}

