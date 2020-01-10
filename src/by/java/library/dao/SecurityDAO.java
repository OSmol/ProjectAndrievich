package library.dao;

import library.bean.Security;

import java.util.Map;

public interface SecurityDAO {
    public Map<String, String> registerUser(Security security);
}
