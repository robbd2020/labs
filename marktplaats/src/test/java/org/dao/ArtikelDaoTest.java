package org.dao;

import org.domain.Artikel;
import org.domain.Gebruiker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.Arrays;
import java.util.HashSet;

import static org.domain.Bezorgwijze.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtikelDaoTest {

    @Mock
    private EntityManager emMock;

    @InjectMocks
    private ArtikelDao target;

    @Mock
    private TypedQuery<Artikel> tqMock;

    @Test
    void zoekAlleArtikelen() {
        //given
        when(emMock.createNamedQuery(anyString(), eq(Artikel.class))).thenReturn(tqMock);
        //when
        target.vindAlleBeschikbare();
        //then
        verify(emMock).createNamedQuery(anyString(), eq(Artikel.class));
        verify(tqMock).getResultList();
    }

    @Test
    void zoekInAlleBeschikbare() {
        //given
        String naam = "test";
        when(emMock.createNamedQuery(anyString(), eq(Artikel.class))).thenReturn(tqMock);
        when(tqMock.setParameter(anyInt(), anyString())).thenReturn(tqMock);
        //when
        target.zoekInAlleBeschikbare(naam);
        //then
        verify(emMock).createNamedQuery(anyString(), eq(Artikel.class));
        verify(tqMock).setParameter(eq(1), contains(naam));
        verify(tqMock).setParameter(eq(2), contains(naam));
        verify(tqMock).getResultList();
    }


}
