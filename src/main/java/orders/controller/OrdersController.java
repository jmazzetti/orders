package orders.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import orders.dto.OrderDTO;
import orders.exception.OrderException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OrdersController {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    @ApiOperation(value = "orders")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success order retrieved."),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found."),
            @ApiResponse(code = 500, message = "Internal server error. Description attached.")
    })
    @GetMapping(value = "orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity orders(@PathVariable("id") String id) throws OrderException, IOException {

        String orderMock = "{\n" +
                "  \"id\": 4392,\n" +
                "  \"salesOrderId\": 58943,\n" +
                "  \"purchaseOrderNumber\": \"PO234098\",\n" +
                "  \"billToID\": 3201,\n" +
                "  \"billToAddress\": \"Weerjis\\n4533 VW\\n\",\n" +
                "  \"shipToAddress\": \"Weerjis\\n4533 VW\\n\",\n" +
                "  \"shipMethod\": \"GENERIC-TL-STD\",\n" +
                "  \"buyerName\": \"Jeff Strange\",\n" +
                "  \"carrierAccount\": \"string\"\n" +
                "}";

        OrderDTO order = mapper.readValue(orderMock, OrderDTO.class);
        return ResponseEntity.ok(order);
    }
}