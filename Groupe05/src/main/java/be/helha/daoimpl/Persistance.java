package be.helha.daoimpl;

import be.helha.dao.Dao;

import java.util.HashSet;
import java.util.Set;

public class Persistance implements Dao {

    private Set<String> daos = new HashSet<>();
    private String url;

    public Persistance() {
        super();
    }

    public Dao getDaoImpl(Class<? extends Dao> interfaceDao) {
        Dao dao = null;
        Class<Dao> classeDaoImpl;
        Class<?>[] interfaces;
        try {
            for (String nomDaoImpl : daos) {
                classeDaoImpl = (Class<Dao>) Class.forName(nomDaoImpl);
                interfaces = (Class<?>[]) classeDaoImpl.getInterfaces();
                for (Class<?> i : interfaces) {
                    if (i.getName().equals(interfaceDao.getName())) {
                        dao = (Dao) classeDaoImpl.getDeclaredConstructor().newInstance();
                        return dao;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public int getNbDaos() {
        return this.daos.size();
    }
}
