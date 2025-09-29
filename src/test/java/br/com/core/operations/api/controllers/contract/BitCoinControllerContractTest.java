package br.com.core.operations.api.controllers.contract;

import br.com.core.operations.api.templates.AllQuotationsResponseTemplate;
import br.com.core.operations.api.templates.QuotationResponseTemplate;
import br.com.core.operations.core.interfaces.usecase.FindBitCoinQuotationUseCase;
import com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 8081)
class BitCoinControllerContractTest {

    private final String openApiSwaggerFilePath = "openapi.json";

    private static final String URL_USD = "/bitcoin-operations/quotation/USD";
    private static final String URL_ALL = "/bitcoin-operations/quotations";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindBitCoinQuotationUseCase findBitCoinQuotationUseCase;

    @Test
    void testFindUSDQuotationMatchesContract() throws Exception {
        when(findBitCoinQuotationUseCase.getQuotation(any()))
                .thenReturn(QuotationResponseTemplate.getQuotation());

        mockMvc.perform(get(URL_USD))
                .andExpect(status().isOk())
                .andExpect(OpenApiValidationMatchers.openApi()
                        .isValid(openApiSwaggerFilePath));
    }

    @Test
    void testGetAllQuotationsMatchesContract() throws Exception {

        when(findBitCoinQuotationUseCase.getAll())
                .thenReturn(AllQuotationsResponseTemplate.getAllQuotations());


        mockMvc.perform(get(URL_ALL))
                .andExpect(status().isOk())
                .andExpect(OpenApiValidationMatchers.openApi()
                        .isValid(openApiSwaggerFilePath))
                .andDo(print());
    }



}
