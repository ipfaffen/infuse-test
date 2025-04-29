package com.infuse.test;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.infuse.test.api.CreditoApi;
import com.infuse.test.response.CreditoResponse;
import com.infuse.test.service.CreditoService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

public class CreditoApiTests {

    private MockMvc mockMvc;

    @Mock
    private CreditoService service;

    @InjectMocks
    private CreditoApi api;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(api).build();
    }

	private static final String ENDPOINT_LIST = "/creditos/{numeroNfse}";
	private static final String ENDPOINT_GET = "/creditos/credito/{numeroCredito}";
	private static final String NUMERO_NFSE = "12345";
	private static final String NUMERO_CREDITO = "54321";

    @Test
    public void testListFound() throws Exception {
        var creditos = Collections.singletonList(
			CreditoResponse.builder().numeroCredito(NUMERO_CREDITO));
		
		when(service.listByNumeroNfse(NUMERO_NFSE)).thenReturn(creditos);

		mockMvc.perform(get(ENDPOINT_LIST, NUMERO_NFSE)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("size()", CoreMatchers.is(creditos.size())))				
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].numeroCredito", CoreMatchers.is(NUMERO_CREDITO)));
    }

    @Test
    public void testListEmpty() throws Exception {
        var creditos = Collections.singletonList(
			CreditoResponse.builder().numeroCredito(NUMERO_CREDITO));
		
		when(service.listByNumeroNfse(NUMERO_NFSE)).thenReturn(creditos);

		mockMvc.perform(get(ENDPOINT_LIST, "00000")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("size()", CoreMatchers.is(0)));
    }

	@Test
    public void testGetFound() throws Exception {
        var credito = CreditoResponse.builder().numeroCredito(NUMERO_CREDITO);
		
		when(service.getByNumeroCredito(NUMERO_CREDITO)).thenReturn(credito);

		mockMvc.perform(get(ENDPOINT_GET, NUMERO_CREDITO)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("numeroCredito", CoreMatchers.is(NUMERO_CREDITO)));
    }

	/*@Test
    public void testGetNotFound() throws Exception {
        var credito = CreditoOutput.builder().numeroCredito(NUMERO_CREDITO);
		
		when(service.getByNumeroCredito(NUMERO_CREDITO)).thenReturn(credito);

		mockMvc.perform(get(ENDPOINT_GET, "00000")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
    }*/
}