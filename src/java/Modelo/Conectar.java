package Modelo;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
    private static DriverManagerDataSource dataSource;
    private Conectar(){}
    
    public static DriverManagerDataSource conectar(){
        
        if(dataSource==null){
        dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Oracle");
        dataSource.setUrl("jdbc:oracle:thin:@//localhost/dbmonitoreovih");
        dataSource.setUsername("BOLSA_TRABAJO");
        dataSource.setPassword("BOLSA_TRABAJO");
        
        }
        return dataSource;
    }
}
