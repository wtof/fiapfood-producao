package br.com.fiapfood.pagamento.infra.config;

import br.com.fiapfood.producao.application.exceptions.ApplicationException;
import br.com.fiapfood.producao.application.payload.response.ErrorResponse;
import br.com.fiapfood.producao.domain.exceptions.DominioException;
import br.com.fiapfood.producao.infra.config.GlobalExceptionHandler;
import br.com.fiapfood.producao.infra.exceptions.InfraException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    @Test
    void testHandleException() {
        Exception ex = new Exception();
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity response = handler.handleException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testHandleApplicationException() {
        ApplicationException ex = new ApplicationException("Application exception");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity response = handler.handleApplicationException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Application exception", ((ErrorResponse) response.getBody()).getMessage());
    }

    @Test
    void testHandleDominioException() {
        DominioException ex = new DominioException("Domain exception");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity response = handler.handleDominioException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Domain exception", ((ErrorResponse) response.getBody()).getMessage());
    }

    @Test
    void testHandleInfraExceptionException() {
        InfraException ex = new InfraException("Infrastructure exception");
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity response = handler.handleInfraExceptionException(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Infrastructure exception", ((ErrorResponse) response.getBody()).getMessage());
    }
}