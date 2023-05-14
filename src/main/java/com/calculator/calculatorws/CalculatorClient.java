package com.calculator.calculatorws;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorClient extends WebServiceGatewaySupport {

    public AddResponse getAddResponse(int a, int b, String soapAction) {
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);
        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request,new SoapActionCallback(soapAction) );
        return response;
    }

    public SubtractResponse getSubtractResponse(int a, int b, String soapAction) {
        Subtract subtractRequest = new Subtract();
        subtractRequest.setIntA(a);
        subtractRequest.setIntB(b);
        SubtractResponse subtractResponse = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(subtractRequest,new SoapActionCallback(soapAction) );
        return subtractResponse;
    }

    public DivideResponse  getDivideResponse(int a, int b, String soapAction) {
        Divide divideRequest = new Divide();
        divideRequest.setIntA(a);
        divideRequest.setIntB(b);
        DivideResponse divideResponse = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(divideRequest,new SoapActionCallback(soapAction) );
        return divideResponse;
    }
    public MultiplyResponse  getMultiplyResponse(int a, int b, String soapAction) {
        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setIntA(a);
        multiplyRequest.setIntB(b);
        MultiplyResponse multiplyResponse = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(multiplyRequest,new SoapActionCallback(soapAction) );
        return multiplyResponse;
    }


}
