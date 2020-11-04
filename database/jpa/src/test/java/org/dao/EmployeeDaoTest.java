package org.dao;

import org.domain.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock
    private EntityManager emMock;

    @InjectMocks
    private EmployeeDao target;

    @Mock
    private EntityTransaction transactionMock;

    @Mock
    private Employee employeeMock;

    @Test
    public void insert() {
        //given
        when(emMock.getTransaction()).thenReturn(transactionMock);

        //when
        target.insert(employeeMock);

        // then
        verify(transactionMock).begin();
        verify(emMock).persist(eq(employeeMock));
        verify(transactionMock).commit();
    }

    @Test
    void find() {
        //given
        long id = 356L;
        when(emMock.find(eq(Employee.class), eq(id))).thenReturn(employeeMock);

        //when
        Employee employee = target.get(id);

        //then
        verify(emMock).find(eq(Employee.class), eq(id));
    }
}