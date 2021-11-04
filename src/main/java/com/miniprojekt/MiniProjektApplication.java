package com.miniprojekt;

import com.miniprojekt.JDBCWriter.JDBCWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniProjektApplication {

  public static void main(String[] args) {
    SpringApplication.run(MiniProjektApplication.class, args);

    JDBCWriter jdbcWriter = new JDBCWriter();
    boolean hasCon = jdbcWriter.setConnection();
    boolean hasCon2 = jdbcWriter.setConnection2();
    System.out.println("Har con hasCon=" + hasCon);
    System.out.println("Har con hasCon=" + hasCon2);
  }

}
