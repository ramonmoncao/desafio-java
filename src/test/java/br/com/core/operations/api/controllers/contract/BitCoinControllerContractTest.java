package br.com.core.operations.api.controllers.contract;

import com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BitCoinControllerContractTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindUSDQuotationMatchesContract() throws Exception {
        mockMvc.perform(get("/bitcoin-operations/quotation/USD"))
                .andExpect(status().isOk())
                .andExpect(OpenApiValidationMatchers.openApi()
                        .isValid("src/main/resources/openapi.json"));
    }

    @Test
    void testGetAllQuotationsMatchesContract() throws Exception {
        mockMvc.perform(get("/bitcoin-operations/quotations"))
                .andExpect(status().isOk())
                .andExpect(OpenApiValidationMatchers.openApi()
                        .isValid("src/main/resources/openapi.json"));
    }
}
