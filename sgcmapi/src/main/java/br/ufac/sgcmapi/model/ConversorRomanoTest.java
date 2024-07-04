package br.ufac.sgcmapi.model;

import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;

public class ConversorRomanoTest {
    ConversorRomano conversor;
    @BeforeEach
   public void setUp(){
    conversor = new ConversorRomano();
   }
   @Test
   public void testUmAlgarismo(){
    assertEquals(5, conversor.converte('V'));
   }
   @Test 
   public void testVariosAlgarismos(){
    assertEquals(8,conversor.converte('VIII'));
   }
   public void testAlgarismoSubtrativo(){
    assertEquals(8,conversor.converte(''))
   }
 }  
