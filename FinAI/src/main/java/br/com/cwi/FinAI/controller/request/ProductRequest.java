package br.com.cwi.FinAI.controller.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequest {

    private String name;

    private String category;

    private String technicalDescription;

    private String humanizedDescription;

    private String targetProfile;

    private String rules;

    private String rates;

}
