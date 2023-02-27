package UHDBONF.domain.dto;

import lombok.Data;

@Data
public class BreadDto {
    private BreadType type;
    private String body;
    private String cream;
    private int top;
    private int deco;
    private String decoColor;

    public BreadDto() {
    }
}
