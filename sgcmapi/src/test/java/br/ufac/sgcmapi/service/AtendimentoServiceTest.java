package br.ufac.sgcmapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.EStatus;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@ExtendWith(MockitoExtension.class)
public class AtendimentoServiceTest {
    @Mock
    private AtendimentoRepository repo;

    @InjectMocks
    private AtendimentoService servico;
    Atendimento a1;
    Atendimento a2;
    List<Atendimento> atendimentos;

    @BeforeEach
    public void setUp() {
        a1 = new Atendimento();
        a2 = new Atendimento();
        a1.setId(1L);
        a2.setId(2L);
        a1.setHora(LocalTime.of(14,00));
        a2.setHora(LocalTime.of(15,00));
        atendimentos = new ArrayList<>();
        atendimentos.add(a1);
        atendimentos.add(a2);

    }

    @Test
     public void testAtendimentoDelete() {
      Mockito.doNothing().when(repo).deleteById(1L);
      repo.deleteById(1L);
      Mockito.verify(repo, Mockito.times(1)).deleteById(1L);
         //tarefa de casa
    }

    @Test
    public void testAtendimentoGetAll() {
        Mockito.when(repo.findAll()).thenReturn(atendimentos);
        List<Atendimento> result = servico.get();
        assertEquals(2, result.size());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    void testAtendimentoGetbyId() {
        Mockito.when(repo.findById(1L)).thenReturn(null);
        List<Atendimento> result = servico.get();
        assertEquals(2, result.size());
        assertEquals(2L, result.get(1).getId());

    }

    @Test
    void testAtendimentoGetTermoBusca() {
        Mockito.when(repo.busca(null)).thenReturn(atendimentos);
        List<Atendimento> result = servico.get();
        assertEquals(atendimentos, result);
        verify(repo,(times(1)));


    }

    @Test
    void testGetHorarios() {
          //esqueci de copiar na aula 
        
    }

    @Test
    void testAtendimentoSave() {
    
    Mockito.when(repo.save());
     
    }

    @Test
    public void testUpdateStatus() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(a1));
        Atendimento result = servico.updateStatus(1l);
        assertNotNull(result);
        assertEquals(EStatus.CONFIRMADO, result.getStatus());
    }
}
