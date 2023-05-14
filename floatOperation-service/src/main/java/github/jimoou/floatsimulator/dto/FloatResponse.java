package github.jimoou.floatsimulator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FloatResponse {
    private String binaryValue1;
    private String binaryToFloatValue1;
    private String binaryValue2;
    private String binaryToFloatValue2;
    private String result;
    private String originalResult;
    private String computationalSpeed;
    private String usageMemory;
}
